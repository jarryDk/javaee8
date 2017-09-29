package dk.jarry.javaee8.boundary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
        
    public Index() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PushBuilder pushBuilder = request.newPushBuilder();
		if(pushBuilder != null) {
			pushBuilder.path("images/get_a_life.jpg").push();
			pushBuilder.path("css/styles.css").push();
			pushBuilder.path("js/sse.js").push();		
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("\t<head>");
		sb.append("\t\t<meta charset=\"UTF-8\">");
		sb.append("\t\t<title>Java EE 8</title>");
		sb.append("\t\t<link rel=\"stylesheet\" href=\"css/styles.css\">");
		sb.append("\t\t<script type=\"text/javascript\" src=\"js/sse.js\"></script>");
		sb.append("\t</head>");
		sb.append("\t<body>");
		sb.append("\t\t<h1>Java EE 8</h1>");
		sb.append("\t\t<div id=\"\"></div>");
		sb.append("\t</body>");
		sb.append("</html> ");
		
		response.getWriter().append(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
