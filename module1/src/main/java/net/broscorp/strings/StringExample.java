package net.broscorp.strings;

import java.util.ArrayList;
import java.util.Random;

public class StringExample {

  public static boolean getPalindrome(String testWord) {
    int charCounter = 0;
    char[] chars = testWord.toCharArray();
    int middleCharIndex = (chars.length - 1) / 2;
    for (int i = 0; i <= middleCharIndex; i++) {
      if (chars[i] == chars[chars.length - 1 - i]) {
        charCounter++;
        if (charCounter > middleCharIndex) {
          return true;
        }
      }
    }
    return false;
  }

  public static String getFirstWordFromString(String string) {
    if (string == null || string.isEmpty()) {
      return null;
    }
    String[] words = string.split(" ");
    return words[0];
  }

  public static String deleteSomeCharFromString(String string, char deletedChar) {
    char[] charList = string.toCharArray();
    String newString = "";
    for (int i = 0; i < charList.length; i++) {
      if (charList[i] != deletedChar) {
        newString = newString + charList[i];
      }
    }
    return newString;
  }

  public static String replaceSomeCharacter(String string, char oldChar, char newChar) {
    return string.replace(oldChar, newChar);
  }

  public static ArrayList<String> getWordAndItsAmountChar(String string) {
    ArrayList<String> stringAndItsAmountChar = new ArrayList<>();
    String[] stringArray = string.split(" ");
    for (int i = 0; i < stringArray.length; i++) {
      stringAndItsAmountChar.add(
          "\"" + stringArray[i] + "\"" + " its length = " + stringArray[i].length());
    }
    return stringAndItsAmountChar;
  }

  public static String songAboutBugs(Integer bugsAmount, Integer coupletsAmount) {
    String song = "";
    Random random = new Random(bugsAmount * coupletsAmount);
    for (int i = 0; i < coupletsAmount; i++) {
      int changeBugsAmount = bugsAmount - 10 + random.nextInt(20);
      song = song + String.format("%d little bugs in the code, \n" +
              "%d little bugs in the code. \n" +
              "Take one down, patch it around %d little bugs in the code.\n\n",
          bugsAmount, bugsAmount, changeBugsAmount);
      System.out.println(song);
      bugsAmount = changeBugsAmount;
    }
    return song;
  }

}
