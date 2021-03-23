package net.broscorp.custom;

import java.util.ArrayList;
import java.util.List;

import net.broscorp.equals.hashcode.CustomUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CustomUserTest {

  private static List<CustomUser> users = new ArrayList<>();

  /**
   Все тесты нуждаются в одинаковых объектах, созданных до их запуска.
   */
  @BeforeAll
  public static void init() {
    users.add(new CustomUser(1, "email1", "password1"));
    users.add(new CustomUser(1, "email2", "password2"));
    users.add(new CustomUser(2, "email3", "password3"));
    users.add(new CustomUser(1, "email1", "password1"));
    users.add(new CustomUser(1, "email1", "password1"));
    users.add(new CustomUser(1, "BB", "Aa"));
    users.add(new CustomUser(1, "Aa", "BB"));
  }

  @Test
  public void passEquals() {
    Assertions.assertEquals(users.get(0), users.get(4));
  }

  @Test
  public void failEquals() {
    Assertions.assertNotEquals(users.get(0), users.get(1));
  }

  @Test
  public void passRefEquals() {
    Assertions.assertEquals(users.get(0), users.get(0));
  }

  @Test
  public void failEqualsNull() {
    Assertions.assertNotEquals(users.get(0), null);
  }

  @Test
  void passTransEquals() {
    Assertions.assertEquals(users.get(0), users.get(3));
    Assertions.assertEquals(users.get(3), users.get(4));
    Assertions.assertEquals(users.get(3), users.get(4));
  }

  @Test
  void passSemEquals() {
    Assertions.assertEquals(users.get(0), users.get(4));
    Assertions.assertEquals(users.get(4), users.get(0));
  }

  @Test
  public void passHashCodes() {
    Assertions.assertEquals(users.get(0).hashCode(), users.get(0).hashCode());
  }

  @Test
  public void passHashCodesEqualsOb() {
    Assertions.assertEquals(users.get(4).hashCode(), users.get(0).hashCode());
  }

  @Test
  public void failHashCodes() {
    Assertions.assertNotEquals(users.get(1).hashCode(), users.get(0).hashCode());
  }

  @Test
  public void passToString() {
    Assertions.assertEquals(users.get(0).toString(), users.get(4).toString());
  }

  @Test
  public void failToString() {
    Assertions.assertNotEquals(users.get(0).toString(), users.get(1).toString());
  }

  @Test
  void findSameHashcode() {
    for (int i = 0; i < users.size(); i++) {
      for (int j = i + 1; j < users.size(); j++) {
        if (users.get(i).hashCode() == users.get(j).hashCode()) {
          System.out.print(i + " and " + j + "hashcode the same ");
        }
      }
    }
  }

  @Test
  void sameHashcodeForDifferentObjects() {
    Assertions.assertNotEquals(users.get(5), users.get(6));
    Assertions.assertEquals(users.get(5).hashCode(), users.get(6).hashCode());
  }
}
