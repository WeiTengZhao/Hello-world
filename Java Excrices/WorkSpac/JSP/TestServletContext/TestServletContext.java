package com.Shao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServletContext")
public class TestServletContext extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;Charset = gb2312");
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		Integer accessCountext = (Integer) application.getAttribute("accessCountext");
		if (accessCountext == null) {
			accessCountext = new Integer(0);
		}else {
			accessCountext = new Integer(accessCountext.intValue() + 1);
		}
		application.setAttribute("accessCountext",accessCountext);
		out.println("<html>"
					+	"<head>"
					+		"<title>TestSerletContext</title>"
					+	"</head>"
					+	"<body BGCOLOR ='#66ccff'>"
					+		"<Center><tabtle><H1>" + accessCountext + "</H1></tabtle></Center>"
					+	"</body>"
					+"</html>"
					);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
