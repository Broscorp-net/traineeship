package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStringsTest {

  public static final String HELLO_WORLD = "Hello World";

  public static final String SONG_EXPECTED =
      "34 little bugs in the code,\n"
          + "34 little bugs in the code.\n"
          + "Take one down, patch it around 24 little bugs in the code.\n"
          + "\n"
          + "24 little bugs in the code,\n"
          + "24 little bugs in the code.\n"
          + "Take one down, patch it around 16 little bugs in the code.\n"
          + "\n"
          + "16 little bugs in the code,\n"
          + "16 little bugs in the code.\n"
          + "Take one down, patch it around 7 little bugs in the code.\n"
          + "\n"
          + "7 little bugs in the code,\n"
          + "7 little bugs in the code.\n"
          + "Take one down, patch it around 16 little bugs in the code.\n"
          + "\n"
          + "16 little bugs in the code,\n"
          + "16 little bugs in the code.\n"
          + "Take one down, patch it around 8 little bugs in the code.";



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
    assertEquals("Hello 5\nWorld 5\n", MyStrings.helloWorld4(HELLO_WORLD));
  }

  @Test
  void songTextTest() {
    String song = MyStrings.songText(34,5);
    Assertions.assertEquals(SONG_EXPECTED, song);
  }
}
