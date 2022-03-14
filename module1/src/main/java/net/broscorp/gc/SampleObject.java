package net.broscorp.gc;

public class SampleObject {
  private String string;

  public SampleObject() {}

  public SampleObject(String string) {
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
    System.out.println(this + " destroyed");
    super.finalize();
  }
}
