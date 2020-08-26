package net.broscorp.gc;

public class SecondClass {
  long number;
  String name;
  long value;
  FirstClass entity;
  private static int counter = 0;

  /**
  * SecondClass.
  * @param number number
  * @param name name
  * @param value value
  */
  public SecondClass(long number, String name, long value) {
    this.number = number;
    this.name = name;
    this.value = value;
    counterText();
  }

  public void setEntity(FirstClass entity) {
    this.entity = entity;
  }

  public void counterText() {
    System.out.println("The second object was created " + number);
  }

  //  @Override
  //  protected void finalize() throws Throwable {
  //    super.finalize();
  //    System.out.println("The second object was deleted " + counter++);
  //  }
}
