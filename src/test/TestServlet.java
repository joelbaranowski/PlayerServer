package test;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		TestPost tp = new TestPost();
		String result = tp.run();
		resp.getWriter().println("result: " + result);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		resp.getWriter().println("return bad post");
	}
}
