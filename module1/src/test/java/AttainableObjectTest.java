import org.junit.jupiter.api.Test;

public class AttainableObjectTest {

  Person person = new Person();

  @Test
  public void attainableObjectTest() {
    for (int i = 0; i < 10_000; i++) {
      AttainableObject aObject = new AttainableObject(person);
      person.list.add(aObject);
      System.gc();
    }
    System.out.println(person.list.size());
  }
}
