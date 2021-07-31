import java.util.Scanner;

public class MainClass {

  /**
   * Summary text.
   *
   * @param args - program args.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a word:");
    String input = scanner.next();

    new Printer().print(input);
  }
}
