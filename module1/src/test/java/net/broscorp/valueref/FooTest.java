package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  // Если мы отправляем null список в аргумент метода foo, возникает NullPointerException
  @Test
  void shouldReturnNullPointerException() {
    Foo foo = new Foo();
    int i = 5;
    List<String> list = null;
    assertThrows(NullPointerException.class, () -> {
      foo.foo(i, list);
    });
  }

  // Если мы добавим 1 к MAX_VALUE, то получим MIN_VALUE.
  // Если мы вычтем 1 из MIN_VALUE, то получим MAX_VALUE.
  // Возникает круг типа int.
  // Такое поведение называется целочисленным переносом.
  @Test
  void intTypeOverflow() {
    long varLong = 2147483647;
    int intPr = 2147483647;
    Foo foo = new Foo();
    varLong = varLong + 15;
    intPr = intPr + 15;
    foo.foo(2147483647, new ArrayList<>());
    assertNotEquals(varLong, intPr);
  }
}
