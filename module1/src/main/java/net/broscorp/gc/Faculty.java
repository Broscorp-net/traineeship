package net.broscorp.gc;

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
    System.out.println(this.hashCode() + "destroy...");
    super.finalize();
  }
}
