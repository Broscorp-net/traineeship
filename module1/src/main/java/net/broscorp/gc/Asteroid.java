package net.broscorp.gc;

public class Asteroid {

  String id;
  private Object object;

  public Asteroid(String id) {
    this.id = id;
  }

  @Override
  protected void finalize() throws Throwable{
    System.out.println("asteroid id = " + id + " deleted by GC )");
    super.finalize();
  }
}
