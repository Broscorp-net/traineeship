import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ImmortalTest {

  private static ArrayList<ImmortalClass> list;

  public class ImmortalClass {

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Message before resurrection.");
      list.add(this);
      System.out.println("This message will not be displayed.");
      super.finalize();
    }
  }

  @Test
  public void resurrectionTest() {
    for (int i = 0; i < 100000; i++) {
      ImmortalClass immortalClass = new ImmortalClass();
    }
    System.gc();
  }
}
