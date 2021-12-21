package net.broscorp.equals.hashcode;

public class Model {
  private int id;
  private String name;

  public Model(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return name.hashCode() + id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Model) {
      Model model = (Model)obj;
      return model.name.equals(this.name) && model.getId() == this.id;
    } else {
      return false;
    }

  }

  @Override
  public String toString() {
    return  "id= " + id + ", name= " + name;
  }
}
