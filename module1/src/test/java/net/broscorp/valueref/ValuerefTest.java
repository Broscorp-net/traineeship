package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValuerefTest {
  @Test
  void fooTest() {
    Foo foo = new Foo();
    List<String> list = new ArrayList<>();
    foo.foo(1, list);
    Assertions.assertEquals("d", list.get(0));
  }
  /*
  Мы можем протестировать только то, что добавиться в коллекцию, принимаемую методом foo,
  так как в эту коллекцию в методе добавиться значение.
  А значение int i, которую принимает методом foo, может использоваться только внутри
  самого метода, и даже если туда передать переменную, это ее не изменит.
   */
}
