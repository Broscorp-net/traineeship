package net.broscorp.equals.hashcode;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {

  private long id;
  private String name;

  public User(@NonNull long id, @NonNull String name) {
    this.id = id;
    this.name = name;
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
    return name.equals(user.name);
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + name.length();
    return result;
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + '}';
  }
}
