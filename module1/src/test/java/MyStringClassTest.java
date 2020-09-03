import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import net.broscorp.strings.MyStringClass;

import org.junit.jupiter.api.Test;

class MyStringClassTest {
  MyStringClass myStringClass = new MyStringClass();

  @Test
  void isPalindromeTest() {
    String palindrome = "tenet";
    assertTrue(myStringClass.isPalindrome(palindrome));
  }

  @Test
  void isMotPalindromeTest() {
    String palindrome = "opera";
    assertFalse(myStringClass.isPalindrome(palindrome));
  }

  @Test
  public void deleteWorldTest() {
    assertEquals("Hello", myStringClass.deleteWorld());
  }

  @Test
  public void deleteLTest() {
    assertEquals("Heo Word", myStringClass.deleteL());
  }

  @Test
  public void replaceOtoQTest() {
    assertEquals("Hellq Wqrld", myStringClass.replaceOtoQ());
  }

  @Test
  public void wordAndAmountLetter() {
    HashMap<String,Integer> map = myStringClass.wordAndAmountLetter();
    assertTrue(map.containsKey("Hello"));
    assertTrue(map.containsKey("World"));
    assertEquals(5,map.get("Hello"));
    assertEquals(5,map.get("World"));
  }

  @Test
  public void returnSongTest() {
    int bugs = 10;
    int couplet = 5;
    String expected = "10 little bugs in the code,\n"
            + "10 little bugs in the code,\n"
            + "Take one down, patch it around 17 little bugs in the code.\n"
            + "17 little bugs in the code,\n"
            + "17 little bugs in the code,\n"
            + "Take one down, patch it around 15 little bugs in the code.\n"
            + "15 little bugs in the code,\n"
            + "15 little bugs in the code,\n"
            + "Take one down, patch it around 18 little bugs in the code.\n"
            + "18 little bugs in the code,\n"
            + "18 little bugs in the code,\n"
            + "Take one down, patch it around 20 little bugs in the code.\n";
    assertEquals(expected, myStringClass.returnSong(bugs,couplet));
  }
}