package net.broscorp.gc;


public class AvailableAgain {

  private int someNum;

  AvailableAgain(int someNum) {
    this.someNum = someNum;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("Finalization: called on AvailableAgain Object " + this.someNum);
    AvailableAgain availableAgain = this;
  }
}

