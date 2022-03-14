package net.broscorp.gc;

public class SampleObjectTwo {
  private String string;

  public static boolean reachable = false;

  public SampleObjectTwo() {}

  public SampleObjectTwo(String string) {
    this.string = string;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  @Override
  protected void finalize() throws Throwable {
    if (reachable) {
      System.out.println(this + " destroyed");
      SampleObjectTwo sampleObjectTwo = this;
      sampleObjectTwo = null;
    }
    super.finalize();
  }
}
