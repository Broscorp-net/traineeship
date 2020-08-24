package net.broscorp.gc;

public class SecondClass {

  FirstClass firstClass;

  @Override
  protected void finalize() throws Throwable {
    System.out.println("The memory was freed. Object B has been deleted");
    super.finalize();
  }

}
