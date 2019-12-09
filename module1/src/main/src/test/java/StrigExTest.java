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
    for(char ch : c){
      assert !String.valueOf(ch).equals("l");
    }
  }

  @Test
  void replaceOnQ() {
    String del = new StrigEx().replaceOnQ("Hello World");
    char[] c = del.toCharArray();
    for(char ch : c){
      assert !String.valueOf(ch).equals("o");
    }
  }

  @Test
  void justHello() {
    String del = new StrigEx().justHello("Hello World");
    char[] c = del.toCharArray();
    for(char ch : c){
      assert !String.valueOf(ch).equals("d");
    }
  }

  @Test
  void counter() {
   new StrigEx().counter("Hello World");
   assert (true);
  }

  @Test
  void format() {
    new StrigEx().format(10, 5);
    assert (true);
  }
}