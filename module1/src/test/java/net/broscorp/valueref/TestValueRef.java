package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestValueRef {

  private Foo someFoo = new Foo();
  private int someValue = 10;
  private List<String> list = new LinkedList<>();

  @Test
  public void testOfValueReflationUsingFooMethod() {
    int expectedValue = someValue;
    someFoo.foo(someValue, list);
    assertEquals(expectedValue, someValue);
    assertEquals("d", list.get(0));
  }
}
