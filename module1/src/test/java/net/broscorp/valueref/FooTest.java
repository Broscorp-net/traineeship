package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FooTest {
  private static final List<String> ARRAY_LIST = new ArrayList<>(
      Arrays.asList("First", "Second", "THIRD"));
  private static final List<String> ARRAY_AS_LIST = Arrays.asList("First", "Second", "THIRD");
  private static final Integer INTEGER_NULL = null;
  private static final int INT_ONE = 1;
  private static final Foo FOO = new Foo();

  /*
  we send to the method a copy of the Integer reference that refers to null,
  when Integer tries to convert to int we will have NPE
  * */
  @Test
  void fooShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class,
        () -> FOO.foo(INTEGER_NULL, ARRAY_LIST), "unboxing for null");
  }

  /*
  Arrays.asList is a static method that takes an array and returns java.util.Arrays.ArrayList.
  This List implementations doesn`t support the add method.
  * */
  @Test
  void fooShouldThrowUnsupportedOperationException() {
    assertThrows(UnsupportedOperationException.class, () -> FOO.foo(INT_ONE, ARRAY_AS_LIST),
        "array as list doesn`t support method : add");
  }

  @Test
  void fooShouldDoesntThrowException() {
    assertDoesNotThrow(() -> FOO.foo(INT_ONE, ARRAY_LIST));
  }

  /*we send a copy of the object reference to the method,
  when we access the object by reference we can change it*/
  @Test
  void fooShouldAddStringToList() {
    int sizeBefore = ARRAY_LIST.size();
    FOO.foo(INT_ONE, ARRAY_LIST);
    int sizeAfter = ARRAY_LIST.size();
    assertTrue(sizeBefore < sizeAfter);
  }

  /*we send a copy of the value to the method,
  when we increment the value, we change the copy of the value*/
  @Test
  void fooShouldntIncrementIntVariable() {
    int someInt = 1;
    FOO.foo(INT_ONE, ARRAY_LIST);
    assertEquals(someInt, someInt);
  }
}
