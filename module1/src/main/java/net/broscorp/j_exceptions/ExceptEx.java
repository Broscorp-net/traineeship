package net.broscorp.j_exceptions;

import java.io.FileReader;

public class ExceptEx {

  public void exept() {
    try (FileReader f = new FileReader("dead.txt")) {
      //ловим все возможные Exceptions
    } catch (Exception e) {
      e.printStackTrace();
      //код в закомнированом блоке catch небудет исполнен так как IOEx является дочкой Ex, а его
      // мы словили раньше
      //код даже не скомпилируется, ругаться будет
    } /*catch (IOException e) {
      e.printStackTrace();
    } */ finally {
      System.out.println("It was fun, but I gtg, sya");
    }
  }

  public static void main(String[] args) {
    ExceptEx ex = new ExceptEx();

    ex.exept();
    //запустив main программа завершится с штатном режиме
    System.out.println("После словленой ошибки, все еще живой");
  }
}
