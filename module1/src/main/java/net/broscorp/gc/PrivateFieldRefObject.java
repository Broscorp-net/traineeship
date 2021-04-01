package net.broscorp.gc;

import java.util.List;

public class PrivateFieldRefObject {

  private static int numberOfFinalizeLaunch;

  private final String name;
  private final String veryLongStringToIncreaseMemorySpaceForEveryObject = new String(
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
          .repeat(Integer.MAX_VALUE / 1_000_000));
  private final List<PrivateFieldRefObject> privateFieldRefObjectList;

  public PrivateFieldRefObject(String name, List<PrivateFieldRefObject> privateFieldRefObjectList) {
    this.name = name;
    this.privateFieldRefObjectList = privateFieldRefObjectList;
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
