

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		response.setContentType("text/html;Charset = gb2312");
		PrintWriter out = response.getWriter();
		String heading;
		Integer accessCount = (Integer) mySession.getAttribute("accessCount");
		if (accessCount == null) {
			accessCount = new Integer(0);
			heading = "Welcome Newcomer!";
		}else {
			heading = "Welcome Back.";
			accessCount = new Integer (accessCount.intValue() + 1);
		}
		mySession.setAttribute("accessCount", accessCount);
		out.println("<html>\n"
					+"<head>\n"
					+	"<title>œ‘ æSession</title>\n"	
					+"</head>\n"
					+"<body BGCOLOR = '#66ccff'>"
					+	"<Center>\n"
					+	"<h1>" + heading + "</h1>"
					+		"<table BORDER = 1 ALIGN ='CENTER'>\n"
					+			"<tr>\n"
					+				"<th>Session Infor</th>"
					+				"<th>Session Value</th>"		
					+			"</tr>\n"
					+			"<tr>"
					+					"<td>Session ID:</td>"
					+					"<td>" + mySession.getId() +"</td>"
					+			"</tr>"
					+			"<tr>"
					+					"<td>Session Createtime:</td>"
					+					"<td>" + new Date(mySession.getCreationTime()) +"</td>"
					+			"</tr>"
					+			"<tr>"
					+					"<td>Visit Time:</td>"
					+					"<td>" + accessCount +"</td>"
					+			"</tr>"
					);
		out.println(		"</table>"
					+	"</Center>"
					+"</body></html>"
					);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
