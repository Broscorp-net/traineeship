import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import net.broscorp.n_strings.StrigEx;
import org.junit.jupiter.api.Test;

class StrigExTest {

  @Test
  void isPalindromeY() {
    assert (new StrigEx().isPalindrome("Sos"));
  }

  @Test
  void isPalindromeNo() {
    assert (!new StrigEx().isPalindrome("Soss"));
  }

  @Test
  void dellL() {
    String del = new StrigEx().dellL("Hello World");
    char[] c = del.toCharArray();
    for (char ch : c) {
      assert !String.valueOf(ch).equals("l");
    }
  }

  @Test
  void replaceOnQ() {
    String del = new StrigEx().replaceOnQ("Hello World");
    char[] c = del.toCharArray();
    for (char ch : c) {
      assert !String.valueOf(ch).equals("o");
    }
  }

  @Test
  void justHello() {
    String del = new StrigEx().justHello("Hello World");
    char[] c = del.toCharArray();
    for (char ch : c) {
      assert !String.valueOf(ch).equals("d");
    }
  }

  @Test
  void counter() {
    HashMap<String, Integer> map = new StrigEx().counter("Hello Worlds");
    assert (map.containsKey("Hello") && map.containsKey("Worlds")
        && map.containsValue(5) && map.containsValue(6));
  }

  @Test
  void format() {
    String s = new StrigEx().format(5, 3);
    String song = "5 little bugs in the code, \n"
        + "5 little bugs in the code. \n"
        + " Take one down, patch it around 0 little bugs in the code.\n"
        + "0 little bugs in the code, \n"
        + "0 little bugs in the code. \n"
        + " Take one down, patch it around 2 little bugs in the code.\n"
        + "2 little bugs in the code, \n"
        + "2 little bugs in the code. \n"
        + " Take one down, patch it around 10 little bugs in the code.\n";
    assertEquals (s , song);
  }
}