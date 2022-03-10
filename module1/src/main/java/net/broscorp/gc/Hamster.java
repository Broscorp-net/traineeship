package net.broscorp.gc;

class Hamster {

  private String name;
  public Hamster friend;
  public Hamster self;

  public Hamster(String name) {
    this.name = name;
    friend = null;
  }

  public String getName() {
    return name;
  }

  @Override
  protected void finalize() throws Throwable {
    if (name.equals("Test Subject")) {
      self = this;
    }
    System.out.println(name + " is gone");
    super.finalize();
  }
}