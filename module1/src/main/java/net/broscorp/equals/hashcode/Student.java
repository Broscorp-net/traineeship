package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Student {
  Long id;
  String name;
  int phone;

  public Student() {
  }

  /**
   * Constructor for student.
   */
  public Student(Long id, String name, int phone) {
    this.id = id;
    this.name = name;
    this.phone = phone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return getPhone() == student.getPhone()
        && Objects.equals(getId(), student.getId())
        && Objects.equals(getName(), student.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPhone());
  }

  @Override
  public String toString() {
    return "Student{"
        + "id=" + id
        + ", name='" + name + '\''
        + ", phone=" + phone
        + '}';
  }
}
