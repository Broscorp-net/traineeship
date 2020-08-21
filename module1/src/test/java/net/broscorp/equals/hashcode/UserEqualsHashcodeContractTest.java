package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserEqualsHashcodeContractTest {

  private List<User> users;

  @BeforeEach
  void setup() {
    users = Stream.of(
        new User(1,20, "anna@email.com"),
        new User(1,20, "anna@email.com"),
        new User(1,20, "anna@email.com")).collect(Collectors.toList());
  }

  @Test
  void testUserReflexive() {
    User user = new User(1,20, "anna@email.com");
    assertTrue(user.equals(users.get(0)));
  }

  @Test
  void testUserSymmetric() {
    User userTwo = users.get(0);
    User userOne = users.get(1);
    assertTrue(userOne.equals(userTwo) && userTwo.equals(userOne));
  }

  @Test
  void testUserTransitivity() {
    User userTwo = users.get(0);
    User userOne = users.get(1);
    User userThree = users.get(2);
    assertTrue(userOne.equals(userTwo)
        && userTwo.equals(userThree) && userOne.equals(userThree));
  }

  @Test
  void testUserNull() {
    User user = users.get(0);
    assertFalse(user.equals(null));
  }

  @Test
  void testUserConsistent() {
    User userOne = users.get(0);
    User userTwo = users.get(1);
    assertTrue(userOne.equals(userTwo) && userTwo.equals(userOne));

    userOne.setAge(30);
    assertFalse(userOne.equals(userTwo));
  }

  @Test
  void testUserHashcodeOneOrMore() {
    User userOne = users.get(0);
    User userTwo = users.get(1);

    assertTrue(userOne.hashCode() == userTwo.hashCode());
    assertTrue(userOne.hashCode() == userTwo.hashCode());
  }

  @Test
  void testUserHashcodeIfEquals() {
    User userOne = users.get(0);
    User userTwo = users.get(1);

    assertTrue(userOne.equals(userTwo) && userOne.hashCode() == userTwo.hashCode());
  }
}
