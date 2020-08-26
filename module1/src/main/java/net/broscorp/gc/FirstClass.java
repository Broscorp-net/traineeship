package net.broscorp.gc;

public class FirstClass {
  long number;
  String name;
  long value;
  SecondClass entity;
  private static int counter = 0;
  ThirdClass third;

  /**
  * FirstClass.
  * @param number number
  * @param name name
  * @param value value
  */
  public FirstClass(long number, String name, long value) {
    this.number = number;
    this.name = name;
    this.value = value;
    counterText();
  }

  public void setEntity(SecondClass entity) {
    this.entity = entity;
  }

  public void setThird(ThirdClass third) {
    this.third = third;
  }

  public void counterText() {
    System.out.println("The first object was created " + number);
  }

  //  @Override
  //  protected void finalize() throws Throwable {
  //    super.finalize();
  //    System.out.println("The first object was deleted " + number);
  //  }
}
