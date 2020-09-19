package net.broscorp.gc;

import java.util.List;

public class ImmortalObjectForGarbageCollector {
  private static List<ImmortalObjectForGarbageCollector> list;

  ImmortalObjectForGarbageCollector(List<ImmortalObjectForGarbageCollector> list) {
    this.list = list;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize called on " + this.toString());
    list.add(this);
  }
}
