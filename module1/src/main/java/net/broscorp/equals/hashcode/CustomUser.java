package net.broscorp.equals.hashcode;

import java.util.Objects;

public class CustomUser {
  private Integer id;
  private String email;
  private String password;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomUser that = (CustomUser) o;
    return Objects.equals(id, that.id)
            && Objects.equals(email, that.email)
            && Objects.equals(password, that.password);
  }


  @Override
  public int hashCode() {
    return Objects.hash(id, email, password);
  }

  @Override
  public String toString() {
    return "CustomUser{"
            + "id=" + id
            + ", email='" + email
            + '\''
            + ", password='" + password
            + '\'' + '}';
  }

  /**
   * Constructor for CustomUser.
   *
   * @param id - id User
   * @param email - email User
   * @param password - user password
   */
  public CustomUser(Integer id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

}
