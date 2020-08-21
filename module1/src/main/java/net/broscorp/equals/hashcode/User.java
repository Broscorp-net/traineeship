package net.broscorp.equals.hashcode;

import java.util.Objects;

public class User {

  private int id;
  private int age;
  private String email;

  /**
   *Constructor User class that represents a user.
   *
   * @param id    Index number user
   * @param age   years old user
   * @param email user
   */
  public User(int id, int age, String email) {
    this.id = id;
    this.age = age;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id
        && age == user.age
        && email.equals(user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, age, email);
  }

  @Override
  public String toString() {
    return "User{"
        + "id=" + id
        + ", age=" + age
        + ", email='" + email + '\''
        + '}';
  }
}
