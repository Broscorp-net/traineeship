package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  protected Foo foo = new Foo();
  protected List<String> lstr1 = null;
  protected List<String> lstr2 = new ArrayList<>(Arrays.asList("one", "two", "three"));
  protected int a = 1;

  /*относится ли обьект к класу Foo*/
  @Test
  void FooClassTest() {
    Assertions.assertSame(foo.getClass(), Foo.class);
  }

  /*передаём null*/
  @Test
  void FooNullTest() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(a, lstr1);
    });
  }

  /*не выбрасывается ли исключение с заданными переменными*/
  @Test
  void FooNotExcep() {
    Assertions.assertDoesNotThrow(() -> {
      foo.foo(a, lstr2);
    });
  }

  /*не передаём null*/
  @Test
  void FooNotNull() {
    Assertions.assertNotNull(lstr2);
    Assertions.assertNotNull(a);
  }
}
