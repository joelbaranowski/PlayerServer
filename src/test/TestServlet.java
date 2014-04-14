package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.*;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.gson.Gson;

import request.JoinGame;
import request.MethodWrapper;
import request.TakeTurn;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	
	private Gson g = new Gson();
	private MemcacheService syncCache = MemcacheServiceFactory.getMemcacheService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		JoinGamePost jgp = new JoinGamePost();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		resp.setContentType("text/plain");
		resp.getWriter().println("from server");
		MethodWrapper mw = g.fromJson(req.getReader(), MethodWrapper.class);
		switch(mw.getMethod()){
			case "getGameList":{
				GetGameList ggl = new GetGameList();
				String result = ggl.run();
				resp.getWriter().println(result);
				break;
			}
			case "joinGame":{
				JoinGame jg = g.fromJson(mw.getData(), JoinGame.class);
				int playerID = jg.getPlayerID();
				String gameURL = jg.getGameURL();
				JoinGamePost jgp = new JoinGamePost();
				String result = jgp.run(playerID, gameURL);
				break;
			}
		}
	}
}
