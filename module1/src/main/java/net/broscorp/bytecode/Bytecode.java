package net.broscorp.bytecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bytecode {

  /**
   * Checkstyle required a javadoc comment here. Got no idea why.
   */
  public static void main(String[] args) {

    int i = 15;
    for (int j = 0; j < i; j++) {
      i++;
    }

    System.out.println("Hello Bytecode!");

    executeShellScript("javac src/main/java/net/broscorp/bytecode/Bytecode.java");
    String execute = executeShellScript(
        "java src.main.java.net.broscorp.bytecode.Bytecode");//won't work from code but works fine from shell
    String decompile = executeShellScript("javap -c src/main/java/net/broscorp/bytecode/Bytecode");

    System.out.println(decompile);
    System.out.println(execute);
  }

  private static int increment(int i) {
    int increment = i;
    for (int j = 0; j < i; j++) {
      increment++;
    }
    return increment;
  }

  private static String executeShellScript(String command) {
    StringBuilder output = new StringBuilder();
    try {
      String executable = command;
      Process process = Runtime.getRuntime().exec(executable);
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(process.getInputStream()));
      String result;
      while ((result = reader.readLine()) != null) {
        output.append(result).append("\n");
      }
    } catch (IOException e) {
      e.getMessage();
    }
    return output.toString();
  }
}
