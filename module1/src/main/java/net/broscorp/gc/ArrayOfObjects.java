package net.broscorp.gc;

public class ArrayOfObjects {
  ArrayOfObjects myArray;
  int num;
  static int finalizeObjets;
  static int numberOfObjects;

  public ArrayOfObjects(int num) {
    this.num = num;
    numberOfObjects++;
  }

  public int getNum() {
    return num;
  }

  @Override
  protected void finalize() throws Throwable {

    super.finalize();
    finalizeObjets++;
  }
}
