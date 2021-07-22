package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FooTest {
  private Foo obj;
  private int i;
  private List<String> list;

  @BeforeEach
  public void setUp() {
    i = 10;
    obj = new Foo();
    list = new ArrayList<>();
  }

  /**
   * As far as first argument of the method is
   * int(primitive type [stored in memory part: named stack]
   * it will not be changed by method, because when method
   * is executed values stored in method exist only during the
   * time of it`s execution [part of stack]. But on the other
   * hand variables of reference type will be changed
   * because they are stored in [heap], stack keeps only links
   * to the objects.
   */
  @Test
  public void fooAdditionTest() {
    obj.foo(i, list);
    assertEquals(10, i);
    assertTrue(list.contains("d"));
  }
}
