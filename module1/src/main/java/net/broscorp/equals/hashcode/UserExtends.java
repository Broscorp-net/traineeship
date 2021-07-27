package net.broscorp.equals.hashcode;

public class UserExtends extends User {

  public UserExtends(String name, String email, int id) {
    super(name, email, id);
  }

  @Override
  public int hashCode() {
    return getName() != null ? getName().hashCode() : 0;
  }
}
