package net.broscorp.strings;

import java.util.Random;

public class WorkWithStrings {
  private static String hello = "Hello world";

  /**
   * Метод который проверяет являеться ли строка полендромом,
   * то есть читаеться ли она в обе стороны одинаково.
   * @param arg строка которая проверяеться.
   * @return правда ли то что строка полендром.
   */
  public boolean isPalindrome(String arg) {
    int len = arg.length();
    for (int i = 0; i < (len / 2); i++) {
      if (arg.charAt(i) != arg.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Вырезает из строки слово Hello.
   * @return вырезанное слово.
   */
  public String leftHello() {
    return hello.split(" ")[0];
  }

  /**
   * Удаляет в строке буквы l.
   * @return новую строку без этой буквы.
   */
  public String deleteLetter() {
    String res = "";
    for (char c : hello.toCharArray()) {
      if (c != 'l') {
        res += c;
      }
    }
    return res;
  }

  /**
   * Заменяет все буквы о на буквы q.
   * @return измененную строку.
   */
  public String replaceLetters() {
    return hello.replace('o', 'q');
  }

  /**
   * Выводит слова и количество букв в них в слове Hello World.
   */
  public void listOfWordsAndCountLetters() {
    String[] split = hello.split(" ");

    System.out.println("Length of word " + split[0] + " is " + split[0].length());
    System.out.println("Length of word " + split[1] + " is "  + split[1].length());
  }

  /**
   * Выводит песню по заданию при заданных параметрах.
   * @param n количество багов которое выводиться в песне.
   * @param repeat КОличество повторов строк в песне.
   */
  public void printSong(int n, int repeat) {
    Random random = new Random(n * repeat);
    for (int i = 0; i < repeat; i++) {
      System.out.println(n + " little bugs in the code");
      System.out.println(n + " little bugs in the code");
      int m = n - 10 + random.nextInt(20);
      System.out.println("Take one down, patch it around " + m + " little bugs in the code");
      n = m;
    }

  }
}
