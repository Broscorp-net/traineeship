package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  /*
  Primitive variables are not changing after they have mutated inside methods
  because primitive variables passing themselves to methods by value.
  Basically in methods we are dealing with copies of primitive variables.
   */
  @Test
  public void shouldNotChangeAfterPassingVariableByValue() {
    Foo bar = new Foo();
    int expected = 10;
    int actual = 10;

    assertEquals(expected, actual);

    bar.foo(actual, new LinkedList<>());

    assertEquals(expected, actual);
  }

  /*
  Objects are changing after they have mutated inside methods
  because objects passing themselves to methods by reference.
  Basically in methods we are dealing with the same object that we passed as an argument.
   */
  @Test
  public void shouldChangeAfterPassingVariableByReference() {
    Foo bar = new Foo();
    List<String> s = new LinkedList<>();
    int expectedSize = 0;
    int actualSize = s.size();

    assertEquals(expectedSize, actualSize);

    bar.foo(10, s);
    actualSize = s.size();

    assertNotEquals(expectedSize, actualSize);
  }

}