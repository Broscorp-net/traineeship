import org.junit.jupiter.api.Test;

public class GCWithTwoObjectsTest {

  class Person1 {

    Person2 person2;

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Finalize from Person1 class");
      super.finalize();
    }

    public void setSecondObject(Person2 person2) {
      this.person2 = person2;
    }
  }

  class Person2 {

    Person1 person1;

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Finalize from Person2 class");
      super.finalize();
    }

    public void setFirstObject(Person1 person1) {
      this.person1 = person1;
    }
  }

  @Test
  public void objectWithEachOtherReferences() {
    for (int i = 0; i < 50; i++) {
      Person1 person1 = new Person1();
      Person2 person2 = new Person2();

      person1.setSecondObject(person2);
      person2.setFirstObject(person1);
    }
    System.gc();
  }
}
