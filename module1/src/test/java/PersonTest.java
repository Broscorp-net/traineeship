import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  public void createLargeNumberOfObjects() {
    Person person = null;
    for (int i = 0; i < 50_000; i++) {
      person = new Person("Object " + i);
    }
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(person.getGcCallsCount() + " objects was destroyed");
  }
}