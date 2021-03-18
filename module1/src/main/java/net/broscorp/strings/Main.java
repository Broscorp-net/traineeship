package net.broscorp.strings;

public class Main {
  public static void main(String[] args){
    String yourString = ReadFromConsole.readConsole();
    String cutStr = "World";
    char delCh = 'l';
    char replCh = 'o';
    char goalCh = 'q';
    //String yourString = null;

    Philologist philologist = new Philologist();

    System.out.printf("Сторка %s после удаления слова %s будет: %s \n",yourString, cutStr, philologist.cutWord(yourString, cutStr));
    System.out.printf("Строка %s %s \n",yourString,philologist.isPalindrome(yourString)?"является палиндромом.":"не является палиндромом.");
    System.out.printf("Строка %s после удаления символа %c будет: %s \n", yourString, delCh, philologist.deleteChar(yourString, delCh));
    System.out.printf("Строка %s после замены символа %c на символ %c будет: %s \n", yourString, replCh, goalCh, philologist.replaceChar(yourString, 'o', 'q'));


  }

}
