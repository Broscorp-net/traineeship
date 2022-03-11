package net.broscorp.classpath;

import java.io.Console;

public class First {

  /**
   * My Main class.
   */
  public static void main(String[] args) {
    Second object = new Second();
    Console console = System.console();
    String progLanguage = console.readLine("Enter your favourite programming language: ");
    object.show(progLanguage);
  }

}
