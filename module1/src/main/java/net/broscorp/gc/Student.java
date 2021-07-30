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
    System.out.println(name + " says : " + " bye!");
  }
}

class Faculty {
  private final String name;

  public Student student;

  public Faculty(String name) {
    this.name = name;
    this.student = new Student();
  }

  public String getName() {
    return name;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Faculty of " + name + " destroy...");
  }
}

class GC {

  static GC SAVE;

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("execute");
    SAVE = this;
  }
}
