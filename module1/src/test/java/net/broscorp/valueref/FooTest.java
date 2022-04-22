package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FooTest {
  static int i;
  static List<String> s;

  /** Initialization before running the method. */
  @BeforeAll
  public static void initialization() {
    i = 10;
    s = new ArrayList<>();
    s.add("apple");
    s.add("grape");
    s.add("orange");
  }

  @Test
  public void testReference() {
    Assertions.assertEquals(10,i);
    Assertions.assertEquals(Arrays.asList("apple", "grape", "orange"),s);
    Foo.foo(i,s);
    Assertions.assertEquals(10,i);
    Assertions.assertEquals(Arrays.asList("apple", "grape", "orange","d"),s);
  }
}
