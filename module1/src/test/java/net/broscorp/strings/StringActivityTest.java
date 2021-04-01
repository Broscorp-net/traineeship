package net.broscorp.strings;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringActivityTest {

  private StringActivity stringActivity;
  private String inputText;

  @BeforeEach
  void init() {
    stringActivity = new StringActivity();
    inputText = "Hello world!";
  }

  @Test
  void palindromeTest() {
    Assertions.assertTrue(stringActivity.palindrome("Madam"));
    Assertions.assertFalse(stringActivity.palindrome("Test"));
  }

  @Test
  void deleteEverythingExpectSaveWordTest() {
    String save = "Hello";
    Assertions
        .assertEquals(save, stringActivity.deleteEverythingExpectSaveWord(inputText, save));
  }

  @Test
  void deleteCharTest() {
    String ch = "o";
    String expected = inputText.replaceAll(ch, "");
    Assertions
        .assertEquals(expected, stringActivity.deleteChar(inputText, ch));
  }

  @Test
  void replaceOtoQTest() {
    Assertions
        .assertEquals("Hellq wqrld!", stringActivity.replaceOtoQ(inputText, "o", "q"));
  }

  @Test
  void outputListWithLengthWordTest() {
    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));

    List<String> listTest = Arrays.asList("First", "Count", "Second");
    Map<String, Integer> mapTest = stringActivity.outputListWords(listTest);

    for (String s : listTest) {
      Assertions.assertEquals(s.length(), mapTest.get(s));
    }
    Assertions.assertEquals(mapTest.toString(), outputStreamCaptor.toString().trim());
    Assertions.assertEquals("{Second=6, Count=5, First=5}", outputStreamCaptor.toString().trim());

    System.setOut(standardOut);
  }

  @Test
  void randomSongTest() {
    String expected = "\n"
        + "Verse 1 \n"
        + "8 little bugs in the code, \n"
        + "8 little bugs in the code. \n"
        + "Take one down, patch it around 9 little bugs in the code.\n"
        + "\n"
        + "Verse 2 \n"
        + "9 little bugs in the code, \n"
        + "9 little bugs in the code. \n"
        + "Take one down, patch it around 11 little bugs in the code.\n";

    Assertions.assertEquals(expected, stringActivity.randomSong(8, 2));
  }
}