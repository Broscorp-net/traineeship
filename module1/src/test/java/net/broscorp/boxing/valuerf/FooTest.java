package net.broscorp.boxing.valuerf;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import net.broscorp.valueref.Foo;

public class FooTest {

  @Test
  public void testFooWithListExceptedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(1, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
  }
}
