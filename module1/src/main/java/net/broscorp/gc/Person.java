import java.util.ArrayList;
import java.util.List;

public class Person {

  private String id;
  private static int gc_calls_count;
  List<AttainableObject> list = new ArrayList<>();
  
  /**
   * Constructor parameters.
   *
   * @param id - person id
   */

  public Person(String id) {
    this.id = id;
  }

  public Person() {

  }

  /*@Override
  protected void finalize() throws Throwable {
    System.out.println(id + " destroyed");
    gc_calls_count++;
    super.finalize();
  }*/

  public int getGcCallsCount() {
    return gc_calls_count;
  }
}
