package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;

public class Person {
  public static List<Person> people = new ArrayList<>();
  private String name;
  private int age;
  private Address address;

  public Person(String name, int age) {
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

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  protected void finalize() {
    System.out.print(".");
    people.add(this);
  }
}
