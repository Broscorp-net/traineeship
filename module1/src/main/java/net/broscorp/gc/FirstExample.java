package net.broscorp.gc;

public class FirstExample {
  private SecondExample secondExample;

  public FirstExample(SecondExample secondExample) {
    this.secondExample = secondExample;
  }

//  @Override
//  protected void finalize() throws Throwable {
//    super.finalize();
//    System.out.println("Finalize method for FirstExample was called");
//  }
}
