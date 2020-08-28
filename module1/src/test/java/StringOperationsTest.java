import static org.junit.jupiter.api.Assertions.*;

import net.broscorp.strings.StringOperations;
import org.junit.jupiter.api.Test;

public class StringOperationsTest {


  StringOperations operations = new StringOperations();

  @Test
  public void palindromeTest() {

    assertTrue(operations.isItPalindrome("Step on no pets"));
  }

  @Test
  public void deleteWorldTest() {

    assertEquals("Hello", operations.deleteWorld("Hello World"));
  }

  @Test
  public void deleteAlliTest() {

    assertEquals("", operations.deleteAllL("llll"));
  }

  @Test
  public void replaceAlloTest() {

    assertEquals("qqq", operations.replaceAllO("ooo"));
  }

  @Test
  public void wordsListTest() {

    operations.wordsList("Step on no pets");
  }

  @Test
  public void songTest() {

    operations.singBagsSong(4, 5);
  }
}
