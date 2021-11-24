package net.broscorp.gc;

/**
 * . Класс для проверки задания
 */
public class MyList {

  MyList myList;
  int num;
  public static int timesFinalized;
  public static int itemsAdded;

  public MyList() {
  }

  /**
   * . Конструктор с параметром
   */
  public MyList(int num) {
    this.num = num;
    itemsAdded++;
    //    System.out.println("Added object " + num + " to MyList");
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  @Override
  protected void finalize() throws Throwable {
    //    System.out.println("MyList num is " + this.getNum() + " finalize started");
    super.finalize();
    //    System.out.println("MyList num is " + this.getNum() + " finalize finished");
    timesFinalized++;
  }
}
