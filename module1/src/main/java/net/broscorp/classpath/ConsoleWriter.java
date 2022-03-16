package net.broscorp.classpath;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleWriter {
  public static void main(String[] args) throws IOException {
    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept(); // establishes connection
      DataInputStream dis = new DataInputStream(s.getInputStream());
      String str = dis.readUTF();
      while (!str.equals("quit") && !str.equals("exit")) {
        System.out.println("message= " + str);
        str = dis.readUTF();
      }

      ss.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
