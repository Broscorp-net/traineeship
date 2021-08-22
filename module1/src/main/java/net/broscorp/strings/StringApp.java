package net.broscorp.strings;

/** imports. */
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringApp {
  /** HELLO. */
  private static final String HELLO = "Hello World";

  /** javadoc. */
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
      System.out.println("Number of letters in " + (i + 1) + "word: " + list.get(i).length());
    }
  }

  /** little bugs. */
  public String littleBugs(int n, int countOfPunchlines) {
    int rng = n * countOfPunchlines;

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < countOfPunchlines; i++) {
      int m = n - 10 + new Random(rng).nextInt(20);
      builder
          .append(n)
          .append(" little bugs in the code, \n")
          .append(n)
          .append(" little bugs in the code. \n")
          .append("Take one down, patch it around ")
          .append(m)
          .append(" little bugs in the code.");
      n = m;
    }
    return builder.toString();
  }
}
