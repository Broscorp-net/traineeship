package net.broscorp.valueref;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FooTest {

  /** This is because parameters in Java are always passed by value.
   In both the first and second cases, a copy of the variable is created.
   In the case of an object, another link will be created,
   but both links will refer to the same object in the heap.
   The difference between 'i' and 's' is that 'i' is a primitive whereas 's' is an object,
   and they are stored in different parts of memory.
   Primitives are stored in Stack, and objects are stored in Heap.
   */

  private static Foo foo;
  private static ArrayList<String> s;
  private static int i;

  @BeforeAll
  public static void setup() {
    foo = new Foo();
    i = 0;
    s = new ArrayList<>();
  }

  @Test
  void fooCheckListIsEmpty() {
    foo.foo(i, s);
    Assertions.assertFalse(s.isEmpty());
  }

  @Test
  void fooCheckInt() {
    foo.foo(i, s);
    Assertions.assertFalse(i > 0);
  }
}
