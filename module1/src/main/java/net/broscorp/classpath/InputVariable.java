//package net.broscorp.classpath;

import java.util.Scanner;

public class InputVariable {
  public static String name;

  public static void main(String[] args) {
    inputVariableByUser();
    OutputVariableWhichWasInput.outputVariable(name);
  }

  /**Method in which I ask user to input his/her name.*/
  public static void inputVariableByUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please, enter your name:");
    name = scanner.nextLine();
  }

}
