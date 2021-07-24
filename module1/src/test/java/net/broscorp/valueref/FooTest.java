package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FooTest {

  /*
    Stack Memory

    The stack is memory with LIFO (last in - first out) organization.
    Java allocated a new memory bock (frame) on top of the stack for each method when its called.
    This block contains data (primitive variable and references to objects) for future using
    in the called method.

    But, values are simply copied to a new stack block (pass by value).
    As a result, changing the value inside the method does not change the original value stored
    below on the stack.
    This is why the 'i' variable (origin) does not increase by 15 after the method is executed.

    When a method finishes execution, its own stack is flushed.
   */

  @Test
  public void shouldNotModifyPrimitiveVariable() {
    //given
    Foo foo = new Foo();
    int i = 0;
    //when
    foo.foo(i, new ArrayList<String>());
    //then
    assertNotEquals(15, i);
    assertEquals(0, i);
  }

  /*
    Heap Memory

    The heap is another one memory spaces that is used for dynamic memory allocation for objects.
    New objects are always created in heap space and the references to these objects are stored
    in stack memory

    So, the list is changed because objects have global access and can be accessed from anywhere
    in the program, not limited to the stack frame as primitives.
    A list reference is used to modify the list (pass by reference).
    The reference is saved in the stack, but the object is global.
   */

  @Test
  public void shouldModifyObjectByReference() {
    //given
    Foo foo = new Foo();
    List<String> list = new ArrayList<>();
    //when
    foo.foo(0, list);
    //then
    assertTrue(list.contains("d"));
    assertEquals("d", list.get(0));
  }

  @Test
  public void nullPointerExceptionShouldBeThrown() {
    //given
    Foo foo = new Foo();
    List<String> list = null;
    //when
    //then
    assertThrows(NullPointerException.class, () -> {
      foo.foo(0, list);
    });
  }
}
