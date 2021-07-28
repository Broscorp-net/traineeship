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

    Bytecode bytecode = new Bytecode();

    List<Integer> list = bytecode.returnList(25);

    int i = 15;
    for (int j = 0; j < i; j++) {
      i++;
    }

    System.out.println("Hello Bytecode!");

    executeShellScript("mvn clean install");
    executeShellScript("javac src/main/java/net/broscorp/bytecode/ByteCode.java");
    String execute = executeShellScript(
        "java net.broscorp.bytecode.ByteCode");//won't work from code but works fine from shell
    String decompile = executeShellScript("javap -c src/main/java/net/broscorp/bytecode/ByteCode");

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


  /**
   * Added one non-static method and ints invocation through class instance variable.
   */
  private List<Integer> returnList(int limit) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < limit; i++) {
      list.add((int) (Math.random() * 100));
    }
    return list;
  }
}
