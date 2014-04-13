package request;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Joel Baranowski
 * 
 */
public class TestPost {


  public String run( HttpServletResponse  resp){
	  MakePost mp = new MakePost("http://twitter.com/statuses/user_timeline/14437022.rss");
	    try {
	      System.out.println(mp.execute(resp));
	    } catch (Exception exception) {
	      exception.printStackTrace();
	    }
	  return "test";
  }
}
