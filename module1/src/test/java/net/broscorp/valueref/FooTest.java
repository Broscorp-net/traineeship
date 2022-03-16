package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo foo = new Foo();

  @Test
  void foo() {
    List<String> list = new ArrayList<>(0);
    int i = 0;
    System.out.println(list.size());
    foo.foo(i, list);
    System.out.println(list.size());
    /**
     * Как мы видим перед передачей в метод коллекцию из стрингов его размер 0.
     * Но после вызова метода foo туда добавляется еще один элемент.
     * Что мы видим при вызове метода size.
     */
    System.out.println(i);
    /**
     * Но при этом когда мы передаем переменную int он не изменяется. В методе создается
     * новая переменная с которой и выполняется манипуляции. А исходная не изменяется.
     */
  }
}