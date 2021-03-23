package net.broscorp.equals.hashcode;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

  private Integer id;
  private String username;
  private String password;
  private Integer age;
  private Boolean blocked;

  /**
   * Constructor for entity User.
   *
   * @param id - id user
   * @param username - users username
   * @param password - user password
   * @param age - users age
   * @param blocked - check blocked user or no
   */
  public User(Integer id, String username, String password, Integer age, Boolean blocked) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.age = age;
    this.blocked = blocked;
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
    return id.equals(user.id)
        && username.equals(user.username)
        && password.equals(user.password)
        && Objects.equals(age, user.age)
        && Objects.equals(blocked, user.blocked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, age, blocked);
  }
}
