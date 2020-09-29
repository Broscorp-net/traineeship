package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FooTest {

  // Метод foo добавляет 15 к передаваемому числу, но он не возвращает ничего, а значит - изменения
  // локальные
  @Test
  public void numberDoesNotChange() {
    List<String> list = new ArrayList<>();
    list.add("str1");
    list.add("str2");
    list.add("str3");
    list.add("str4");
    int someNumber = 15;
    int expected = someNumber + 15;
    Foo foo = new Foo();
    foo.foo(someNumber, list);
    assertNotEquals(expected, someNumber);
  }

  // Список - объект, изменения в методе касаются списка везде, так как объекты передаются по
  // ссылке, а значит список пополнился строчкой "d"
  @Test
  public void addedStringDInList() {
    List<String> list = new ArrayList<>();
    list.add("str1");
    list.add("str2");
    list.add("str3");
    list.add("str4");
    int someNumber = 15;
    Foo foo = new Foo();
    foo.foo(someNumber, list);
    assertTrue(list.contains("d"));
    assertEquals(5, list.size());
  }
}
