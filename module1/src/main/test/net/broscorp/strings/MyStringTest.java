package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStringTest {

  private MyString myString;

  @BeforeEach
  void setUp() {
    myString = new MyString();
  }

  @Test
  void isPalindromeTrueTest() {
    assertTrue(myString.isPalindrome("No lemon no melon"));
  }

  @Test
  void isPalindromeFalseTest() {
    assertFalse(myString.isPalindrome("No lemon, no melons"));
  }

  @Test
  void onlyHelloTest() {
    String expected = "Hello";
    String actual = myString.onlyHello("Hello World!!!!");

    assertEquals(expected, actual);
  }

  @Test
  void onlyHelloExceptionTest() {
    assertThrows(IllegalStateException.class, () -> {
      myString.onlyHello("ello world");
    });
  }

  @Test
  void deleteAllLettersLTest() {
    String expected = "Heo Word!!!!";
    String actual = myString.deleteAllLettersL("Hello World!!!!");

    assertEquals(expected, actual);
  }

  @Test
  void replaceAllLettersOToQTest() {
    String expected = "Hellq Wqrld!!!!";
    String actual = myString.replaceAllLettersOToQ("Hello World!!!!");

    assertEquals(expected, actual);
  }

  @Test
  void outputWordsAndLength() {
    myString.outputWordsAndLength("No lemon no melon");
  }

  @Test
  void singSong() {
    myString.singSong(2, 10);
  }
}