
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import net.broscorp.n_strings.Strings;

class StringsTest   {

  private static Strings strings;

  @BeforeAll
  public static void initialization()   {
    strings = new Strings();
  }
  
  @Test
  void testIsPalindrom() {
    strings.isPalindrom("mam");
    assertTrue(strings.isPalindrom("mam"));
  }

  @Test
  void testWordDeletion() {
    assertEquals("Hellhlkoyuy", strings.wordDeletion("Hello world")     );
  }

  @Test
  void testLetterDeletion() {
    assertEquals("Heo word", strings.letterDeletion("Hello world"));
  }

  @Test
  void testLettersChaneging() {
    assertEquals("Hellq wqrld", strings.lettersChaneging("Hello world"));
  }

  @Test
  void testWordsLetters() {
    assertEquals(2, strings.wordsLetters("Hello world").size());
  }

  @Test
  void testMakeSong() {
    assertTrue(strings.makeSong(2, 3) instanceof String);
  }

}
