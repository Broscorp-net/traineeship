package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  private Foo foo;

  @BeforeEach
  void setUp() {
    foo = new Foo();
  }

  /*
   * Parameters of primitive types (int, double, etc.) are passed on value - in other words,
   * at a method call the implicit local (existing only within this method) variable where the value
   * transferred in parameter is copied.
   */

  @Test
  void givenDataList_whenFoo_thenChangedListDataReturned() {
    int i = 0;
    List<String> data = new ArrayList<>(
        Arrays.asList(new String[]{"First", "Second", "Third", "Fourth", "Fifth"}));
    List<String> expected = new ArrayList<>(
        Arrays.asList(new String[]{"First", "Second", "Third", "Fourth", "Fifth", "d"}));

    foo.foo(i, data);

    assertEquals(expected, data);
  }

  /*
   * When parameters of object types are passed, in this case, a reference to the object
   * is actually passed to the method, and when the method performs any manipulations with such an
   * object, the original object itself changes.
   */

  @Test
  void givenLocalInteger_whenFoo_thenLocalvalueNotChanged() {
    int actual = 0;
    int expected = 0;
    List<String> data = new ArrayList<>(
        Arrays.asList(new String[]{"First", "Second", "Third", "Fourth", "Fifth"}));

    foo.foo(actual, data);

    assertEquals(expected, actual);
  }

}