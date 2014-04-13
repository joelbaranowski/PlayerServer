package test;

import java.io.IOException;

import javax.servlet.http.*;

import request.TestPost;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		TestPost tp = new TestPost();
		System.out.println(tp.run());
	}
}
