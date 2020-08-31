package net.broscorp.valueref;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;


public class ValueRef {

  private Foo valueFoo = new Foo();
  // created an instance type Foo of "Foo" method, link for this instance
  private int value = 10;
  // instance integer "Value"
  private List<String> list = new LinkedList<>();
  // Created an instance type "list<string>" of method
  // "LinkedList", link for this instance

  @Test
  public void testOfFoo() {
    int expectedValue = value;
    //assigne a "Value" for "expextedValue"
    valueFoo.foo(value, list);
    //send parameters(value and list) of instance valueFoo to method "foo"
    //In method makes operation i+=15 (i=i+15) and add "d" for list
    assertEquals(expectedValue, value);
    //There will be "true", because when we send parameters to method, we send copy of variable
    // and after operation this copy cleans
    assertEquals("d", list.get(0));
    //There will be "true", because in this situation we send copy of link for instance and
    // after operation, "list" had changed and copy of link cleans
  }
}