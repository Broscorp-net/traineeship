package net.broscorp.gc;

public class Glass {

  protected int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = Math.max(id, 0);
  }

  public Glass(int id) {
    setId(id);
    System.out.println("Object created");
  }

  public Glass(Glass glass) {
    setId(glass.id);
    System.out.println("Object created");
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Glass " + id + " was broken.");
    super.finalize();
  }
}
