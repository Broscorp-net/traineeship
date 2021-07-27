package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest {

  // equals invariants

  @Test
  public void equalsShouldReturnTrueIfObjectIsTheSame() {
    //given
    User user = new User(1, "nickname", "email@mail.com", "qwerty");
    //when
    //then
    assertTrue(user.equals(user));
  }

  @Test
  public void equalsShouldReturnTrueIfObjectsAreSymmetrical() {
    //given
    User userX = new User(1, "nickname", "email@mail.com", "qwerty");
    User userY = new User(1, "nickname", "email@mail.com", "qwerty");
    //when
    //then
    assertTrue(userX.equals(userY) && userY.equals(userX));
  }

  @Test
  public void equalsShouldReturnTrueIfObjectsAreTransitive() {
    //given
    User userX = new User(1, "nickname", "email@mail.com", "qwerty");
    User userY = new User(1, "nickname", "email@mail.com", "qwerty");
    User userZ = new User(1, "nickname", "email@mail.com", "qwerty");
    //when
    //then
    assertTrue(userX.equals(userY));
    assertTrue(userY.equals(userZ));
    assertTrue(userX.equals(userZ));
  }

  @Test
  public void equalsShouldReturnFalseIfObjectsAreNotConsistent() {
    //given
    User userX = new User(1, "nickname", "email@mail.com", "qwerty");
    User userY = new User(1, "nickname", "email@mail.com", "qwerty");
    assertTrue(userX.equals(userY));
    //when
    userX.setId(2);
    //then
    assertFalse(userX.equals(userY));
  }

  @Test
  public void equalsShouldReturnFalseIfObjectIsNull() {
    //given
    User userX = new User(1, "nickname", "email@mail.com", "qwerty");
    //when
    //then
    assertFalse(userX.equals(null));
  }

  // hashCode invariants

  @Test
  public void hashCodeShouldReturnADifferentValueIfObjectIsChanged() {
    //given
    User userX = new User(1, "nickname", "email@mail.com", "qwerty");
    int hashCodeValue = userX.hashCode();
    //when
    userX.setId(20);
    //then
    assertNotEquals(hashCodeValue, userX.hashCode());
  }

  @Test
  public void hashCodeShouldReturnTheSameValueIfEqualsReturnTrue() {
    //given
    User userX = new User(1, "nickname", "email@mail.com", "qwerty");
    User userY = new User(1, "nickname", "email@mail.com", "qwerty");
    //when
    //then
    assertTrue(userX.equals(userY));
    assertEquals(userX.hashCode(), userY.hashCode());
  }

  @Test
  public void hashCodeReturnTheSameValuesButEqualsReturnFalse() {
    //given
    User userX = new User(1, "kirk_hammett_", "email@mail.com", "qwerty");
    User userY = new User(1, "dave_mustaine", "email@mail.com", "qwerty");
    //when
    //then
    assertFalse(userX.equals(userY));
    assertEquals(userX.hashCode(), userY.hashCode());
  }

  @Test
  public void findObjectsWhereHashCodeIsTheSame() {
    //given
    List<User> userList = Arrays.asList(
        new User(1, "James_Hetfield", "email@mail.com", "q"),
        new User(2, "James_Hetfield", "email@mail.com", "q"),
        new User(1, "Lars_Ulrich", "email@mail.com", "q"),
        new User(1, "Cliff_Burton", "email@mail.com", "q"),
        new User(1, "Kirk_Hammett", "email@mail.com", "q"),
        new User(1, "Dave_Mustaine", "email@mail.com", "q"),
        new User(1, "Jason_Newsted", "email@mail.com", "q")
    );
    //when
    for (int i = 0; i < userList.size(); i++) {
      for (int j = i; j < userList.size(); j++) {
        User user = userList.get(i);
        User anotherUser = userList.get(j);
        boolean hashCodesEqual = user.hashCode() == anotherUser.hashCode();
        boolean objectsEqual = user.equals(anotherUser);

        //then
        if (hashCodesEqual && !objectsEqual) {
          System.out.println(createString(user, anotherUser));

          assertTrue(hashCodesEqual);
          assertFalse(objectsEqual);
        }

      }
    }
  }

  private String createString(User user, User anotherUser) {
    return "User A: "
      + user.toString()
      + " is not equal to User B: "
      + anotherUser.toString()
      + ", but their hashCodes are the same.\n"
      + "User A hashCode - " + user.hashCode()
      + "\nUser B hashCode - " + anotherUser.hashCode();
  }

}
