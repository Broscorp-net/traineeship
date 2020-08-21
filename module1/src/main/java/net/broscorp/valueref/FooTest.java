package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo foo = new Foo();
  int intNumber = 0;
  List<String> list = new ArrayList<>();


  /*in this case we put primitive type int into a method foo()
    primitive types pass by value, so compiler gets a copy of int value and
    variable "i" don't changes
   */

  @Test
  public void primitiveValueShouldNotChange() {
    foo.foo(intNumber, list);
    assertEquals(intNumber, intNumber);
  }

  /*
  in this case we put reference data type ArrayList in method foo(), so we give direct access
  to variable "list" by reference and method foo() directly adds new element into "list"
   */
  @Test
  public void inListRealizationShouldAddNewElement() {
    foo.foo(intNumber, list);
    assertEquals("d", list.get(0));
  }
}