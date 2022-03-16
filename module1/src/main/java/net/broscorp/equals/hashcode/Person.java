package net.broscorp.equals.hashcode;

public class Person {
  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return name.length() * 10 + age;
  }

  @Override
  public boolean equals(Object obj) {
    Person person = (Person) obj;
    return this.name.equals(person.name) && this.age == person.age ? true : false;
  }

  @Override
  public String toString() {
    return "Name: " + name + "; Age:" + age;
  }

}
