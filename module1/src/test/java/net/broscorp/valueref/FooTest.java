package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FooTest {
  private Foo foo = new Foo();
  private List<String> list;
  private Integer in;

  @Test
  public void checkList() {
    list = new ArrayList<>();
    in = 10;
    list.add("abc");
    foo.foo(in, list);
    Assertions.assertTrue(list.contains("d"));
  }

  @Test
  public void checkInt() {
    list = new ArrayList<>();
    in = 10;
    list.add("abc");
    foo.foo(in, list);
    Assertions.assertFalse(in == 25);
  }
}
