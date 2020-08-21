package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FooTest {

  Foo foo = new Foo();
  int number = 1;
  List<String> list = new ArrayList<>();

  /**
   * Вызывая метод foo из класса Foo, в данном случае, мы проверяем измениться ли Первый параметр,
   * котороый мы туда передаём, а именно значение number. По итогу метода, значение что мы туда
   * передали НЕ должно измениться. Так как мы передали его НЕ по ссылке, а по копии значения.
   */
  @Test
  public void changeIntNumber() {
    foo.foo(number, list);
    assertEquals(number, number);
  }

  /**
   * Вызывая метод foo из класса Foo, в данном случае, мы проверяем измениться ли Второй параметр,
   * котороый мы туда передаём, а именно ссылочное значение list. По итогу метода в котором мы добавили новое строковое значение в list,
   * передали должно измениться. Так как мы передали его по ссылке на оригинал.
   */
  @Test
  public void changeListAddNewElement() {
    foo.foo(number, list);
    assertEquals("d", list.get(0));
  }
}
