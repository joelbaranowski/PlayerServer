package request;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Joel Baranowski
 * 
 */
public class TestPost {


  public String run( HttpServletResponse  resp){
	  MakePost mp = new MakePost("http://1-dot-utopian-hearth-532.appspot.com/test2?test=hello");
	    try {
	      System.out.println(mp.execute(resp));
	    } catch (Exception exception) {
	      exception.printStackTrace();
	    }
	  return "test";
  }
}
