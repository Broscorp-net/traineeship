package net.broscorp.gc;

public class MyList {

  MyList myList;
  int num;
  public static int timesFinalized;
  public static int itemsAdded;

  public MyList() {
  }

  public MyList(int num) {
    this.num = num;
    itemsAdded++;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    timesFinalized++;
  }
}
