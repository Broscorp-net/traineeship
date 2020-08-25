package net.broscorp.gc;

public class Developer {

  private int id;

  private Developer next;

  public Developer(int id) {
    this.id = id;
  }

  public Developer(int id, Developer developer) {
    this.id = id;
    this.next = developer;
  }

  //    @Override
  //    protected void finalize() throws Throwable {
  //      System.out.println("finalize was invoked for Developer=" + id);
  //      super.finalize();
  //    }

  public int getId() {
    return this.id;
  }

  public void setNext(Developer developer) {
    this.next = developer;
  }
}
