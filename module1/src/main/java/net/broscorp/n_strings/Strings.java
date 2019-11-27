package net.broscorp.n_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strings {

  public boolean isPalindrome(String words) {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder = sBuilder.append(words).reverse();
    if (!words.equals(sBuilder.toString()))
      return false;
    return true;
  }

  public String wordDeletion(String words) {
    StringBuilder sBuilder = new StringBuilder(words);
    return sBuilder.delete(5, words.length()).toString();
  }

  public String letterDeletion(String words) {
    return words.replace("l", "");
  }

  public String lettersChaneging(String words) {
    return words.replace("o", "q");
  }

  public List<String> wordsLetters(String words) {
    List<String> stringList = new ArrayList<>();
    String[] sArray = words.split(" ");
    for (String word : sArray) {
      stringList.add((word + " = " + word.length() + " letters \n"));
    }
    return stringList;
  }

  public String makeSong(int coupletNumber, int bugsNumber) {
    Random random = new Random(coupletNumber * bugsNumber);
    StringBuilder sBuilder = new StringBuilder();
    for (int i = 1; i <= coupletNumber; i++) {
      int updateBugsNumber = bugsNumber - 10 + random.nextInt(20);
      sBuilder.append(String.format(
          "%d little bugs in the code, \n" + "%d little bugs in the code. \n"
              + "Take one down, patch it around %d little bugs in the code \n",
          bugsNumber, bugsNumber, updateBugsNumber));
      bugsNumber = updateBugsNumber;
    }
    return sBuilder.toString();
  }
}
