package net.broscorp.bytecode;

public class ByteCode {
  /**
   * method for run app.
   *
   * @param args - argument
   */
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      System.out.println(method(i));
    }
  }

  private static Integer method(Integer x) {
    System.out.println("Ky");
    return x++;
  }
}
