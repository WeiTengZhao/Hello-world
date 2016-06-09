

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowRsUser")
public class ShowRsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		Connection conn = DB.getconnection();
		Statement stmt = DB.getrstatement(conn);
		ResultSet rs = DB.getresultset(stmt, "Select * from sc");
		out.println("<html>\n"
					+	"<head><title>ShowRsUser</title></head>\n"
					+	"<body BGCOLOR = '#66ccff'>\n"
					+		"<Center><table>"
					+ 			"<tr><th>Sno</th></tr>\n"
					);
		try {
			while(rs.next()) {
			out.println("<tr><td>"+ rs.getString("sno") +"</td></tr>\n");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);

		}
		out.println("</table></center></body>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
