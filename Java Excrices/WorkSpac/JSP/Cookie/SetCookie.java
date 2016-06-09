

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		for(int i = 0;i < 3;i++){
			Cookie cookie = new Cookie("SessionCookie-" + i , "Cookie-S:" + i );
			response.addCookie(cookie);
			cookie = new Cookie("PersistentCookie-" + i , "Cookie-V:" + i);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		response.setContentType("text/html;Charset = gb2312");
		PrintWriter out = response.getWriter();
		String title = "SetCookie";
		out.println("<html>\n" 
					+ "<head><title>…Ë÷√Cookie</title></head>\n"
					+"<body BGCOLOR = '#66ccff'><Center>"+title+"<br><A HREF = '/Test/servlet/ShowCookie'><code>ShowCookie</code>servlet</A></Center>\n"
					+"</body>+</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
