package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FooTest {

  // Java is always pass-by-value

  Foo object = new Foo();
  int number = 1;
  List<String> listOfStrings = new ArrayList<>();

  /**
   * Method in Foo class has it's own variable called "i" it's a new, different variable
   * Variables "i" and "number" do not affect each other.
   * When we change "i", we don't change "number"
   * Only thing variable "number" did in this case - copied it's value and passed it to the method
   * We won't get expected result
   */
  @Test
  public void passingByValue() {
    object.foo(number, listOfStrings);
    assertNotEquals(16, number);
  }

  /**
   * With the references (as with primitives), we get a copy of the content.
   * When we pass an object reference to a method, we pass a copy of the reference.
   * So if we change reference "listOfStrings", we will not change the value in Foo class. And vice versa.
   * We will get expected result
   */
  @Test
  public void passingByReference() {
    object.foo(number, listOfStrings);
    assertEquals("d", listOfStrings.get(0));
  }

}
