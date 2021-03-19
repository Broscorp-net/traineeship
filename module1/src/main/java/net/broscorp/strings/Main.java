package net.broscorp.strings;

import java.util.Scanner;

/**
 * This is the main class for starting programs and checking the job.
 * @author Hryhorii Perets
 * @version 1.0
 */
public class Main {

  /**
   *        This is main method.
   * @param args this method without param.
   */
  public static void main(String[] args) {
    String yourString = "Hello World";
    String cutString =  "World";
    char delCh = 'l';
    char replCh = 'o';
    char goalCh = 'q';

    try (Scanner scaner = new Scanner(System.in)) {
      System.out.print("Пожалуйста напишите вашу строку: ");
      if (!scaner.nextLine().equals("")) {
        yourString = scaner.nextLine();
      }

      System.out.print("Какое слово удалить?: ");
      if (!scaner.nextLine().equals("")) {
        cutString = scaner.nextLine();
      }

      System.out.print("Какую букву удалить?: ");
      String delChar = scaner.nextLine();
      if (!delChar.equals("")) {
        delCh = delChar.charAt(0);
      }

      System.out.print("Какую букву заменить?: ");
      String replChar = scaner.nextLine();
      if (!replChar.equals("")) {
        replCh = replChar.charAt(0);
      }

      System.out.print("На какую букву заменить?: ");
      String goalChar = scaner.nextLine();
      if (!goalChar.equals("")) {
        goalCh = goalChar.charAt(0);
      }

    }

    Philologist philologist = new Philologist();

    System.out.printf("Строка %s после удаления слова %s будет: %s \n",
        yourString, cutString, philologist.cutWord(yourString, cutString));
    System.out.printf("Строка %s %s \n",yourString,
        philologist.isPalindrome(yourString)
            ? "является палиндромом." : "не является палиндромом.");
    System.out.printf("Строка %s после удаления символа %c будет: %s \n",
        yourString, delCh, philologist.deleteChar(yourString, delCh));
    System.out.printf("Строка %s после замены символа %c на символ %c будет: %s \n",
        yourString, replCh, goalCh, philologist.replaceChar(yourString, 'o', 'q'));

    System.out.printf("Строка %s состоит из: \n", yourString);
    for (String str: philologist.splitString(yourString)) {
      System.out.printf("%7s слова %s, в котором %d букв. \n","", str, str.length());
    }

    System.out.println(philologist.randomSong(30, 2));

  }

}
