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
		System.out.println("sds");
		TestPost tp = new TestPost();
		tp.run(resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		resp.getWriter().write("returnsds");
	}
}
