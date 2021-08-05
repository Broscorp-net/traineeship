package net.broscorp.gc;

public class GlassGlued extends Glass {

  public static GlassGlued reserveGlass;

  public GlassGlued(int id) {
    super(id);
  }

  @Override
  protected void finalize() throws Throwable {
    reserveGlass = this;
    super.finalize();
    System.out.println("Glass restored");
  }
}
