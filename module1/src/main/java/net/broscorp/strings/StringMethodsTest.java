package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringMethodsTest {

  private StringMethods stringMethods = new StringMethods();

  @Test
  public void isPalindromeTest() {
    assertTrue(stringMethods.isPalindrome("My name is Siemanym"));
  }

  @Test
  public void helloInEndTest() {
    assertEquals("Hello", stringMethods.helloInEnd("Hello World"));
  }

  @Test
  public void deleteAllSymbolsLFromTheLineTest() {
    assertEquals("Heo Word", stringMethods.deleteAllSymbolsLFromTheLine("Hello World"));
  }

  @Test
  public void swapSymbolsOOnQInTheLineTest() {
    assertEquals("Hellq Wqrld", stringMethods.swapSymbolsOOnQInTheLine("Hello World"));
  }

  @Test
  public void outQuantityOfWordsInTheLineAndItLengthTest() {
    stringMethods.outQuantityOfWordsInTheLineAndItLength("Hello World");
  }

  @Test
  public void singMethod() {
    stringMethods.singMethod(2, 4);
  }

}
