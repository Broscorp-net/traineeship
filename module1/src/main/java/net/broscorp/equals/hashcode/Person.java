package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  /**.
   * Person constructor.
   */
  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
