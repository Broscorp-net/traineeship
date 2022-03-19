package net.broscorp.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringsTest {
  Strings str = new Strings();

  @Test
  void palindromTest() {
    Assertions.assertTrue(str.palindrom("Ася, молоко около мяса"));
  }

  @Test
  void helloTest() {
    Assertions.assertEquals("Hello",str.hello());
  }

  @Test
  void ldelTest() {
    Assertions.assertEquals("Heo Word",str.ldel());
  }

  @Test
  void changeTest() {
    Assertions.assertEquals("Hellq Wqrld",str.change());
  }

  @Test
  void wordsCountTest() {
    Assertions.assertEquals(2,str.reconLater());
  }

  @Test
  void songTest() {
    String[] words = str.song(13,2).replace("/n", " ").split(" ");
    Assertions.assertEquals(13, Integer.parseInt(words[0]));
    Assertions.assertEquals(7, Integer.parseInt(words[18]));
    Assertions.assertEquals(13, Integer.parseInt(words[41]));
  }

}
