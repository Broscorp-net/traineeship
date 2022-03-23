package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  /**.
   * Default constructor.
   */
  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
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
    return age == person.age && Objects.equals(firstName, person.firstName)
        && Objects.equals(lastName, person.lastName);
  }

  @Override
  public int hashCode() {
    return firstName.hashCode() + lastName.hashCode() + age * 31;
  }

  @Override
  public String toString() {
    return "Person{"
        + "firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + ", age=" + age + '}';
  }
}
