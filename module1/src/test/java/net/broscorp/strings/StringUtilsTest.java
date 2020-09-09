package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  void isPalindromeWithPalindromicString() {
    String[] stringsForTesting = {
        " - ",
        "level",
        "rotor",
        "civic",
        "",
        "1",
        "?!123Hello olleH321!?",
    };

    for (String str : stringsForTesting) {
      assertTrue(StringUtils.isPalindrome(str));
    }
  }

  @Test
  void isPalindromeWithNonPalindromicString() {
    String[] stringsForTesting = {
        " -",
        "1232",
        "Hello",
        "--1--=",
    };

    for (String str : stringsForTesting) {
      assertFalse(StringUtils.isPalindrome(str));
    }
  }

  @Test
  void removeWorldFromStringReturnsModifiedString() {
    String[] expectedResults = {
        "Hello",
        "hello",
        "hello",
        "hello",
    };
    String[] stringsForTesting = {
        "Hello World",
        "helloWorld",
        "     hello    World      ",
        " Worldhello  ",
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(expectedResults[i], StringUtils.removeWorldFromString(stringsForTesting[i]));
    }
  }

  @Test
  void removeWorldFromStringReturnsUnchangedString() {
    String[] expectedResults = {
        "Hello world",
        "123",
        "Hello WOrld",
        "Hello W0rld",
    };
    String[] stringsForTesting = {
        "Hello world",
        "123",
        "Hello WOrld",
        "Hello W0rld",
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(expectedResults[i], StringUtils.removeWorldFromString(stringsForTesting[i]));
    }
  }

  @Test
  void removeAllOccurrencesOfLetterLReturnsModifiedString() {
    String[] expectedResults = {
        "",
        "Heo Word",
        "eve",
        "    ",
    };
    String[] stringsForTesting = {
        "lllllllllllllllll",
        "Hello World",
        "level",
        "l l l l l",
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(
          expectedResults[i],
          StringUtils.removeAllOccurrencesOfLetterL(stringsForTesting[i])
      );
    }
  }

  @Test
  void removeAllOccurrencesOfLetterLReturnsUnchangedString() {
    String[] expectedResults = {
        "  ",
        "",
        "Latin",
        "Language",
        "LLLLL",
    };
    String[] stringsForTesting = {
        "  ",
        "",
        "Latin",
        "Language",
        "LLLLL",
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(
          expectedResults[i],
          StringUtils.removeAllOccurrencesOfLetterL(stringsForTesting[i])
      );
    }
  }

  @Test
  void replaceAllOccurrencesOfOWithQReturnsModifiedString() {
    String[] expectedResults = {
        "qqqq qqqq",
        "Hellq",
        "query",
    };
    String[] stringsForTesting = {
        "oooo qqqq",
        "Hello",
        "ouery",
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(
          expectedResults[i],
          StringUtils.replaceAllOccurrencesOfOWithQ(stringsForTesting[i])
      );
    }
  }

  @Test
  void replaceAllOccurrencesOfOWithQReturnsUnchangedString() {
    String[] expectedResults = {
        "1230asdl",
        "",
        "OOO",
        "q",
    };
    String[] stringsForTesting = {
        "1230asdl",
        "",
        "OOO",
        "q",
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(
          expectedResults[i],
          StringUtils.replaceAllOccurrencesOfOWithQ(stringsForTesting[i])
      );
    }
  }

  @Test
  void getListOfWordsAndNumOfCharsReturnsCorrectString() {
    String[] expectedResults = {
        ": 0\n",
        "123: 3\n",
        "Hello: 5\nWorld!: 6\n",
        "One: 3\ntwo: 3\nthree: 5\nfour: 4\nfive: 4\nsix: 3\nseven: 5\neight: 5\nnine: 4\nten: 3\n"
    };
    String[] stringsForTesting = {
        "",
        "123",
        "Hello World!",
        "One two three four five six seven eight nine ten"
    };

    for (int i = 0; i < expectedResults.length; i++) {
      assertEquals(
          expectedResults[i],
          StringUtils.getListOfWordsAndNumOfChars(stringsForTesting[i])
      );
    }
  }

  @Test
  void createSongWithValidParameters() {
    String expectedResult = String.join(
        "",
        "5 little bugs in the code,\n5 little bugs in the code.\n",
        "Take one down, patch it around 11 little bugs in the code.\n11 little bugs in the code,\n",
        "11 little bugs in the code.\nTake one down, patch it around 5 little bugs in the code.\n"
    );

    String actualResult = StringUtils.createSong(5, 2);

    assertEquals(6, actualResult.split("\n").length);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void createSongWithZeroVerses() {
    String actualResult = StringUtils.createSong(5, 0);

    assertEquals("", actualResult);
  }

}
