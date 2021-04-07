package net.broscorp;

import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FooTest {

  private final List<String> newListString = new ArrayList<>(Arrays.asList("Yellow", "Blue", "Green"));
  private final int variableInt = 10;
  private final Foo foo = new Foo();

  @Test
  public void nullPointerExceptionList() {
    List<String> listEmpty = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(variableInt, listEmpty);
    }, "List strings was empty");
  }

  /**
   * Sending empty list and variable with value 0 and getting throws NullPointerException.
   */
  @Test
  public void nullPointerExceptionInt() {
    final Integer arg = 0;
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(arg, newListString);
    }, "Variable arg is 0");
  }

  /**
   * When we pass primitives, a copy is passed to the Foo class of the foo method. variableInt and
   * i are independent of each other.
   * The situation is similar with links(ArrayList), in the method we get a copy of the link that
   * points to the value of the variable that we passed.
   */
  @Test
  public void checkingMethodOnChangedParam() {
    foo.foo(variableInt, newListString);
    Assertions.assertNotEquals(20, variableInt);
    Assertions.assertEquals("d", newListString.get(newListString.size() - 1));
  }
}
