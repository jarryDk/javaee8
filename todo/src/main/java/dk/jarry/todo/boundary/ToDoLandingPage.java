package dk.jarry.todo.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

/**
 * Servlet implementation class ToDoLandingPage
 */
@WebServlet("/ToDoLandingPage")
public class ToDoLandingPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String html;

	@Override
	public void init() throws ServletException {
		super.init();
		InputStream resourceAsStream = null;
		try {
			resourceAsStream = ToDoLandingPage.class.getClassLoader().getResourceAsStream("ToDoLandingPage.html");
			html = new BufferedReader(new InputStreamReader(resourceAsStream)).lines().parallel()
					.collect(Collectors.joining("\n"));
		} finally {
			if (resourceAsStream != null) {
				try {
					resourceAsStream.close();
				} catch (Exception e) {
					/** DO NOTHING */
				}
			}
		}

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoLandingPage() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PushBuilder pushBuilder = request.newPushBuilder();
		if(pushBuilder != null) {
			pushBuilder.path("bootstrap-4.0.0-beta-dist/css/bootstrap.min.css").push();
			pushBuilder.path("css/starter-template.css").push();
			pushBuilder.path("jquery/jquery-3.2.1.slim.min.js").push();	
			pushBuilder.path("popper/popper.min.js").push();	
			pushBuilder.path("bootstrap-4.0.0-beta-dist/js/bootstrap.min.js").push();	
		}
		
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
