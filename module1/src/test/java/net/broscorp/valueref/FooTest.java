package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * General comments on testing Foo.foo implmentation:
 * 1) the first int parameter will not be altered since it is passed as a primitive
 * 2) the second argument will be altered if the object is a valid List which is mutable
 */
public class FooTest {
  Foo foo = new Foo();

  /**
   * Testing that passed integer value remain unchanged.
   */
  @Test
  void intArgUnchanged() {
    List<String> strList = new ArrayList<String>();
    int i = 10;
    foo.foo(i,strList);
    Assertions.assertTrue(i == 10);
  }

  /**
   * Passing null as second argument will result in NullPointerException.
   */
  @Test
  void nullList() {
    List<String> strNull = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(5, strNull);
    });
  }

  /**
   * Passing a valid list of string results in the list being appended with a new element.
   */
  @Test
  void emptyMutablelList() {
    List<String> strEmptyMutableArr = new ArrayList<String>();
    foo.foo(5, strEmptyMutableArr);
    Assertions.assertEquals(strEmptyMutableArr.get(0),"d");
  }


  /**
   * Passing an imutable array will result in UnsupportedOperationException.
   */
  @Test
  void imutablelList() {
    List<String> strImutableList = Arrays.asList("only value");
    Assertions.assertThrows(UnsupportedOperationException.class, () -> {
      foo.foo(5, strImutableList);
    });
  }
}
