package net.broscorp.gc;

public class CountedObj {

  public static int finalized = 0;
  public static int count = 0;

  public static boolean makeReachable = false;

  private int id = 0;
  private boolean isReachable = makeReachable;

  public CountedObj referencing = null;

  public CountedObj() {
    id = count++;
  }

  @Override
  protected void finalize() throws Throwable {

    // illustratively output first 10 which are being finalized
    if (!isReachable && finalized++ < 10) {
      System.out.println("CountedObj " + id + " is being finalized.");
    }

    // output all calls to finalize when object is made reachable again
    if (isReachable) {
      System.out.println("Reachable CountedObj " + id + " is being finalized.");
      CountedObj co = this;
      co = null;
    }

    super.finalize();
  }
}