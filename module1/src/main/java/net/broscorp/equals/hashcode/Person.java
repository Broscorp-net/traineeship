package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  /**
   * Initializes fields of a newly created object.
   * @param firstName First name of a person
   * @param lastName Last name(surname) of a person
   * @param age Age of a person
   */
  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  @Override
  public String toString() {
    return String.format(
        "Person{firstName='%s', lastName='%s', age='%d'}",
        firstName,
        lastName,
        age
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || !(o instanceof Person)) {
      return false;
    }

    Person person = (Person) o;
    return age == person.age
        && firstName.equals(person.firstName)
        && lastName.equals(person.lastName);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    return prime * age
        + (firstName == null ? 0 : firstName.length())
        + (lastName == null ? 0 : lastName.length());
  }

}
