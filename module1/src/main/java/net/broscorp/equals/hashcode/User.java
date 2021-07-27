package net.broscorp.equals.hashcode;

import java.util.Objects;

public class User {

  private Integer id;
  private String nickname;
  private String email;
  private String password;

  /**
   * public constructor for user model.
   */

  public User(Integer id, String nickname, String email, String password) {
    this.id = id;
    this.nickname = nickname;
    this.email = email;
    this.password = password;
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
    return Objects.equals(id, user.id)
      && Objects.equals(nickname, user.nickname)
      && Objects.equals(email, user.email)
      && Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return this.id
      + this.email.length()
      + this.nickname.length()
      + this.password.length();
  }

  @Override
  public String toString() {
    return "{id="
      + id
      + ", nickname='"
      + nickname
      + ", email='"
      + email
      + ", password='"
      + password
      + '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
