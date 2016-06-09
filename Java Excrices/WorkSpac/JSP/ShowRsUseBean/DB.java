import java.sql.*;
public class DB {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=scsjk","my","123");
		}catch(ClassNotFoundException e) {
			System.out.println("���ݿ��������س���");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("���ݿ����ӳ���conn");
		}
		System.out.println("���ݿ��������سɹ�");
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
			System.out.println("���ݿ����ӳ���stmt");
			e.printStackTrace();
		}
		System.out.println("���ݿ����ӳɹ�");
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
			System.out.println("���ݿ��������rs");
			e.printStackTrace();
		}
		System.out.println("���ݿ�����ִ�гɹ�");
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
			System.out.println("���ݿ�ر�ʱ����conn");
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
			System.out.println("���ݿ�ر�ʱ����stmt");
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
			System.out.println("���ݿ�ر�ʱ����rs");
			e.printStackTrace();
		}
	}
}
