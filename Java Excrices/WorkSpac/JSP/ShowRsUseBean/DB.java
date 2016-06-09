import java.sql.*;
public class DB {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=scsjk","my","123");
		}catch(ClassNotFoundException e) {
			System.out.println("数据库驱动加载出错");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("数据库连接出错conn");
		}
		System.out.println("数据库驱动加载成功");
		return conn;
	}
//=========================================================================================================	
	@SuppressWarnings("unused")
	public static Statement getrstatement(Connection conn) {
		Statement stmt = null;
		try {
			if(conn != null) {
				stmt = conn.createStatement();
			}
		}catch(SQLException e) {
			System.out.println("数据库连接出错stmt");
			e.printStackTrace();
		}
		System.out.println("数据库连接成功");
		return stmt;
	}
//=========================================================================================================	
	@SuppressWarnings("unused")
	public static ResultSet getresultset(Statement stmt,String sql) {
		ResultSet rs = null;
		try{
			if (stmt != null) {
				 rs = stmt.executeQuery(sql);
			}
		}catch (SQLException e) {
			System.out.println("数据库命令出错rs");
			e.printStackTrace();
		}
		System.out.println("数据库命令执行成功");
		return rs;
	}
//=========================================================================================================	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}catch(SQLException e){
			System.out.println("数据库关闭时出错conn");
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
		}catch(SQLException e) {
			System.out.println("数据库关闭时出错stmt");
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		}catch(SQLException e) {
			System.out.println("数据库关闭时出错rs");
			e.printStackTrace();
		}
	}
}
