package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FooTest {
  private Foo obj;
  private int num;
  private List<String> list;

  /**
   * Method setup variables.
   */

  @BeforeEach
  public void setUp() {
    num = 10;
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
    obj.foo(num, list);
    assertEquals(10, num);
    assertTrue(list.contains("d"));
  }
}
