package net.broscorp.gc;

import java.util.List;

public class GarbageCollList {

  private static List<GarbageCollList> garbageCollLists;

  GarbageCollList(List<GarbageCollList> list) {
    garbageCollLists = list;
  }

  //  @Override
  //  protected void finalize() throws Throwable {
  //    System.out.println("finalize called on " + this.toString());
  //    garbageCollLists.add(this);
  //  }
}
