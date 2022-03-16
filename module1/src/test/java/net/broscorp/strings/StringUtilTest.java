package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilTest {

  private StringUtil stringUtil;
  private static final String HELLOWORLD = "Hello world";

  @BeforeEach
  void create() {
    stringUtil = new StringUtil();
  }

  @Test
  void isPalindrome() {
    assertTrue(stringUtil.isPalindrome("b l a bl a al b alb"));
    assertFalse(stringUtil.isPalindrome(HELLOWORLD));
  }

  @Test
  void stringHello() {
    assertEquals(stringUtil.stringHello(HELLOWORLD), "Hello");
  }

  @Test
  void stringWithOutL() {
    assertEquals(stringUtil.stringWithOutL(HELLOWORLD), "Heo word");
  }

  @Test
  void changeOToQ() {
    assertEquals(stringUtil.changeOToQ(HELLOWORLD), "Hellq wqrld");
  }

  @Test
  void wordsAndLetter() {
    assertEquals(stringUtil.wordsAndLetter(HELLOWORLD), "Hello=5\\nworld=5\\n");
  }

  @Test
  void bugSong() {
    String str = "3 little bugs in the code,\n"
        + "3 little bugs in the code.\n"
        + "Take one down, patch it around 2 little bugs in the code.\n"
        + "2 little bugs in the code,\n"
        + "2 little bugs in the code.\n"
        + "Take one down, patch it around 8 little bugs in the code.\n"
        + "8 little bugs in the code,\n"
        + "8 little bugs in the code.\n"
        + "Take one down, patch it around 6 little bugs in the code.\n";
    assertEquals(stringUtil.bugSong(3, 3), str);
  }
}