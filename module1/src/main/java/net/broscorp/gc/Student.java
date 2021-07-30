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
    try {
      System.out.println("override finalize.. ");
    } catch (Throwable t) {
      System.out.println(t.getMessage());
    } finally {
      super.finalize();
      System.out.println(name + " says : " + " bye!");
    }
  }
}
