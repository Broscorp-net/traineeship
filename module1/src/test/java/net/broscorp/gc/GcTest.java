package net.broscorp.gc;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GcTest {

  @Test
  void gcTest() {
    List<Meat> meats = new ArrayList<>();
    int i = 0;
    while (i != Integer.MAX_VALUE) {
      meats.add(new Meat(new Fork(4)));
      // new Meat(new Fork(4)).prick();
      i++;

      if (i % 800000 == 0) {
        System.out.println("Try GC");
        System.gc();
      }
    }
    System.out.println("Цикл Остановлен!");
  }


  class Fork {

    int tooth;

    public Fork(int tooth) {
      this.tooth = tooth;
    }

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Вилка исчезает навсегда " + Fork.this.hashCode());
      super.finalize();
    }
  }

  class Meat {

    Fork fork;
    Meat meat;

    public Meat(Fork fork) {
      this.fork = fork;
    }

    void prick() {
      String msg = new String("Pierced " + fork.tooth + " holes ");
      System.out.println(msg + Meat.this.hashCode());
    }

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Мясо исчезает навсегда" + Meat.this.hashCode() + "В нем вилка "
          + fork.hashCode());
      Meat.this.prick();
      super.finalize();
    }
  }
}