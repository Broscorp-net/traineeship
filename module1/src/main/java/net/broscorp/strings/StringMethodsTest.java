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
    String givenString = "Hello World";
    String expectedString = "Hello: 5" + "\n" + "World: 5" + "\n";
    assertEquals(expectedString, stringMethods.outQuantityOfWordsInTheLineAndItLength(givenString));
  }

  @Test
  public void singMethod() {
    int quantityOfBags = 2;
    int quantityOfCouplets = 1;
    assertEquals(84, scoreSymbols(stringMethods.singMethod(quantityOfBags, quantityOfCouplets)));
  }

  private int scoreSymbols(String singMethod) {
    singMethod = singMethod.replace(" ", "")
        .replace(",", "")
        .replace(".", "")
        .replace("\n", "");

    return singMethod.length();
  }

}
