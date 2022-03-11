package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  @Test
  void testForFooFunctionality() {
    Foo foo = new Foo();

    List<String> inputList = new ArrayList<>();
    List<String> expectedStringList = new ArrayList<>();
    expectedStringList.add("d");

    int inputValue = 0;

    // here we have an example of passing variable
    foo.foo(inputValue, inputList);
    // List have been changed because we passed it by link
    assertEquals(expectedStringList, inputList);
    assertEquals("d", inputList.get(0));
    // int value have not been changed because it is primitive variable
    // (new instance of this variable have been created in the current method )
    assertEquals(0, inputValue);

  }


}