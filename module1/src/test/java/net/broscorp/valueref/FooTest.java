package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FooTest {

  private Foo foo;
  private List<String> list;
  private int num = 12354652;

  @BeforeEach
  void setup() {
    list = new ArrayList<>();
    foo = new Foo();
    list.add("a");
    list.add("b");
    list.add("c");
  }

  /**
   * Place in the memory where methods are executed is called stack. This is also the place where
   * primitives are placed. Stack stores references to the object instances allocated in the Heap
   * space. Important to know, when method ends all its variables data in the stack is lost.
   * Primitives are passed by value. In method foo(arg 1, arg 2) we try to assign the value to
   * method variable. The result of addition is placed in the stack and is gone along with method
   * execution end. Another situation with the list. ArrayList instance is an object with its
   * address in the Heap. We pass not the instance of the object but its reference. Method does not
   * assign new value to the ArrayList instance variable passed as the argument but performs
   * operation that causes its mutation. Therefore, after the method ends up its operation only
   * reference to the ArrayList instance will be destroyed, object data modified.
   */

  @Test
  void testFooShouldAddElement() {
    assertEquals(3, list.size());

    foo.foo(num, list);

    assertEquals(12354652, num);
    assertTrue(list.contains("d"));
    assertEquals(4, list.size());
  }
}
