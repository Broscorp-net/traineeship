package net.broscorp.strings;

/** imports. */
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringApp {
  /** HELLO. */
  private static final String HELLO = "Hello World";

  public boolean palindrome(String str) {
    List<String> list = Arrays.asList(str.split(""));
    for (int i = 0; i < list.size() / 2; i++) {
      String left = list.get(i);
      String right = list.get((list.size() - 1) - i);
      if (!left.equalsIgnoreCase(right)) {
        return false;
      }
    }
    return true;
  }

  /** say hello. */
  public String hello(String str) {
    List<String> list = Arrays.asList(str.split(" "));

    return list.get(0);
  }

  public String deleteL(String str) {
    return str.replace("l", "");
  }

  public String change_O(String str) {
    return str.replace("o", "q");
  }

  /** number of words and letters. */
  public void numberOfWordsAndLetters(String str) {

    List<String> list = Arrays.asList(str.split(" "));
    int wordCount = list.size();
    System.out.println("Word Count: " + wordCount);
    for (int i = 0; i < wordCount; i++) {
      List<String> subList = Arrays.asList(list.get(i).split(""));
      int numberOfLetters = subList.size();
      System.out.println("Number of letters in " + (i + 1) + "word: " + numberOfLetters);
    }
  }

  /** little bugs. */
  public void littleBugs(int n, int countOfPunchlines) {
    int rng = n * countOfPunchlines;

    for (int i = 0; i < countOfPunchlines; i++) {
      int m = n - 10 + new Random().nextInt(rng);
      System.out.println(
          n
              + " little bugs in the code, \n"
              + n
              + " little bugs in the code. \n"
              + "Take one down, patch it around "
              + m
              + " little bugs in the code.");
      n = m;
    }
  }
}
