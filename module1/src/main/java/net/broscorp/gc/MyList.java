package net.broscorp.gc;

public class MyList {
  MyList myList;
  int num;

  public MyList() {
  }

  public MyList(int num) {
    this.num = num;
    System.out.println("Added object " + num + " to MyList");
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("MyList num is " + this.getNum() + " finalize started");
    super.finalize();
    System.out.println("MyList num is " + this.getNum() + " finalize finished");
  }
}
