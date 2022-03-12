package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

  /**
   * Input class that contains main method.
   */
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String textData = new String();
    try {
      textData = br.readLine();
    } catch (Exception e) {
      System.out.println(e);
    }
    Output.print(textData);
  }
}
