package net.broscorp.k_classpath;

import java.util.Scanner;

public class MyWriter {

  public Integer writingToConsole() {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    return in.nextInt();
  }
}
