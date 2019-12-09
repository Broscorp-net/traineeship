package net.broscorp.k_classpath;

import java.util.Scanner;

public class InPut {

  public static void main(String[] args){

    Scanner in = new Scanner(System.in);
    System.out.print("Input some line: ");
    String line = in.nextLine();
    new OutPut().write(line);
    in.close();
  }

}
