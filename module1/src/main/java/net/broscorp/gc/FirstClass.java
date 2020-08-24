package net.broscorp.gc;

public class FirstClass {

  SecondClass secondClass;

  @Override
  protected void finalize() throws Throwable {
    System.out.println("The memory was freed. Object A has been deleted");
    super.finalize();
  }

  /**Create 100_000 objects.
   *
   * @param args default main args.
   */
  public static void main(String[] args) {
    for (int i = 0; i < 100_000; i++) {
      FirstClass firstClass = new FirstClass();
      SecondClass secondClass = new SecondClass();
      firstClass.secondClass = secondClass;
      secondClass.firstClass = firstClass;
    }
  }
}
