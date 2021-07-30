package net.broscorp.equals.hashcode;

/** student. */
public class Student {

  private int course;

  private String name;

  private String institution;

  /** constructor. */
  public Student(int course, String name, String institution) {
    this.course = course;
    this.name = name;
    this.institution = institution;
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) {
    this.course = course;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return course == student.course
        && name.equals(student.name)
        && institution.equals(student.institution);
  }

  @Override
  public int hashCode() {
    return this.course + this.name.length() + this.institution.length();
  }

  @Override
  public String toString() {
    return "Student{"
        + "course="
        + course
        + ", name='"
        + name
        + '\''
        + ", institution='"
        + institution
        + '\''
        + '}';
  }
}
