

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowRs")
public class ShowRs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=scsjk";
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//=============================================================================================================
		try {
			Class.forName(JDriver);
		}catch(ClassNotFoundException e) {
			out.println("��������ʧ��");
			e.printStackTrace();
		}
			out.println("�������سɹ�");
//===========================================================================================================
		try{
			String username = "my"; //�������ݿ�ʹ�õ��û���
			String password = "123"; //�������ݿ�ʹ�õ�����
			con = DriverManager.getConnection(connectDB,username,password);//�������ݿ�����
			out.println("���ݿ����ӳɹ�");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from sc");
			out.print("<html>\n"
					+	"<head><title>Servlet�������ݿ�</title></head>\n"
					+ 	"<body>\n"
					+		"<Center><table BGCOLOR = '66ccff' >\n"
					+			"<tr><th><h1>ShowRs<h1><th></tr>\n"
					+				"<tr><td>ѧ��</td></tr>\n"
					);
			while (rs.next()) {
				out.println("<tr><td>"+rs.getString("sno")+"</td></tr>\n");
			}
			out.println("</table></Center></Body></html>");
		
		}
		 catch (SQLException e) {
			 out.println("���ݿ�����ʧ��");
			 e.printStackTrace();
		 }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
