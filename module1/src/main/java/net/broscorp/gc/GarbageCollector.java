package net.broscorp.gc;

public class GarbageCollector {
  private static int counter;
  private String name;
  public GarbageCollector garbageCollectorReference;

  public GarbageCollector(String name) {
    this.name = name;
    garbageCollectorReference = null;
  }

  public GarbageCollector() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  /* Checkstyle doesn't let me use this method.
   However, it was used during the testing.
    @Override
    protected void finalize() throws Throwable {
     if (name.equals("Garbage Collector Save Reference")) {
        garbageCollectorReference = this;
     }
      counter++;
      System.out.println(this.name + " deleted successfully! " + counter);
      super.finalize();
    }

   */

}
