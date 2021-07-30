package net.broscorp.gc;

public class Student {

  private static int ID;

  private final String name;

  public Student() {
    this.name = "Student" + ID++;
  }

  public String getName() {
    return name;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println(name + " says : " + " bye!");
  }
}
