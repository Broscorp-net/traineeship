package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  public void testPassPrimitiveValue(){
    int x = 5;

    Foo foo = new Foo();
    foo.foo(x, new ArrayList<>());

    // when we pass primitive value to method, the copy of value is created.
    // and method works with own copy of my variable x
    // so my variable x is not changed after method foo() was invoked

    Assertions.assertEquals(5, x);
  }

  @Test
  public void testPassReferenceValue(){
    List<String> bar = new ArrayList<>();
    bar.add("a");

    Foo foo = new Foo();
    foo.foo(0, bar);

    // In this case, the copy of reference is created and passed to method.
    // and method works with the copy of reference that is pointing to bar list
    // that's why after foo() method was invoked the list size equals 2

    Assertions.assertEquals(2, bar.size());
    Assertions.assertTrue(bar.contains("d"));
    Assertions.assertTrue(bar.contains("a"));
  }
}
