package net.broscorp.strings;

import java.util.Locale;
import java.util.Random;

public class OperationString {

  /**
   * Find palindrome.
   * */
  public boolean findPalindrome(String word) {
    word = word.toLowerCase(Locale.ROOT);
    int length = word.length();
    int forward = 0;
    int backward = length - 1;
    while (backward > forward) {
      char forwardChar = word.charAt(forward++);
      char backwardChar = word.charAt(backward--);
      if (forwardChar != backwardChar) {
        return false;
      }
    }
    return true;
  }

  /**
   * Cuts the first word.
   * Example "Hello World" -> "World".
   * " Hello" -> "Hello".
   * */
  public String cutWord(String text) {
    int index = text.indexOf(" ");
    if (index != -1) {
      return text.substring(++index);
    } else {
      return text;
    }
  }

  public String deleteLetter(String text, String letter) {
    return text.replaceAll(letter, "");
  }

  public String replaceLetterWithAnother(String text, String oldLetter, String newLetter) {
    return text.replaceAll(oldLetter, newLetter);
  }

  /**
   * Example "Hello World" -> "Hello = 5 World = 5".
   * */
  public String showListWordAndNumberLetters(String text) {
    char[] charText = text.toCharArray();
    StringBuilder wordList = new StringBuilder();
    int count = 0;
    for (char c : charText) {
      if (c != ' ') {
        wordList.append(c);
        count++;
      } else {
        wordList.append(" = ").append(count).append(" ");
        count = 0;
      }
    }
    wordList.append(" = ").append(count).append(" ");
    return wordList.toString();
  }

  /**
   * return a cool song.
   * */
  public String song(int bugNumber, int coupletNumber) {
    Random random = new Random((long) bugNumber * coupletNumber);
    StringBuilder song = new StringBuilder();
    int m;
    for (int i = 0; i < coupletNumber; i++) {
      m = bugNumber - 10 + random.nextInt(20);
      song.append(String.format("%d little bugs in the code, \n"
          + "%d little bugs in the code. \n"
          + "Take one down, patch it around %d little bugs in the code.", bugNumber, bugNumber, m));
      song.append("\n");
      bugNumber = m;
    }
    return song.toString();
  }

}
