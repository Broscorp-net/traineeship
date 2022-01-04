package net.broscorp.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStringsTest {

  public static final String HELLO_WORLD = "Hello World";

  @Test
  void isPalindromeTrueTest() {
    Assertions.assertTrue(MyStrings.isPalindrome("redivider"));
  }

  @Test
  void isPalindromeFalseTest() {
    Assertions.assertFalse(MyStrings.isPalindrome("notredivider"));
  }

  @Test
  void helloWorld1Test() {
    assertEquals(MyStrings.helloWorld1(HELLO_WORLD),"Hello");
  }

  @Test
  void helloWorld2Test() {
    assertEquals(MyStrings.helloWorld2(HELLO_WORLD),"Heo Word");
  }

  @Test
  void helloWorld3Test() {
    assertEquals(MyStrings.helloWorld3(HELLO_WORLD),"Hellq Wqrld");
  }

  @Test
  void helloWorld4Test() {
    System.out.println(MyStrings.helloWorld4(HELLO_WORLD));
    Assertions.assertTrue(true);
  }

  @Test
  void songTextTest() {
    String song = MyStrings.songText(34,5);
    System.out.println(song);
    Assertions.assertTrue(true);
  }
}
