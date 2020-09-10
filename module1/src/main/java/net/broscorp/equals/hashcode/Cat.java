package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Cat {
  private int id;
  private int age;
  private String name;

  public Cat(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Cat{"
            + "id=" + id
            + ", age=" + age
            + ", name='" + name + '\''
            + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cat cat = (Cat) o;
    return id == cat.id
            && age == cat.age
            && Objects.equals(name, cat.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, age, name);
  }
}
