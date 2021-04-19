package net.broscorp.person;

import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class Person {
  private long id;
  private int age;

  public Person(long id, int age) {
    this.id = id;
    this.age = age;
  }

  public long getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  @Override
  public  String toString() {
    return "Person{"
         +
        "Id=" + id
         +
        ", Age=" + age
        +
        '}';
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Person person = (Person) object;
    return id == person.id
        &&
        age == person.age;
  }




  public int hashCode() {
    return Objects.hash(this.id, this.age);
  }
}