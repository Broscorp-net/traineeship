package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {
  private final User user = new User(1, 24, "name", "lastName");
  private final User user2 = new User(1, 24, "name", "lastName");
  private final User user3 = new User(1, 24, "name", "lastName");
  private final User user4 = new User(2, 25, "name2", "lastName2");
  private final User user5 = new User(2, 25, "AaBB", "AaAa");
  private final User user6 = new User(2, 25, "BBAa", "BBBB");
  private final List<User> users = Arrays.asList(user, user6, user2, user3, user4, user5);

  @Test
  void equalsForNullShouldReturnFalse() {
    assertFalse(user.equals(null));
  }

  @Test
  void equalsForSelfShouldReturnTrue() {
    assertTrue(user.equals(user));
  }

  @Test
  void equalsShouldBeTransitivityAndAllTrue() {
    assertTrue(user.equals(user2));
    assertTrue(user2.equals(user3));
    assertTrue(user.equals(user3));
  }

  @Test
  void equalsShouldBeTransitivityAndFalseForOne() {
    assertTrue(user.equals(user2));
    assertFalse(user2.equals(user4));
    assertFalse(user.equals(user4));
  }

  @Test
  void equalsShouldBeSymmetryAndResultTrue() {
    assertTrue(user.equals(user2));
    assertTrue(user2.equals(user));
  }

  @Test
  void equalsShouldBeSymmetryAndResultFalse() {
    assertFalse(user.equals(user2));
    assertFalse(user2.equals(user));
  }

  @Test
  void equalsShouldBeConsistency() {
    assertTrue(user.equals(user2));
    assertFalse(user.equals(user4));

    assertTrue(user.equals(user2));
    assertFalse(user.equals(user4));
  }

  @Test
  void hashcodeShouldBeEqual() {
    int hashcode = user.hashCode();
    int hashcode2 = user.hashCode();
    assertEquals(hashcode, hashcode2);
  }

  @Test
  void hashcodeShouldBeEqualForSomeInvocation() {
    int hashcode = user.hashCode();
    int hashcode2 = user.hashCode();
    assertEquals(hashcode, hashcode2);
  }

  @Test
  void hashcodeShouldBeEqualForEqualsObjects() {
    assertTrue(user.equals(user2));
    int userHashcode = user.hashCode();
    int user2Hashcode = user2.hashCode();

    assertEquals(userHashcode, user2Hashcode);
  }

  @Test
  void sameHascodeForDifferentObjects() {
    assertFalse(user5.equals(user6));

    assertEquals(user5.hashCode(), user6.hashCode());
  }

  @Test
  void findDifferentObjectsWithSameHashcode() {
    for (int i = 0; i < users.size(); i++) {
      for (int j = i + 1; j < users.size(); j++) {
        if (users.get(i).hashCode() == users.get(j).hashCode()) {
          if (!users.get(i).equals(users.get(j))) {
            System.out.print(users.get(i) + " and "
                + users.get(j) + " different but hashcode the same ");
          }
        }
      }
    }
  }
}
