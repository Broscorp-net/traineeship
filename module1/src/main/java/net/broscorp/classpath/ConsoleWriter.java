package net.broscorp.classpath;

public class ConsoleWriter {
  public static void main(String[] args) {
    write(ConsoleReader.read());
  }

  public static void write(String input) {
    System.out.print(input);
  }
}