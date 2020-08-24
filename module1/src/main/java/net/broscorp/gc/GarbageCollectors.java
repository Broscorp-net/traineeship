package net.broscorp.gc;

public class GarbageCollectors {

  private static GarbageCollectors garbageCollectors = new GarbageCollectors();

  @Override
  protected void finalize() throws Throwable {
    garbageCollectors = this;
    System.out.println("Method 'finalize' was used");
    super.finalize();
  }

  /**Create 100_000 NULL objects.
   *
   * @param args default main args.
   */
  public static void main(String[] args) {
    for (int i = 0; i < 100_000; i++) {
      garbageCollectors = new GarbageCollectors();
      garbageCollectors = null;
    }
    System.gc();
  }

}
