

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		response.setContentType("text/html;Charset = gb2312");
		PrintWriter out = response.getWriter();
		out.println("<html>\n"
					+"<title> <h3>SetSessionServlet</h3> </title>\n"
					+"<body>\n"
					+"<h2>Session Information :<br></h2>\n"
					+"Session is New:" + mySession.isNew() +"<br>\n"
					+"Session ID:" + mySession.getId() + "<br>\n"
					+"Session Create Time:" + new java.util.Date(mySession.getCreationTime()) + "<br>\n"
					+"Session Last Time:" + new java.util.Date(mySession.getLastAccessedTime()) + "<br>\n"
					+"<br>\n"
					+"<h2> Request Session Information: </h2><br>\n"
					+"Requset Session ID:" + request.getRequestedSessionId() + "<br>\n"
					+"Session is from Cookie:" + request.isRequestedSessionIdFromCookie() + "<br>\n"
					+"Session is from URL:" + request.isRequestedSessionIdFromURL() + "<br>\n"
					+"Vaild Session:" + request.isRequestedSessionIdValid() + "<br>\n"
					);
		out.println("<br> <a href = "+ response.encodeURL("SetSessionServlet") +/*'/Test/servlet/SetSessionServlet'*/"> Refresh </a><br>\n</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
