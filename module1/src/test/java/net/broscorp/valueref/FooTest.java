package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FooTest {

  int number;
  int expected;
  List<String> list;

  /** The setup for test */
  @BeforeEach
  public void before() {
    number = 15;
    expected = number + 15;
    list = new ArrayList<>();
    list.add("str1");
    list.add("str2");
    list.add("str3");
    list.add("str4");
  }

  //  Метод foo добавляет 15 к передаваемому числу, но он не возвращает ничего, а значит - изменения
  // локальные
  @Test
  public void numberDoesNotChange() {
    Foo foo = new Foo();
    foo.foo(number, list);
    assertNotEquals(expected, number);
  }

  //  Список - объект, изменения в методе касаются списка везде, так как объекты передаются по
  // ссылке, а значит список пополнился строчкой "d"
  @Test
  public void listContainsStringD() {
    Foo foo = new Foo();
    foo.foo(number, list);
    assertTrue(list.contains("d"));
  }

  // Повторение причины выше, а значит и размер списка на 1 больше начального
  @Test
  public void listSizeShouldBe5() {
    Foo foo = new Foo();
    foo.foo(number, list);
    assertTrue(list.size() == 5);
  }
}
