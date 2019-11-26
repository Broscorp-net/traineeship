package net.broscorp.n_strings;

import static net.broscorp.n_strings.StringTask.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class StringTaskTest {

  @Test
  void testIsPalindromeTrue() {
    String line = "Non";
    assertTrue(isPalindrome(line));
  }

  @Test
  void testIsPalindromeFalse() {
    String line = "line";
    assertFalse(isPalindrome(line));
  }

  @Test
  void testCutLine() {
    String line = "Hello World";
    assertEquals("Hello", cutLine(line));
  }

  @Test
  void testDeleteSymbolInLine() {
    String line = "Hello World";
    assertEquals("Heo Word", deleteSymbolInLine(line));
  }

  @Test
  void testChangeSymbol() {
    String line = "Hello World";
    assertEquals("Hellq Wqrld", changeSymbol(line));
  }

  @Test
  void testCountWordsAndCountSymbols() {
    String line = "Hello World";
    assertEquals("{Hello=5, World=5}", countWordsAndCountSymbols(line));
  }

  @Test
  void testMakeSongCountCouplet() {
    String song = makeSong(3, 99);
    String[] couplets = song.split("\\n\\n");

    assertEquals(3, couplets.length);
  }

  @Test
  void testMakeSongBugsWithSeed() {
    String song = makeSong(2, 99);
    String[] couplets = song.split("\\n\\n");

    List<Integer> bugsInCouplets = new ArrayList<>();
    for (int i = 0; i < couplets.length; i++) {
      String substring = couplets[i].substring(couplets[i].length() - 1);
      bugsInCouplets.add(Integer.parseInt(substring));
    }

    assertEquals(7, bugsInCouplets.get(0));
    assertEquals(7, bugsInCouplets.get(1));
  }

  @Test
  void testMakeSongCoupletZero() {
    assertThrows(RuntimeException.class, () -> makeSong(0, 99));
  }
}