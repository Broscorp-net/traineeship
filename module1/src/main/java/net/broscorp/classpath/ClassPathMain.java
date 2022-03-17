
import java.util.Scanner;

public class ClassPathMain {
  public static void main(String args[]) {
    System.out.println("Enter string?");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    ClassPathOut.outWrite(input);
  }
}
