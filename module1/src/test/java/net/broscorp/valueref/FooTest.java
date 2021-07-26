package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FooTest {

  //int Хранится в стеке. Передав коллекцию, мы передаем ссылку.
  // Можно использовать для этого рефлексию, но я не думаю, что это хорошая практика.
  @Test
  void foo() {
    int i = 10;
    List<String> s = new ArrayList<>();
    Foo fooObj = new Foo();
    fooObj.foo(i, s);
    String lastElement = s.get(s.size() - 1);
    assertEquals(10, i);
    assertEquals(lastElement, "d");
  }
}