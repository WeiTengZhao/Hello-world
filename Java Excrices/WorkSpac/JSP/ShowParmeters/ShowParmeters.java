

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParmeters
 */
@WebServlet("/ShowParmeters")
public class ShowParmeters extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;Charset = gb2312");
		PrintWriter out = response.getWriter();
		String title = "ShowParmeters";
		out.println("<html>\n"+"<head>\n"+"<title>" +"读取所有参数" + "</title>\n" + "</head>\n" + 
				"<body BGCOLOR = '#66ccff'>\n" + "<center> <h1>"+ title + "</h1> " +"<table>\n" +
				"<tr BGCOLOR ='#9A32CD'>\n" + 
				"<th>Parameter Name<th>Parameter Value</center>\n" );
		Enumeration ParmeterName = request.getParameterNames();
		while(ParmeterName.hasMoreElements()){
			String ParneterNames = (String)ParmeterName.nextElement();
			out.println("<tr><td>" + ParneterNames+"\n<td>");
			String [] ParneterValues  =  request.getParameterValues(ParneterNames);
			if(ParneterValues.length == 1) {
				String ParneterValue = ParneterValues[0];
			
				if(ParneterValues.length == 0) {
					out.print("<h1>" + "NO Value" +"</h1>\n");
				}else {
					out.println(ParneterValue);
				}
			}else {
				out.println("<UL>");
				for(int i = 0;i < ParneterValues.length;i++) {
					out.print("<LI>" + ParneterValues[i] + "</LI>\n");
				}
				out.println("</UL>");
			}
		
			}
		out.println("</table>\n"+"</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
