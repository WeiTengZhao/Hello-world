import java.sql.*;
import sun.jdbc.odbc.JdbcOdbcDriver;

public class TestDataBase {
	public static void main(String[] args) throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:PIMS");	
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * From 表1");
		while(rs.next()){
			String s = ( rs.getString("ID") + " " +rs.getString("名称") + " " +rs.getString("价格") + " " +rs.getString("生产日期") );
			System.out.println(s);
		}
		
		rs.close();
		con.close();
	}
}