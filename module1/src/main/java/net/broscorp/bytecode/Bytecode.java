public class Bytecode {

  /**
   * Main method.
   * Изменение цикла for на while, и имени переменной деассемблированный байткод не поменяло.
   * Изменения видны только при изменении имени метода с printHello() на hello()
   * @param args String[]
   */
  public static void main(String[] args) {
    int a = 1;
    while (a < 4) {
      hello();
      a++;
    }
  }

  static void hello() {
    System.out.println("Hello World!");
  }

}
