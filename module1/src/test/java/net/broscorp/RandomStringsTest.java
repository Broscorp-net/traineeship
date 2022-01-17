package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.broscorp.strings.RandomStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomStringsTest {

  public static String str = "Hello World";
  public static String mySong =
            "18 little bugs in the code,\n"
            + "18 little bugs in the code.\n"
            + "Take one down, patch it around 27 little bugs in the code.\n"
            + "\n"
            + "27 little bugs in the code,\n"
            + "27 little bugs in the code.\n"
            + "Take one down, patch it around 28 little bugs in the code.\n"
            + "\n"
            + "28 little bugs in the code,\n"
            + "28 little bugs in the code.\n"
            + "Take one down, patch it around 18 little bugs in the code.\n"
            + "\n";

  @Test
  void palindromeTrueTest() {
    Assertions.assertTrue(RandomStrings.palindromeString("madam"));
  }

  @Test
  void palindromeFalseTest() {
    Assertions.assertFalse(RandomStrings.palindromeString("monogram"));
  }

  @Test
  void helloWorldFirstTest() {
    assertEquals(RandomStrings.helloWorldFirst(str),"Hello");
  }

  @Test
  void helloWorldSecondTest() {
    assertEquals(RandomStrings.helloWorldSecond(str),"Heo Word");
  }

  @Test
  void helloWorldThirdTest() {
    assertEquals(RandomStrings.helloWorldThird(str),"Hellq Wqrld");
  }

  @Test
  void helloWorldFoursTest() {
    assertEquals("Hello 5\nWorld 5\n", RandomStrings.helloWorldFours(str));
  }

  @Test
  void textOfSongTest() {
    String song = RandomStrings.textOfSong(18,3);
    System.out.println(song);
    Assertions.assertTrue(true);
    Assertions.assertEquals(mySong, song);
  }
}