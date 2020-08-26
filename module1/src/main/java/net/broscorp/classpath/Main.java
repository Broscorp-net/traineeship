package net.broscorp.classpath;

import java.util.Scanner;

/**
 * Main class.
 * @author Nikta
 *
 * @version 1.0
 */
public class Main {
  /**
   * Main method.
   * creating the Print class instance
   * reading a number from the console
   * outputting this number via method print
   * @param args - args
   */
  public static void main(String[] args) {
    Print print = new Print();
    System.out.print("Input number:\t");
    try {
      Double doubleNum = readFromConsole();
      print.print(doubleNum);
    } catch (NumberFormatException e){
      System.out.println(e.getMessage());
    }
  }

  /**
   * Method for reading from the console.
   * @return Double if you haven't problem with input
   * @throws NumberFormatException - invalid input number
   */
  public static Double readFromConsole() {
    Scanner scanner = new Scanner(System.in);
    String doubleString = scanner.nextLine();
    scanner.close();
    if (doubleString.matches("\\d+(\\.?\\d+)?")) {
      return Double.parseDouble(doubleString);
    }
    throw new NumberFormatException("Invalid number entered! You made a mistake!");
  }
}
