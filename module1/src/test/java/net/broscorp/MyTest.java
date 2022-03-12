package net.broscorp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  Foo foo = new Foo();

  @Test
  public void testNull_null_NPE() {
    Assertions.assertThrows(NullPointerException.class, () -> foo.foo(0, null));
  }

  @Test
  public void testIntegerNull_null_NPE() {
    Assertions.assertThrows(NumberFormatException.class,
        () -> foo.foo(Integer.parseInt(null), new ArrayList<>()));
  }

  @Test
  public void testFixedSizeList() {
    List<String> list = Arrays.asList("a", "b", "c");

    Assertions.assertThrows(UnsupportedOperationException.class, () -> foo.foo(0, list));
  }
}