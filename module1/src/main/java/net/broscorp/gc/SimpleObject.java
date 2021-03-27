package net.broscorp.gc;

public class SimpleObject {

  private String message;

  public SimpleObject simpleObject;

  public SimpleObject() {
  }

  public SimpleObject(String message) {
    this.message = message;
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      System.out.printf("The finalize() for object %s started \n",message);
      System.out.printf("SimpleObject with HashCode %d available in finalize() \n", this.hashCode());

      } finally {
      super.finalize();
    }
  }

}
