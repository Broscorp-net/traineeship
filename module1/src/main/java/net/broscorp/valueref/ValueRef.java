package net.broscorp.valueref;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;


public class ValueRef {

  private Foo someFoo = new Foo();
  private int someValue = 10;
  private List<String> list = new LinkedList<>();

  @Test
  public void testOfFoo() {
    int expectedValue = someValue;
    someFoo.foo(someValue, list);
    assertEquals(expectedValue, someValue);
    assertEquals("d", list.get(0));
  }
}