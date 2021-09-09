package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMain {

  public static String getText() {
    System.out.println("Enter text, please");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String text = "";
    try {
      text = bufferedReader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return text;
  }

  public static void main(String[] args) {
    PrintText.printToConsole(getText());
  }
}
