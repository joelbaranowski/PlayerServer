package test;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.gson.Gson;

import request.ExceptionStringify;
import request.JoinGame;
import request.MethodWrapper;
import request.TakeTurn;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	
	private Gson g = new Gson();
	private MemcacheService syncCache = MemcacheServiceFactory.getMemcacheService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		String method = req.getParameter("method");
		String data = req.getParameter("data");
		if(method == null || data == null)
			return;
		this.execute(req.getParameter("method"), URLDecoder.decode(req.getParameter("data"), "UTF-8"), req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		MethodWrapper mw = g.fromJson(req.getReader(), MethodWrapper.class);
		this.execute(mw.getMethod(), mw.getData(), req, resp);
	}
	
	private void execute(String method, String data, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		switch(method){
			case "getGameList":{
				MethodWrapper mw = new MethodWrapper("getGameList", "");
				MethodWrapperPost ggl = new MethodWrapperPost();
				String result = ggl.run(mw);
				resp.getWriter().println(result);
				break;
			}
			case "getPlayerList":{
				MethodWrapper mw = new MethodWrapper("getPlayerList", "");
				MethodWrapperPost ggl = new MethodWrapperPost();
				String result = ggl.run(mw);
				resp.getWriter().println(result);
				break;
			}
			case "startGame":{
				MethodWrapper mw = new MethodWrapper("startGame", "");
				MethodWrapperPost ggl = new MethodWrapperPost();
				String result = ggl.run(mw);
				resp.getWriter().println(result);
				break;
			}
			case "endGame":{
				MethodWrapper mw = new MethodWrapper("endGame", "");
				MethodWrapperPost ggl = new MethodWrapperPost();
				String result = ggl.run(mw);
				resp.getWriter().println(result);
				break;
			}
			case "joinGame":{
				JoinGame jg = g.fromJson(data, JoinGame.class);
				Long playerID = jg.getPlayerID();
				String gameURL = jg.getGameURL();
				JoinGamePost jgp = new JoinGamePost();
				String result = jgp.run(playerID, gameURL);
				resp.getWriter().println(result);
				break;
			}
		}
	}
}
