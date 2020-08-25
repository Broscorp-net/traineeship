package net.broscorp.gc;

import org.testng.annotations.Test;

public class FirstTest {

  public class FirstClass {

    private SecondClass secondClass;

    //    @Override
    //    protected void finalize() throws Throwable {
    //      System.out.println("The memory was freed. Object A has been deleted");
    //      super.finalize();
    //  }

    public void setSecondClass(SecondClass secondClass) {
      this.secondClass = secondClass;
    }
  }

  public class SecondClass {

    private FirstClass firstClass;

    //    @Override
    //    protected void finalize() throws Throwable {
    //      System.out.println("The memory was freed. Object B has been deleted");
    //      super.finalize();
    //    }

    public void setFirstClass(FirstClass firstClass) {
      this.firstClass = firstClass;
    }
  }

  @Test
  public void createFirstAndSecondClass() {
    for (int i = 0; i < 100_000; i++) {
      FirstClass firstClass = new FirstClass();
      SecondClass secondClass = new SecondClass();
      firstClass.secondClass = secondClass;
      secondClass.firstClass = firstClass;
    }
    System.gc();
  }

}
