package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;

public class StaticRefObject {

  public static final List<StaticRefObject> staticRefObjectList = new ArrayList<>();
  private static int numberOfFinalizeLaunch;

  private final String name;
  private final String veryLongStringToIncreaseMemorySpaceForEveryObject = new String(
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
          .repeat(Integer.MAX_VALUE / 1_000_000));

  public StaticRefObject(String name) {
    this.name = name;
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      System.out.println(
          String.format("The finalize() method has started for StaticRefObject instance %s", name)
              + ", quantity of finalize() calls = " + ++numberOfFinalizeLaunch);
      staticRefObjectList.add(this);
    } finally {
      super.finalize();
    }
  }
}
