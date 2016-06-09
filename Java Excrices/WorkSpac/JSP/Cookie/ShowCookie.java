

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCookie
 */
@WebServlet("/ShowCookie")
public class ShowCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;Charset = gb2312");
		PrintWriter out = response.getWriter();
		String title = "ShowCookie";
		out.println("<html>\n" 
					+ "<head><title>œ‘ æCookie</title></head>\n"
					+ "<body BGCOLOR = '#66ccff'><Center>"+ title
					+"<table><tr><th>Cookie Name</th><th>Cookie Value</th></tr>"
					);
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			Cookie cookie;
			for(int i = 0;i < cookies.length; i ++) {
				cookie = cookies[i];
				out.println("<tr>\n"
							+ "<td>" + cookie.getName() + "</td>\n"
							+ "<td>" + cookie.getValue() + "</td>\n"
						+ "</tr>"
				);	
			}
		}
		out.println("</table>\n</center>\n</body>\n</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
