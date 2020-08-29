package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  /* Throws UnsupportedOperationException because AbstractList doesn't support
   * List.add method (but can be modified through List.set)
   */
  @Test
  void fooWithAbstractList() {
    Foo inst = new Foo();
    List<String> strings = Arrays.asList("s1", "s2");

    assertThrows(UnsupportedOperationException.class, () -> inst.foo(1, strings));
  }

  /* List of strings gets mutated after call to Foo.foo method because we pass
   * this list by reference
   */
  @Test
  void fooWithAnEmptyList() {
    Foo inst = new Foo();
    List<String> strings = new ArrayList<>();

    assertTrue(strings.size() == 0);

    inst.foo(0, strings);

    assertTrue(strings.size() == 1);
    assertTrue(strings.contains("d"));
  }

  /* Throws NullPointerException because Foo.foo tries to use List.add method
   * on null that we passed instead of object
   */
  @Test
  void fooWithNullList() {
    Foo inst = new Foo();

    assertThrows(NullPointerException.class, () -> inst.foo(0, null));
  }

  /* Throws NullPointerException because we passed null as an Integer wrapper
   * to a method that expects primitive type(compiler tries to unbox it and fails)
   */
  @Test
  void fooWithNullIntWrapper() {
    Foo inst = new Foo();
    List<String> strings = new ArrayList<>();
    Integer i = null;

    assertThrows(NullPointerException.class, () -> inst.foo(i, strings));
  }

  /* Value of wrapper instance doesn't change because compiler unboxed our value
   * when we passed it to a method with primitive type parameter
   */
  @Test
  void fooWithIntWrapper() {
    Foo inst = new Foo();
    List<String> strings = new ArrayList<>();
    Integer i = 0;

    inst.foo(i, strings);

    assertEquals(0, i);
  }

  /* Value of primitive(value) type doesn't change because value types are always
   * being passed by value and not reference
   */
  @Test
  void fooWithIntPrimitive() {
    Foo inst = new Foo();
    List<String> strings = new ArrayList<>();
    int i = 0;

    inst.foo(i, strings);

    assertEquals(0, i);
  }

}
