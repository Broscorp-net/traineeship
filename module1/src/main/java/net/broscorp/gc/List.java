package net.broscorp.gc;

public class List {

  private Object[] array;
  private int size;
  private int cur;
  List list;


  /**
   * Constructor.
   */
  public List(Object[] array, int size, int cur) {
    this.array = array;
    this.size = size;
    this.cur = cur;
  }

  public void setList(List list) {
    this.list = list;
  }


  /**
   * method add.
   */
  public int add(Object item) {
    if (!this.full()) {
      array[cur++] = item;
    }
    return cur;
  }


  public boolean full() {
    return cur == size;
  }

    @Override
    protected void finalize() throws Throwable {
      if (!this.full()) {
        this.add(new byte[size]);
      } else {
        System.out.println("List is full");
      }

      System.out.println("Current object " + this.cur + " has bean deleted from finalize");
      super.finalize();
    }
}
