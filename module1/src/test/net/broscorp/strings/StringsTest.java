package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StringsTest {

  Strings strings = new Strings();

  @Test
  void checkStringIsPalindrom() {
    assertAll(
        () -> assertEquals(strings.isPalindrom("Madam"), true, "must be true - it's a palindrom"),
        () -> assertEquals(strings.isPalindrom("abCba"), true, "must be true - it's a palindrom"),
        () -> assertNotEquals(strings.isPalindrom("palindrom"), true,
            "must be false - it's not a palindrom")
    );
  }

  @Test
  void cutStringAfterFirstWord() {
    assertAll(
        () -> assertEquals(strings.firstWord("Hello World"), "Hello"),
        () -> assertEquals(strings.firstWord("first second ect"), "first")
    );
  }

  @Test
  void replace_l_FromString() {
    assertAll(
        () -> assertEquals(strings.replace_l("Hello World"), "Heo Word"),
        () -> assertEquals(strings.replace_l("lsomelllStringl"), "someString")
    );
  }

  @Test
  void replace_o_to_q() {
    assertAll(
        () -> assertEquals(strings.replace_o_to_q("Hello World"), "Hellq Wqrld"),
        () -> assertEquals(strings.replace_o_to_q("ooooo"), "qqqqq")
    );
  }

  @Test
  void wordsListWithCharsCount() {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    strings.wordsListWithCharsCount("Hello World");

    System.setOut(null);

    String expect = ""
        + "Hello - has 5 chars\n"
        + "World - has 5 chars\n";
    assertEquals(expect, output.toString());
  }

  @Test
  void verifySongText() {
    String expect = "100 little bugs in the code,\n"
        + "100 little bugs in the code.\n"
        + "Take one down, patch it around 93 little bugs in the code.\n"
        + "93 little bugs in the code,\n"
        + "93 little bugs in the code.\n"
        + "Take one down, patch it around 95 little bugs in the code.\n"
        + "95 little bugs in the code,\n"
        + "95 little bugs in the code.\n"
        + "Take one down, patch it around 95 little bugs in the code.\n";
    String result = strings.getSongText(100, 3);
    assertEquals(expect, result);
  }

  @Test
  void verifyStartNumberOfBugs() {
    int expectNumerOfBugs = 1000;
    int result;
    String songText = strings.getSongText(expectNumerOfBugs, 5);
    String[] songLines = songText.split("\n");
    result = new Scanner(songLines[0]).nextInt();
    assertEquals(expectNumerOfBugs, result);
  }

  @Test
  void verifyNumbersOfCouplets() {
    int expectNumerOfCouplets = 5;
    int result;
    String songText = strings.getSongText(100, expectNumerOfCouplets);
    result = (int) Stream.of(songText.split("\n"))
        .filter(s -> s.contains("Take one down, patch it around"))
        .count();
    assertEquals(expectNumerOfCouplets, result);
  }
}