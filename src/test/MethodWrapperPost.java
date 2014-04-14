package test;

import javax.servlet.http.HttpServletResponse;

import request.JoinGame;
import request.MakePost;
import request.MethodWrapper;

import com.google.gson.Gson;

/**
 * @author Joel Baranowski
 * 
 */
public class MethodWrapperPost {

	Gson g = new Gson();
	
	public String run(MethodWrapper mw){
		MakePost mp = new MakePost("http://1-dot-utopian-hearth-532.appspot.com/test2");
		try {
			return mp.execute(mw);
	    } 
		catch (Exception exception) {
			exception.printStackTrace();
	    }
		return "no return";
	}
}
