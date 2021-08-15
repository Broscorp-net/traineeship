package net.broscorp.strings;

import java.util.Random;

class WorkWithString {


  boolean isPalindrome(String str) {
    StringBuilder stringBuilder = new StringBuilder(str).reverse();
    return str.equalsIgnoreCase(stringBuilder.toString());
  }

  String cutWord(String str, String cutWord) {
    StringBuilder stringBuilder = new StringBuilder(str);
    int i = stringBuilder.indexOf(cutWord);
    stringBuilder.delete(i, i + cutWord.length());
    return stringBuilder.toString().trim();
  }

  String cutAllChars(String str, String deleteChar) {
    return str.replaceAll(deleteChar, "");
  }

  String replaceChars(String str, String target, String replacement) {
    return str.replaceAll(target, replacement);
  }

  String endlessSong(int bugs, int amountCouplet) {
    Random random = new Random(bugs * amountCouplet);
    StringBuilder songText = new StringBuilder();
    for (int i = amountCouplet; i > 0; i--) {
      int m = bugs - 10 + random.nextInt(20);
      String oneCouplet = String.format("%d little bugs in the code, \n"
          + "%d little bugs in the code. \n"
          + "Take one down, patch it around %d little bugs in the code.\n", bugs, bugs, m);
      songText.append(oneCouplet);
      bugs = m;
    }
    return songText.toString();
  }
}
