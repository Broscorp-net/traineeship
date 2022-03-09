package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValueRefTest {

  /**
   * В методе foo в коллекцию добавляем элемент String со значением "d", а переменную i увеличиваем
   * на 15
   * <p>
   * В результате: i не увеличивается на 15, но в коллекцию элемент "d" попадает.
   * <p>
   * Так происходит потому что java передает параметры в методы по значению, поэтому методы работают
   * с копией данных. В данном случае мы работаем с копией значения переменной i, поэтому
   * оригинальная i не изменяется. Но в случае с коллекцией, которая представляет из себя обьект -
   * метод не создает копию коллекции, а работает с копией ссылки на оригинальную коллекцию, изменяя
   * ее.
   */
  @Test
  public void valueRefTest() {
    Foo test = new Foo();
    List<String> testList = new ArrayList<>();
    int i = 0;

    assertEquals(0, testList.size());
    assertEquals(0, i);

    test.foo(i, testList);

    assertEquals(1, testList.size());
    assertEquals("d", testList.get(0));
    assertEquals(0, i);
  }
}
