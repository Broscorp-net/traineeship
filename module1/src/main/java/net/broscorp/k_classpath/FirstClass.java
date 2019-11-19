import java.util.Scanner;

public class FirstClass {

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = read();
        SecondClass.write(input);
    }
}



