package net.broscorp.classpath;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleReader {
  /** Main method for class that reads value from console.
   *
   * @param args - there is no args.
   */
  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 6666);
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      Scanner scanner = new Scanner(System.in);
      String str = scanner.nextLine();
      while (!str.equals("quit") && !str.equals("exit")) {
        dout.writeUTF(str);
        dout.flush();
        str = scanner.nextLine();
      }
      dout.close();
      s.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

