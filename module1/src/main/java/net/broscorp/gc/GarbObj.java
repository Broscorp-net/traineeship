package net.broscorp.gc;

public class GarbObj {

  private String id;
  private GarbObj link;

  public GarbObj(String id, GarbObj link) {
    this.id = id;
    this.link = link;
  }

  public GarbObj() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  protected void finalize() {
    link.finalize();
    System.out.println("GarbObj deleted (id:" + id + ")");
  }

}
