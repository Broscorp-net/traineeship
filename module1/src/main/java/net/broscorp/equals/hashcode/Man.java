package net.broscorp.equals.hashcode;

public class Man {

  private String name;
  private int age;

  public Man(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Man { name: " + name + " , age: " + age + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Man man = (Man) o;

    if (age != man.age) {
      return false;
    }
    return name != null ? name.equals(man.name) : man.name == null;
  }

  @Override
  public int hashCode() {
    int result = 7;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + age;
    return result;
  }
}
