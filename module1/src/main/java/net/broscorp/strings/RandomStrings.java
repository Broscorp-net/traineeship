package net.broscorp.strings;

import java.util.Random;

public class RandomStrings {
  /**.
   */
  public static boolean palindromeString(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    String rev = sb.toString();
    if (str.equals(rev)) {
      return true;
    } else {
      return false;
    }
  }

  public static String helloWorldFirst(String str) {
    return str.substring(0, 5);
  }

  public static String helloWorldSecond(String str) {
    return str.replace("l", "");
  }

  public static String helloWorldThird(String str) {
    return str.replace("o", "q");
  }

  /**.
   */
  public static String helloWorldFours(String str) {
    StringBuilder sb = new StringBuilder();
    String[] arr = str.split(" ");

    for (String ss : arr) {
      sb.append(ss + " " + ss.length() + "\n");
    }
    return sb.toString();
  }

  /**.
   */
  public static String textOfSong(int bugsNum, int coupletNum) {

    StringBuilder sb = new StringBuilder();
    Random random = new Random(bugsNum * coupletNum);
    int bugs = bugsNum;

    int couplet = 1;
    while (couplet++ <= coupletNum) {
      sb.append(String.format("%d little bugs in the code,\n", bugs));
      sb.append(String.format("%d little bugs in the code.\n", bugs));
      bugs = bugs - 10 + random.nextInt(20);
      sb.append(String.format(
          "Take one down, patch it around %d little bugs in the code.\n\n",
          bugs));
    }
    return sb.toString();
  }
}
