package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  private final List<String> listString = Arrays.asList("First", "Second", "Third");
  private final List<String> listNewString = new ArrayList<>(
      Arrays.asList("One", "Two", "Three"));
  private final int anInt = 5;
  private List<String> listEmpty;
  private final Integer varNull = null;
  private final Foo foo = new Foo();

  /**
   * Sending empty List and getting throws NullPointerException.
   */
  @Test
  public void checkOnNullPointerExceptionList() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(anInt, listEmpty);
    }, "List strings was empty");
  }

  /**
   * Sending var with value 'null' and getting throws NullPointerException.
   */
  @Test
  public void checkOnNullPointerExceptionInt() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(varNull, listNewString);
    }, "Variable varNull was 'null'");
  }

  /**
   * Arrays.asList it is just a wrapper over an array with a List interface. And the arrays are of a
   * fixed size, so adding and deleting items is not supported. So getting throws
   * UnsupportedOperationException
   */
  @Test
  public void checkOnUnsupportedOperationException() {
    Assertions.assertThrows(UnsupportedOperationException.class, () -> {
      foo.foo(anInt, listString);
    }, "Resize");
  }

  @Test
  public void fooNotThrowException() {
    Assertions.assertDoesNotThrow(() -> foo.foo(anInt, listNewString));
  }

  /**
   * Int. When we pass primitives, a copy is passed to the Foo class of the foo method. 'anInt' and
   * 'i' are independent of each other.
   * <p>
   * ArrayList. The situation is similar with links, in the method we get a copy of the link that
   * points to the value of the variable that we passed.
   */
  @Test
  public void checkingMethodOnChangedParam() {
    foo.foo(anInt, listNewString);
    Assertions.assertNotEquals(20, anInt);
    Assertions.assertEquals("d", listNewString.get(listNewString.size() - 1));
  }
}
