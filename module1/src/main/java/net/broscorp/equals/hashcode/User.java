package net.broscorp.equals.hashcode;

import java.util.Objects;

public class User {
  private int id;
  private int age;
  private String name;
  private String lastName;


  /**
   * This is constructor for User class.
   * @param id       user id
   * @param age      user age
   * @param name     user name
   * @param lastName user lastName
   */
  public User(int id, int age, String name, String lastName) {
    this.id = id;
    this.age = age;
    this.name = name;
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return id == user.id
        && age == user.age
        && Objects.equals(name, user.name)
        && Objects.equals(lastName, user.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, age, name, lastName);
  }

  @Override
  public String toString() {
    return "User{"
        + "id=" + id
        + ", age=" + age
        + ", name='" + name + '\''
        + ", lastName='" + lastName + '\''
        + '}';
  }
}
