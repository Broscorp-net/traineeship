package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {

  private static List<User> userList = new ArrayList<>();

  /**
   * init method.
   */
  @BeforeAll
  public static void init() {
    userList.add(new User(1, "testUsername1", "testPassword1", 20, true));
    userList.add(new User(2, "testUsername2", "testPassword2", 21, true));
    userList.add(new User(1, "testUsername1", "testPassword1", 20, true));
    userList.add(new User(2, "testUsername2", "testPassword2", 21, true));
    userList.add(new User(1, "testUsername1", "testPassword1", 20, true));
    userList.add(new User(4, "BB", "Aa", 25, false));
    userList.add(new User(4, "Aa", "BB", 25, false));
    for (User user : userList) {
      System.out.println(user);
    }
  }

  /**
   * Reflexive: for any non-null reference value x, x.equals(x) should return true.
   */
  @Test
  public void reflexiveEquals() {
    Assertions.assertEquals(userList.get(0), userList.get(0));
  }

  /**
   * Symmetric: for any non-null reference values x and y, x.equals(y) should return true if and
   * only if y.equals(x) returns true.
   */
  @Test
  public void symmetricEquals() {
    Assertions.assertEquals(userList.get(0), userList.get(2));
    Assertions.assertEquals(userList.get(2), userList.get(0));
  }

  /**
   * Transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and
   * y.equals(z) returns true, then x.equals(z) should return true.
   */
  @Test
  public void transitiveEquals() {
    Assertions.assertEquals(userList.get(0), userList.get(2));
    Assertions.assertEquals(userList.get(2), userList.get(4));
    Assertions.assertEquals(userList.get(0), userList.get(4));
  }

  /**
   * Consistent: for any non-null reference values x and y, multiple invocations of x.equals(y)
   * consistently return true or consistently return false, provided no information used in equals
   * comparisons on the objects is modified.
   */
  @Test
  public void consistentEquals() {
    Assertions.assertEquals(userList.get(0), userList.get(2));
    Assertions.assertNotEquals(userList.get(0), userList.get(1));
    Assertions.assertEquals(userList.get(0), userList.get(2));
    Assertions.assertNotEquals(userList.get(0), userList.get(1));
  }

  /**
   * For any non-null reference value x, x.equals(null) should return false.
   */
  @Test
  public void nullEquals() {
    Assertions.assertNotEquals(userList.get(0), null);
  }

  /**
   * Whenever it is invoked on the same object more than once during an execution of a Java
   * application, the hashCode method must consistently return the same integer, provided no
   * information used in equals comparisons on the object is modified.
   */
  @Test
  public void equalsHashCode() {
    Integer hash = userList.get(0).hashCode();
    Assertions.assertEquals(hash, userList.get(0).hashCode());
  }

  /**
   * If two objects are equal according to the equals(Object) method, then calling the hashCode
   * method on each of the two objects must produce the same integer result.
   */
  @Test
  public void equalsHashCodeByEquals() {
    Integer hashFirst = userList.get(0).hashCode();
    Integer hashSecond = userList.get(2).hashCode();

    Assertions.assertEquals(userList.get(0), userList.get(2));
    Assertions.assertEquals(hashFirst, hashSecond);
  }

  /**
   * It is not required that if two objects are unequal according to the equals(Object) method, then
   * calling the hashCode method on each of the two objects must produce distinct integer results.
   */
  @Test
  public void notEqualsHashCod() {
    Integer hashFirst = userList.get(0).hashCode();
    Integer hashSecond = userList.get(1).hashCode();

    Assertions.assertNotEquals(userList.get(0), userList.get(1));
    Assertions.assertNotEquals(hashFirst, hashSecond);
  }

  @Test
  public void equalHashCodButNotEquals() {
    Integer hashFirst = userList.get(5).hashCode();
    Integer hashSecond = userList.get(6).hashCode();

    Assertions.assertNotEquals(userList.get(5), userList.get(6));
    Assertions.assertEquals(hashFirst, hashSecond);
  }

  /**
   * Find objects with the same hashCode and equals returning false.
   */
  @Test
  public void findObjectsWithTheSameHashCodesAndEqualsReturnFalse() {
    for (int i = 0; i < userList.size(); i++) {
      for (int j = i + 1; j < userList.size(); j++) {
        if ((userList.get(i).hashCode() == userList.get(j).hashCode())
            && !(userList.get(i).equals(userList.get(j)))) {
          System.out.println(
              "Here is object " + userList.get(i) + ",\n here is object " + userList.get(i)
                  + "\nthey are different but their hash is the same " + userList.get(j)
                  .hashCode());
        }
      }
    }
  }
}
