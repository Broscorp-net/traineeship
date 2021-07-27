package net.broscorp.equals.hashcode;

public class User {
  private String name;
  private String email;
  private int id;

  /**
   * Constructor for all fields.
   * @param name user`s name
   * @param email user`s email
   * @param id user`s id
   */

  public User(String name, String email, int id) {
    this.name = name;
    this.email = email;
    this.id = id;
  }

  public String getName() {
    return name;
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

    if (id != user.id) {
      return false;
    }
    if (name != null ? !name.equals(user.name) : user.name != null) {
      return false;
    }
    return email != null ? email.equals(user.email) : user.email == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }

  @Override
  public String toString() {
    return "User{"
            +
            "name='" + name + '\''
            +
            ", email='" + email + '\''
            +
            ", id=" + id
            +
            '}';
  }
}
