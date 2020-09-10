import java.util.Scanner;

public class FirstClass {

  private static String line;
  
  /**
   * Read from console and print into console in main method.
   * @param args - args
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    line = scanner.nextLine();
    SecondClass.printLine();
  }

  public static String getLine() {
    return line;
  }
}
