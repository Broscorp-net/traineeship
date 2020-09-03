package net.broscorp.strings;

import java.util.HashMap;
import java.util.Random;

public class MyStringClass {
  String hw = "Hello World";
  HashMap<String,Integer> map;

  /**
   * IsPallindrome.
   * @param word word
   * @return
   */
  public boolean isPalindrome(String word) {
    word = word.toLowerCase();
    int middle = word.length() / 2;
    int equal = 0;
    for (int i = 0; i < middle; i++) {
      if (word.charAt(i) == word.charAt(word.length() - 1 - i)) {
        equal++;
      }
    }
    if (equal == middle) {
      return true;
    }
    return false;
  }

  public String deleteWorld() {
    return hw.split(" ")[0];
  }

  public String deleteL() {
    return hw.replaceAll("l","");
  }

  public String replaceOtoQ() {
    return hw.replace('o','q');
  }

  /**
   * Count the number of words and letters in words.
   * @return
   */
  public HashMap<String,Integer> wordAndAmountLetter() {
    HashMap<String,Integer> map = new HashMap<>();
    String[] array = hw.split(" ");
    map.put(array[0], array[0].length());
    map.put(array[1], array[1].length());
    System.out.println(map);
    return map;
  }

  /**
   * Return Song.
   * @param bugs bugs
   * @param couplet couplet
   * @return
   */
  public String returnSong(int bugs, int couplet) {
    StringBuilder sb = new StringBuilder();
    Random random = new Random(bugs * couplet);
    int m = 0;
    for (int i = 1; i < couplet; i++) {
      sb.append(String.format("%s little bugs in the code,\n", bugs));
      sb.append(String.format("%s little bugs in the code,\n", bugs));
      m = bugs - 10 + random.nextInt(20);
      sb.append(String.format("Take one down, patch it around %d little bugs in the code.\n", m));
      bugs = m;
    }
    System.out.println(sb);
    return sb.toString();
  }

}
