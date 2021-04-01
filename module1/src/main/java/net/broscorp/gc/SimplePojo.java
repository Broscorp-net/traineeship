package net.broscorp.gc;

public class SimplePojo {

  private static int numberOfFinalizeLaunch;

  private final String name;
  private final String veryLongStringToIncreaseMemorySpaceForEveryObject = new String(
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
          .repeat(Integer.MAX_VALUE / 1_000_000));

  public SimplePojo(String name) {
    this.name = name;
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      System.out.println(
          String.format("The finalize() method has started for SimplePojo instance %s", name)
              + ", quantity of finalize() calls = " + ++numberOfFinalizeLaunch);
    } finally {
      super.finalize();
    }
  }
}
