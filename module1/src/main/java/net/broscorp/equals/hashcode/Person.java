package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Person {

  public int id;
  public int age;
  public String name;

  public Person() {}

  /**
   * Constructor parameters.
   * @param id - person's id
   * @param age - person's age
   * @param name - person's name
   */
  public Person(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return id == person.id && age == person.age && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, age, name);
  }
}
