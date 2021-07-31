package net.broscorp.gc;

import java.util.List;

public class SomeObject {

  private int number;
  private SomeObject object;

  private List<SomeObject> list = null;

  /**
   * Constructor.
   */

  public SomeObject(int number, SomeObject object, List<SomeObject> list) {
    this.number = number;
    this.object = object;
    this.list = list;
  }

  public void setObject(SomeObject object) {
    this.object = object;
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      if (list != null) {
        this.list.add(this);
      }
      System.out.println("finalize() has been called for Object " + this.number);
    } finally {
      super.finalize();
    }
  }
}
