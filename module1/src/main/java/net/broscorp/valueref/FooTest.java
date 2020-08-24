package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo foo;
  List<String> list;
  int num;


  @BeforeEach
  void setUp() {
    foo = new Foo();
    list = new ArrayList<>();
    list.add("Hello");
    list.add("World");
    list.add("!");
    num = 10;
  }

  /*
  All parameters in Java passed by value
  But there are some differences
   */

  @Test
  void changeNumberTest() {
    int expected = num + 15;
    foo.foo(num, new ArrayList<>());

    /*
    The parameter i in method foo is a copy of the value variable num.
    It means that any change with this parameter in method doesn't change value which passed.
    Therefore, the num has not changed
     */

    assertNotEquals(expected, num);
    assertEquals(10, num);
  }

  @Test
  void changeListTest() {
    int expectedSize = list.size() + 1;
    foo.foo(0, list);

    /*
    The parameter s in method foo is a copy of a reference on the object list
    It means that any change with this parameter in method change value which passed.
    Therefore, the list changed their size and added element "d"
     */

    assertEquals(expectedSize, list.size());
    assertTrue(list.contains("d"));
  }

}