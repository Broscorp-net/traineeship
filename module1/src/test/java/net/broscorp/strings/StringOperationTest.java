package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class StringOperationTest {
  private StringOperation operation = new StringOperation();

  @Test
  void isPalindromeShouldReturnTrue() {
    assertTrue(operation.isPalindrome("adda"));
  }

  @Test
  void isPalindromeShouldReturnFalse() {
    assertFalse(operation.isPalindrome("qwerty"));
  }

  @Test
  void cutHelloShouldReturnHello() {
    assertEquals(operation.cutHello("Hello World"), "Hello");
  }

  @Test
  void cutHelloShouldReturnHelloDoesntExist() {
    assertEquals(operation.cutHello("Hi World"), "Hello doesn`t exist");
  }

  @Test
  void removeLShouldRemoveAllL() {
    assertEquals(operation.removeL("Hello"), "Heo");
  }

  @Test
  void replaceOAndQShouldReplaceThat() {
    assertEquals(operation.replaceOAndQ("Hello"), "Hellq");
  }

  @Test
  void printLetterAndWords() {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    operation.printLetterAndWords("Hello World All");
    assertEquals("Word : Hello with quantity letters : 5\n"
        + "Word : World with quantity letters : 5\n"
        + "Word : All with quantity letters : 3", output.toString().trim());
  }

  @Test
  void textSongShouldReturnRightSong() {
    String expectedSong = "4 little bugs in the code, \n"
        + "4 little bugs in the code. \n"
        + "Take one down, patch it around 7 little bugs in the code.\n"
        + "7 little bugs in the code, \n"
        + "7 little bugs in the code. \n"
        + "Take one down, patch it around 13 little bugs in the code."
        + "\n13 little bugs in the code, \n"
        + "13 little bugs in the code. \n"
        + "Take one down, patch it around 4 little bugs in the code."
        + "\n4 little bugs in the code, \n"
        + "4 little bugs in the code. \n"
        + "Take one down, patch it around -5 little bugs in the code."
        + "\n-5 little bugs in the code, \n"
        + "-5 little bugs in the code. \n"
        + "Take one down, patch it around -10 little bugs in the code.\n";

    String actualSong = operation.textSong(4, 5);
    assertEquals(expectedSong, actualSong);
  }
}
