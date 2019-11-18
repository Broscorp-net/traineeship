package net.broscorp.g_value_ref;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * In Java all incoming Methods arguments are sending by value (not by reference). What is simply
 * means, that primitives transfered to method as an argument, does not change they global state
 * outside the method bounds. The value of reference variables, which transferring into particular
 * method, pointed to particular object, which can be changed inside the method where it was sanded.
 */

class FooTest {

  /**
   * Test case purely proves mutation of ArrayList, and "untouchable" state of primitive.
   */
  @Test
  void testFoo() {
    Foo foo = new Foo();
    int i = 0;
    List<String> list = new ArrayList<String>();
    foo.foo(i, list);
    assertEquals(0, i);
    assertTrue(list.contains("d"));
  }

}
