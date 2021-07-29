package net.broscorp.valueref;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FooTest {
  @Test
  void foo() {
    Foo foo = new Foo();
    int i = 1;

    List<String> list = new ArrayList<>();

    foo.foo(i, list);
    // assertSame compares references to objects
    assertEquals(1, i);
    // Variables on the stack exist as long as the method in which they were created is executed
    assertEquals(1, list.size());
    assertEquals(Arrays.asList("d"), list);
  }
}
