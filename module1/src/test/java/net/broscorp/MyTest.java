package net.broscorp;

import net.broscorp.strings.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTest {

  private StringUtils stringUtils;

  @BeforeEach
  void create() {
    stringUtils = new StringUtils();
  }

  @Test
  void testPolindrom() {
    Assertions.assertTrue(stringUtils.isPolindrom("avfg gf va"));
    Assertions.assertFalse(stringUtils.isPolindrom("fdsfdsf"));
  }

  @Test
  void testNoWorldHello() {
    Assertions.assertEquals(stringUtils.noWorldHello(), "Hello");
  }

  @Test
  void testNoMoreLWillBeHere() {
    Assertions.assertEquals(stringUtils.noMoreLWillBeHere(), "Heo Word");
  }

  @Test
  void testQInsteadO() {
    Assertions.assertEquals(stringUtils.pasteQInsteadO(), "Hellq Wqrld");
  }

  @Test
  void testLetterCounter() {
    Assertions.assertEquals(stringUtils.letterCounter(), "{Hello=5, World=5}");
  }

  @Test
  void testSingSong() {
    Assertions.assertEquals(stringUtils.singSong(10, 10).split("\n").length, 30);
  }
}