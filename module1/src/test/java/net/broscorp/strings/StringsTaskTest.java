package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Test;

class StringsTaskTest {


  @Test
  void palindromeFalseTest() {
    StringsTask stringsTask = new StringsTask();
    assertFalse(stringsTask.palindrome("Hello World"));
  }

  @Test
  void palindromeTrueTest() {
    StringsTask stringsTask = new StringsTask();
    assertTrue(stringsTask.palindrome("aboba"));
  }

  @Test
  void getHelloTest() {
    StringsTask stringsTask = new StringsTask();
    String actual = stringsTask.getHello("Hello World");
    String expected = "Hello";
    assertEquals(expected, actual);
  }

  @Test
  void removeLettersTest() {
    StringsTask stringsTask = new StringsTask();
    String actual = stringsTask.removeLL("Hello World");
    String expected = "Heo Word";
    assertEquals(expected, actual);
  }

  @Test
  void replaceLettersTest() {
    StringsTask stringsTask = new StringsTask();
    String actual = stringsTask.replaceOQ("Hello World");
    String expected = "Hellq Wqrld";
    assertEquals(expected, actual);
  }

  @Test
  void wordListAndCharsCountShowTest() {
    StringsTask stringsTask = new StringsTask();
    String[] strings = {"Hello", "World"};
    int num = 5;
    Map<String, Integer> map =
        stringsTask.wordListAndCharsCountShow("Hello World");
    int i = 0;
    for (Entry<String, Integer> entry : map.entrySet()) {
      assertEquals(entry.getKey(), strings[i]);
      assertEquals(entry.getValue(), num);
      i++;
    }
  }

  @Test
  void song() {
    StringsTask stringsTask = new StringsTask();
    String[] strings = {"7 little bugs in the code, \n"
        + "7 little bugs in the code. \n"
        + "Take one down, patch it around 12 little bugs in the code.\n\n",
        "12 little bugs in the code, \n"
            + "12 little bugs in the code. \n"
            + "Take one down, patch it around 6 little bugs in the code.\n\n"};
    Set<String> song = stringsTask.song(7, 2);
    int i = 0;
    for (String s : song) {
      assertEquals(s, strings[i]);
      i++;
    }
  }

}