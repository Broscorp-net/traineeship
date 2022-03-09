package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo newObject = new Foo();

  @Test
  public void checkFoo() {
    int i = 10;
    List<String> array = new ArrayList<>();
    newObject.foo(i, array);
    assertEquals(10, i);
    assertEquals(1, array.size());
    assertEquals(array.get(0), "d");
    /* В java все передается по значению. Когда мы передаем примитивный тип мы передаем копию int i,
    который хранится в памяти как значение;
     ArrayList это класс, и в переменной array мы храним ссылку на объект этого класса,
      по этому по этой ссылке мы можем изменять объект */
  }

}