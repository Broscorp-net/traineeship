package net.broscorp.gc;

import java.util.Collections;
import java.util.List;

public class PrivateFieldRefObject {

  private static int numberOfFinalizeLaunch;

  private final String name;
  private String veryLongStringToIncreaseMemorySpaceForEveryObject;
  private final List<PrivateFieldRefObject> privateFieldRefObjectList;

  /**
   * Constructor with parameter.
   *
   * @param name                      parameter to name the object
   * @param privateFieldRefObjectList parameter to keep a local reference to the object
   */
  public PrivateFieldRefObject(String name, List<PrivateFieldRefObject> privateFieldRefObjectList) {
    this.name = name;
    this.privateFieldRefObjectList = privateFieldRefObjectList;
    veryLongStringToIncreaseMemorySpaceForEveryObject = String
        .join("", Collections.nCopies(Integer.MAX_VALUE / 1_000_000,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      System.out.println(
          String.format("The finalize() method has started for PrivateRefObject instance %s", name)
              + ", quantity of finalize() calls = " + ++numberOfFinalizeLaunch);
      privateFieldRefObjectList.add(this);
    } finally {
      super.finalize();
    }
  }
}
