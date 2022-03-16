package net.broscorp.strings;

import java.util.Random;

public class StringUtil {

  /**
   * Check is string palindrome.
   */
  public boolean isPalindrome(String string) {
    char[] chars = string.toCharArray();
    int i = 0;
    int k = chars.length - 1;
    while (i < chars.length) {
      if (chars[i] == ' ') {
        i++;
      }
      if (chars[k] == ' ') {
        k--;
      }
      if (chars[i] != chars[k]) {
        return false;
      }
      i++;
      k--;
    }
    return true;
  }

  /**
   * Return only Hello.
   */
  public String stringHello(String string) {
    return string.substring(0, 5);
  }

  /**
   * Delete l from string.
   */
  public String stringWithOutL(String string) {
    return string.replaceAll("l", "");
  }

  /**
   * Change o in string on q.
   */
  public String changeOToQ(String string) {
    return string.replaceAll("o", "q");
  }

  /**
   * Method read how many letters in every word in string.
   */
  public String wordsAndLetter(String string) {
    String[] strings = string.split(" ");
    StringBuilder stringBuilder = new StringBuilder();

    for (String s : strings) {
      stringBuilder.append(s + "=" + s.length() + "\\n");
    }
    return stringBuilder.toString();
  }

  /**
   * Methods has 2 values. First is count of bugs. Second is count of couplets. And return text of
   * song.
   */
  public String bugSong(int countOfBugs, int countOfCouplets) {
    StringBuilder stringBuilder = new StringBuilder();
    Random random = new Random((long) countOfBugs * countOfCouplets);
    for (int i = 0; i < countOfCouplets; i++) {
      int future = countOfBugs - 10
          + random.nextInt(20);
      if (future < 0) {
        future = 0;
      }
      stringBuilder.append(countOfBugs + " little bugs in the code,\n"
          + countOfBugs + " little bugs in the code.\nTake one down, patch it around "
          + future + " little bugs in the code.\n");
      if (future == 0) {
        break;
      }
      countOfBugs = future;
    }
    return stringBuilder.toString();
  }
}