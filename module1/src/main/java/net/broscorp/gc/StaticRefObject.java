package net.broscorp.gc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticRefObject {

  public static final List<StaticRefObject> staticRefObjectList = new ArrayList<>();
  private static int numberOfFinalizeLaunch;

  private final String name;
  private String veryLongStringToIncreaseMemorySpaceForEveryObject;

  /**
   * Constructor with parameter.
   *
   * @param name parameter to name the object
   */
  public StaticRefObject(String name) {
    this.name = name;
    veryLongStringToIncreaseMemorySpaceForEveryObject = String
        .join("", Collections.nCopies(Integer.MAX_VALUE / 1_000_000,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
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
