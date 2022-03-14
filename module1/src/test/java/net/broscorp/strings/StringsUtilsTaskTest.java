package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringsUtilsTaskTest {

  @Test
  void checkForPalindrom() {
    String wordOne = "hello";
    String wordTwo = "helleh";

    assertFalse(StringsUtilsTask.checkForPalindrom(wordOne));
    assertTrue(StringsUtilsTask.checkForPalindrom(wordTwo));
  }

  @Test
  void cutAllAfterFirstWord() {
    String str = "Hello Word";
    String expected = "Hello";

    assertEquals(expected, StringsUtilsTask.cutAllAfterFirstWord(str));
  }

  @Test
  void removeSymbolL() {
    String str = "Hello Word";
    String expected = "Heo Word";

    assertEquals(expected, StringsUtilsTask.removeSymbolL(str));
  }

  @Test
  void replaceSymbolO() {
    String str = "Hello Word";
    String expected = "Hellq Wqrd";

    assertEquals(expected, StringsUtilsTask.replaceSymbolO(str));
  }

  @Test
  void countWordsAndSymbols() {
    String str = "There is an example of working method countWordsAndSymbols";
    String expected = "There(5)\tis(2)\tan(2)\texample(7)\tof(2)\tworking(7)\t"
        + "method(6)\tcountWordsAndSymbols(20)\t// word counter -> 8";

    assertEquals(expected, StringsUtilsTask.countWordsAndSymbols(str));

  }

  @Test
  void songWithBugs() {
    String expected = "3 little bugs in a code,\n"
        + "3 little bugs in a code.\n"
        + "Take one down, patch it around 4 little bugs in a code.\n"
        + "4 little bugs in a code,\n"
        + "4 little bugs in a code.\n"
        + "Take one down, patch it around 9 little bugs in a code.\n"
        + "9 little bugs in a code,\n"
        + "9 little bugs in a code.\n"
        + "Take one down, patch it around -1 little bugs in a code.\n";

    assertEquals(expected, StringsUtilsTask.songWithBugs(3,3));
  }
}