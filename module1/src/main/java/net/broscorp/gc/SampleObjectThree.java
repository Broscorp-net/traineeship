package net.broscorp.gc;

public class SampleObjectThree {
  private SampleObjectThree other;

  public SampleObjectThree() {}

  public void setOther(SampleObjectThree other) {
    this.other = other;
  }

  public SampleObjectThree getOther() {
    return other;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println(this + " destroyed");
  }
}
