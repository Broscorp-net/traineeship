package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  @Test
  void shouldReturnNullPointerException() {
    Foo foo = new Foo();
    int i = 5;
    List<String> list = null;
    assertThrows(NullPointerException.class, () -> {
      foo.foo(i, list);
    });
  }

  @Test
  void intTypeOverflow() {
    Long varLong = new Long(2147483647);
    int intPr = 2147483647;
    Foo foo = new Foo();
    varLong = varLong + 15;
    intPr = intPr + 15;
    foo.foo(2147483647, new ArrayList<>());
    assertNotEquals(varLong, intPr);
  }

  @Test
  void shouldReturnListNullPointerException() {
    List<String> stringList = null;
    assertThrows(NullPointerException.class, () -> {
      stringList.add("d");
    });
  }
}