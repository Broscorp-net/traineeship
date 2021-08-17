/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringsJoyTest {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final PrintStream originalErr = System.err;
  private static final String TEST_STR_RESULT = "Greetings - 9";

  @BeforeAll
  public static void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterAll
  public static void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  void isPalindrome() {
    assertTrue(StringsJoy.isPalindrome("aboba"));
    assertFalse(StringsJoy.isPalindrome("hehehe"));
  }

  @Test
  void cutToHello() {
    assertEquals("Hello", StringsJoy.cutToHello("Say Hello to your Mama"));
    assertEquals("", StringsJoy.cutToHello("You better shut up"));
  }

  @Test
  void removeAllL() {
    assertEquals("To he and back!", StringsJoy.removeAllL("To hell and back!"));
  }

  @Test
  void replaceOToQ() {
    assertEquals("Hqw bqring and small",
        StringsJoy.replaceOToQ("How boring and small"));
  }

  @Test
  void countWordsAndLetters() {
    StringsJoy.countWordsAndLetters("Greetings traveler");
    assertTrue(outContent.toString().contains(TEST_STR_RESULT));
  }

  @Test
  void memeSong() {
    StringsJoy.memeSong(20, 3);

    Pattern pattern = Pattern.compile("patch it");
    Matcher matcher = pattern.matcher(outContent.toString());

    int count = 0;
    while (matcher.find()) {
      count++;
    }

    assertEquals(3, count);
  }

}