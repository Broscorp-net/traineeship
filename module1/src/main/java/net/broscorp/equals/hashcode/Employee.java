package net.broscorp.equals.hashcode;

public class Employee {
  String name;
  int id;


  public Employee(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Employee №" + id + " name: " + name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    if (id != employee.id) {
      return false;
    }

    if (name != employee.name) {
      return employee.name == null;
    } else {
      return name.equals(employee.name);
    }
  }

  @Override
  public int hashCode() {
    int result;
    result = name != null ? name.hashCode() : 0;
    result = 31 * result + id;
    return result;
  }
}
