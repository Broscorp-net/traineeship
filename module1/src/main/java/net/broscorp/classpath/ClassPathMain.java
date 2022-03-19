
import java.util.Scanner;

public class ClassPathMain {

  /**
   * Main method.
   * @param args String
   */
  public static void main(String[] args) {
    System.out.println("Enter string?");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    ClassPathOut.outWrite(input);
  }
}
