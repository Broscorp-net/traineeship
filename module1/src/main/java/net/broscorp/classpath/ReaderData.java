package net.broscorp.classpath;

import java.util.Scanner;

/**
 * Class read data from the console and send it to the output
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
public class ReaderData {

  /**
  * Program entry point.
  *
  * @param args - set of command line arguments.
  */

  public static void main(String[] args) {
    ShowData showData = new ShowData();
    System.out.println("INPUT DATA ");
    Scanner c = new Scanner(System.in);
    String input = c.nextLine();

    showData.show(input);
  }
}
