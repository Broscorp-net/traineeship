package net.broscorp.classpath;

import java.io.IOException;
import java.util.Scanner;

public class ReadConsole {

  public static void main(String [] args){

    WriteConsole.writeConsole(readConsole());

  }

  public static String readConsole(){
    System.out.println("Please will write your message:");
    String str = null;
    try (Scanner in = new Scanner(System.in)){
      str = in.nextLine();
    }
    return str;
  }

}
