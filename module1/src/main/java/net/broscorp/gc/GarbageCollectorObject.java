package net.broscorp.gc;

class GarbageCollectorObject {
  private int id;
  private Integer age;
  private String name;

  public GarbageCollectorObject(int id) {
    this.id = id;
    this.age = 500;
    this.name = "Asdfghjkl";

    System.out.println("Create object with id: " + id + "\n ");
  }

  public GarbageCollectorObject(String name) {
    this.id = 1;
    this.age = 80;
    this.name = name;
  }

  public GarbageCollectorObject object;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Object with name: " + name + " destroyed\n ");
    super.finalize();
  }


}