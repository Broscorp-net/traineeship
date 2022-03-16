package net.broscorp.classpath;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleReader {
  public static void main(String[] args) throws IOException {
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
      System.out.println(e);
    }
  }
}

/*
 */
