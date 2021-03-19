package net.broscorp.strings;

public class Philologist {

  public boolean isPalindrome(String str) {
    if (str != null) {
      String newStr = str.toLowerCase().replaceAll("\\s", "");
      int n = newStr.length();

      for (int i = 0; i < (n / 2); ++i) {
        if (newStr.charAt(i) != newStr.charAt(n - i - 1)) {
          return false;
        }
      }
      return true;
    }
    return false;

  }

  public String cutWord(String originStr, String cutStr) {
    if (originStr != null) {
      return originStr.replaceAll(cutStr, "");
    }
    return null;
  }

  public String deleteChar(String originStr, char ch) {
    if (originStr != null) {
      return originStr.replaceAll(""+ch, "");
    }
    return null;
  }

  public String replaceChar(String originStr, char oldChar, char newChar) {
    if (originStr!=null) {
      return originStr.replace(oldChar, newChar);
    }
    return null;
  }

  public String[] analysisString(String str) {
    String[] strings;
    if (str != null) {
      strings = str.split(" ");
      return strings;
    }
    return null;
  }

  public String randomSong(int bug, int verse) {
    return null;
  }


}
