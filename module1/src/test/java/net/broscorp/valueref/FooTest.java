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
  private final int anInt = 1;
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

}
