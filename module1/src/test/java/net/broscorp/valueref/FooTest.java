package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  public void numbersDoesNotChange() {
    List<String> list = new ArrayList<>();
    list.add("string1");
    list.add("string2");
    list.add("string3");
    int someInt = 5;
    int expectedNewInt = someInt + 15;
    Foo foo = new Foo();
    foo.foo(someInt, list);

    Assertions.assertNotEquals(expectedNewInt, someInt,
        "Метод foo добавляет 15 к передаваемому числу, но он не возвращает ничего, а значит - изменения локальные");
  }

  @Test
  public void addedStringDInList() {
    List<String> list = new ArrayList<>();
    list.add("string1");
    list.add("string2");
    list.add("string3");
    int someNumber = 15;
    Foo foo = new Foo();
    foo.foo(someNumber, list);
    Assertions.assertTrue(list.contains("d"),
        "Список - объект, изменения в методе касаются списка везде, так как объекты передаются по ссылке, а значит список пополнился строчкой \"d\"");
    Assertions.assertEquals(4, list.size());
  }
}
