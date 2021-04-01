package net.broscorp.gc;

public class ReciprocalRefObject {

  private static int numberOfFinalizeLaunch;

  private final String name;
  private final String veryLongStringToIncreaseMemorySpaceForEveryObject = new String(
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
          .repeat(Integer.MAX_VALUE / 1_000_000));
  private ReciprocalRefObject otherReciprocalRefObject;

  public ReciprocalRefObject(String name) {
    this.name = name;
  }

  public void setOtherReciprocalRefObject(ReciprocalRefObject otherReciprocalRefObject) {
    this.otherReciprocalRefObject = otherReciprocalRefObject;
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      System.out.println(
          String
              .format("The finalize() method has started for ReciprocalRefObject instance %s", name)
              + ", quantity of finalize() calls = " + ++numberOfFinalizeLaunch);
    } finally {
      super.finalize();
    }
  }
}
