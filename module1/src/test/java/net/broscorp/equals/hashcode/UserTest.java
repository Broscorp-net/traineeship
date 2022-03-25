package net.broscorp.equals.hashcode;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  public void reflectionEqualsObjectTest() {
    User user = new User(1, "Sam");
    Assertions.assertTrue(user.equals(user));
  }

  @Test
  public void symmetryEqualsObjectTest() {
    User firstUser = new User(1, "Sam");
    User secondUser = new User(1, "Sam");
    Assertions.assertTrue(firstUser.equals(secondUser) && secondUser.equals(firstUser));
  }

  @Test
  public void transitivityEqualsObjectTest() {
    User firstUser = new User(1, "Sam");
    User secondUser = new User(1, "Sam");
    User thirdUser = new User(1, "Sam");
    Assertions.assertTrue(
        firstUser.equals(thirdUser) &&
            secondUser.equals(thirdUser) &&
            firstUser.equals(secondUser));

  }

  @Test
  public void objectEqualsNullTest() {
    User user = new User(1, "Sam");
    Assertions.assertNotEquals(null, user);
  }

  @Test
  public void twoObjectEqualsHashCodeTest() {
    User firstUser = new User(1, "Sam");
    User secondUser = new User(1, "Sam");
    Assertions.assertEquals(firstUser, secondUser);
    Assertions.assertEquals(firstUser.hashCode(), secondUser.hashCode());
  }

  @Test
  public void equalsHashCodeAfterSeveralCallTest() {
    User user = new User(1, "Sam");
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      set.add(user.hashCode());
    }
    Assertions.assertEquals(1, set.size());
  }

  @Test
  public void notEqualsObjectButEqualsHashCodeTest()  {
    User firstUser = new User(1, "Sam");
    User secondUser = new User(1, "Pit");
    Assertions.assertNotEquals(firstUser,secondUser);
    Assertions.assertEquals(firstUser.hashCode(),secondUser.hashCode());
    User[] array = new User[]{firstUser,secondUser};
  }
}
