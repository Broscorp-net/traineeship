package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
  private User u1;
  private User u2;
  private User u3;
  private List<User> users;

  /**
   * In this method which will be executed before each test
   * we initialize variables.
   */

  @BeforeEach
  public void setUp() {
    u1 = new User("John", "john@gmail.com", 1);
    u2 = new User("John", "john@gmail.com", 1);
    u3 = new User("John", "john@gmail.com", 1);

    users = new ArrayList<>();

    users.add(new User("Mike", "mike@gmail.com", 2));
    users.add(u1);
    users.add(new User("Tom", "tom@gmail.com", 3));
    users.add(u2);
  }

  @Test
  public void reflexiveTest() {
    assertTrue(u1.equals(u1));
  }

  @Test
  public void symmetricTest() {
    if (u1.equals(u2)) {
      assertTrue(u2.equals(u1));
    }
  }

  @Test
  public void transitiveTest() {
    if (u1.equals(u2) && u2.equals(u3)) {
      assertTrue(u1.equals(u3));
    }
  }

  @Test
  public void nullCheckTest() {
    if (u1 != null) {
      assertFalse(u1.equals(null));
    }
  }

  /**
   * If objects are equals they must have
   * same hashcode. But if two objects have
   * same hashcode it does not mean they must
   * be equal. Such situation is called collision.
   */

  @Test
  public void equalsHashCodeTest() {
    if (u1.equals(u2)) {
      assertTrue(u1.hashCode() == u2.hashCode());
    }
  }

  @Test
  public void hashcodeSearch() {
    List<User> sameHashUsers = new ArrayList<>();

    for (User u : users) {
      if (u3.hashCode() == u.hashCode()) {
        sameHashUsers.add(u);
      }
    }

    sameHashUsers.stream().forEach(s -> assertEquals(u3.hashCode(), s.hashCode()));
    assertEquals(2, sameHashUsers.size());
  }

  /**
   * In this test I have shown that we have two objects
   * which have same hashcode value but they are not
   * equal.
   * To reduce amount of code I have used inheritance
   * to create user1 and user2 objects for this test.
   */

  @Test
  public void notEqualObjectTest() {
    UserExtends user1 = new UserExtends("Alfred", "alfred@gmail.com", 5);
    UserExtends user2 = new UserExtends("Alfred", "alf1979@gmail.com", 6);

    assertEquals(user1.hashCode(), user2.hashCode());
    assertNotEquals(user1, user2);

    System.out.println("Hashes of both objects are the same\n"
            + user1.hashCode()
            + "\n" + user2.hashCode());
    System.out.println("Are objects equal? ==> " + user1.equals(user2));
  }
}
