package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAppTest {

  String hello = "Hello World";

  @Test
  @DisplayName("Check string on palindrome")
  void palindrome() {
    StringApp app = new StringApp();

    assertTrue(app.palindrome("Kazak"));
    assertFalse(app.palindrome("Kazako"));
  }

  @Test
  @DisplayName("say only Hello")
  void hello() {

    StringApp app = new StringApp();

    assertEquals("Hello", app.hello(hello));
  }

  @Test
  @DisplayName("Say Hello World without L")
  void deleteL() {

    StringApp app = new StringApp();

    assertEquals("Heo Word", app.deleteL(hello));
  }

  @Test
  @DisplayName("Say Hello World with Q instead of O")
  void change_O() {

    StringApp app = new StringApp();

    assertEquals("Hellq Wqrld", app.change_O(hello));
  }

  @Test
  @DisplayName("Look by the amount of words and letters")
  void numberOfWordsAndLetters() {

    StringApp app = new StringApp();

    app.numberOfWordsAndLetters(hello);
  }

  @Test
  @DisplayName("little bugs")
  void littleBugs() {

    StringApp app = new StringApp();

    app.littleBugs(10, 3);
  }
}
