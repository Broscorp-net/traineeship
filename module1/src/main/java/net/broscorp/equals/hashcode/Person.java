package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Person {

  private String name;
  private String lastName;
  private String yearsOld;

  /**
   * "100% вероятность" не получения коллизии в этом классе.
   */
  public Person(String name, String lastName, String yearsOld) {
    this.name = name;
    this.lastName = lastName;
    this.yearsOld = yearsOld;
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
    return Objects.equals(name, person.name)
        && Objects.equals(lastName, person.lastName)
        && Objects.equals(yearsOld, person.yearsOld);
  }

  @Override
  public int hashCode() {
    return name.length() + lastName.length() + yearsOld.length();
  }

  @Override
  public String toString() {
    return "Person - " + name;
  }
}
