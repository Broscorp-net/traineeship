package net.broscorp.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public class StringsTask {

  public boolean palindrome(String str) {
    StringBuilder string = new StringBuilder(str);
    return str.equalsIgnoreCase(string.reverse().toString());
  }

  public String getHello(String str) {
    String[] s = str.split(" ");
    return str.substring(0, s[0].length());
  }

  public String removeLL(String str) {
    return str.replace("l", "");
  }

  public String replaceOQ(String str) {
    return str.replace("o", "q");
  }


  /**
   * The method displays a list of words and the number of letters in the corresponding word.
   */
  public Map<String, Integer> wordListAndCharsCountShow(String str) {
    StringTokenizer st = new StringTokenizer(str, " \t\n\r,.");
    Map<String, Integer> map = new HashMap<>();
    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      map.put(s, s.length());
      System.out.print(s + " ");
      System.out.println(s.length());
    }
    return map;
  }

  /**
   * The method receives two numbers - the number of {@code int}bugs and the number of {@code
   * int}verses and returns the lyrics.
   *
   * @param bugs  number of bugs
   * @param verse number of verses
   */
  public Set<String> song(int bugs, int verse) {
    Set<String> strings = new HashSet<>();
    int n = bugs;
    Random random = new Random(bugs * verse);
    for (int i = 0; i < verse; i++) {
      int m = n - 10 + random.nextInt(20);
      strings.add(String.format("%d little bugs in the code, \n"
          + "%d little bugs in the code. \n"
          + "Take one down, patch it around %d little bugs in the code.\n\n", n, n, m));
      n = m;
    }
    return strings;
  }
}

