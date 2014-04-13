package request;

/**
 * @author Joel Baranowski
 * 
 */
public class TestPost {

  public static void main(String[] args) {
    MakePost mp = new MakePost("http://10.119.79.219:8888/getBoard");
    try {
      System.out.println(mp.execute());
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
