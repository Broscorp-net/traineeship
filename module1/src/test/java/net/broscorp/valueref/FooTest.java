package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  /**
    * Примитивы передают только своё значение в методы. В stack памяти создается копия примитива 
    * для исполняемого метода,поэтому методы могут менять их значение только в рамках себя.
    * Объекты же создаются в heap памяти, и при передаче объекта в метод,
    * передаётся только ссылка на объект в памяти.
    * Так любые изменения состояния объекта влияют на все места, где используется этот объект.
   */
  @Test
  void test() {
    Foo foo = new Foo();
    int i = 0;
    List<String> list = new ArrayList<>();
    
    for (int z = 0; z < 10; z++) {
      foo.foo(i, list);
      System.out.println("i: " + i + " | list size: " + list.size());
    }
    
    assertEquals(0, i);
    assertNotEquals(0, list.size());
    
  }

}
