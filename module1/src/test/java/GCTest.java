import org.junit.jupiter.api.Test;


public class GCTest {


  public class FirstClass {

    private SecondClass second;

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Finalize method from FirstClass.");
      super.finalize();
    }

    public void setSecond(SecondClass second) {
      this.second = second;
    }
  }

  public class SecondClass {

    private FirstClass first;

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Finalize method from SecondClass.");
      super.finalize();
    }

    public void setFirst(FirstClass first) {
      this.first = first;
    }
  }

  @Test
  public void gcTest() {
    for (int i = 0; i < 100; i++) {
      FirstClass firstClass = new FirstClass();
      SecondClass secondClass = new SecondClass();
      firstClass.setSecond(secondClass);
      secondClass.setFirst(firstClass);
    }
    System.gc();

  }

}
