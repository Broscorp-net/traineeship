package net.broscorp.equals.hashcode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {

  private int id;
  private int age;
  private String name;
  private String lastname;

  @Override
  public String toString() {
    return "Person{"
        + "id=" + id
        + ", age=" + age
        + ", name='" + name + '\''
        + ", lastname='" + lastname + '\''
        + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Person)) {
      return false;
    }
    Person person = (Person) obj;
    if (id != person.id) {
      return false;
    }
    if (age != person.age) {
      return false;
    }
    if (name != null ? !name.equals(person.name) : person.name != null) {
      return false;
    }
    return lastname != null ? lastname.equals(person.lastname) : person.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + age;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
