package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo foo = new Foo();

  @Test
  void foo() {
    List<String> list = new ArrayList<>(0);
    int i = 0;
    foo.foo(i, list);
    assertEquals(list.get(0), "d");
    /**
     * Как мы видим перед передачей в метод коллекцию из стрингов его размер 0.
     * Но после вызова метода foo туда добавляется еще один элемент.
     * Что мы видим при вызове метода size.
     */

    assertFalse(i == 15);
    /**
     * Но при этом когда мы передаем переменную int он не изменяется. В методе создается
     * новая переменная с которой и выполняется манипуляции. А исходная не изменяется.
     */
  }
}