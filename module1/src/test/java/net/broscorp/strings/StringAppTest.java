package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringAppTest {

  String hello = "Hello World";

  @Test
  void palindrome() {
    StringApp app = new StringApp();

    assertTrue(app.palindrome("Kazak"));
    assertFalse(app.palindrome("Kazako"));
  }

  @Test
  void hello() {

    StringApp app = new StringApp();

    assertEquals("Hello", app.hello(hello));
  }

  @Test
  void deleteL() {

    StringApp app = new StringApp();

    assertEquals("Heo Word", app.deleteL(hello));
  }

  @Test
  void change_O() {

    StringApp app = new StringApp();

    assertEquals("Hellq Wqrld", app.change_O(hello));
  }

  @Test
  void numberOfWordsAndLetters() {

    StringApp app = new StringApp();
    int [][] arr2 = {{5}, {5}};
    assertArrayEquals(app.numberOfWordsAndLetters(hello), arr2);
  }

  @Test
  void littleBugs() {

    StringApp app = new StringApp();

    String expected =
        "10 little bugs in the code, \n"
            + "10 little bugs in the code. \n"
            + "Take one down, patch it around 6 little bugs in the code. \n"
            + "6 little bugs in the code, \n"
            + "6 little bugs in the code. \n"
            + "Take one down, patch it around 2 little bugs in the code. \n"
            + "2 little bugs in the code, \n"
            + "2 little bugs in the code. \n"
            + "Take one down, patch it around -2 little bugs in the code. \n";
    String actual = app.littleBugs(10, 3);
    assertEquals(expected, actual);
  }
}
