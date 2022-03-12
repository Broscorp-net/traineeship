package net.broscorp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  public void testNull() {
    Assertions.assertThrows(NullPointerException.class, () -> new Foo().foo(0, null));
  }

  @Test
  public void testIntegerNull() {
    Assertions.assertThrows(NumberFormatException.class,
        () -> new Foo().foo(Integer.parseInt(null), new ArrayList<>()));
  }

  @Test
  public void testFixedSizeList() {
    List<String> list = Arrays.asList("a", "b", "c");

    Assertions.assertThrows(UnsupportedOperationException.class, () -> new Foo().foo(0, list));
  }
}