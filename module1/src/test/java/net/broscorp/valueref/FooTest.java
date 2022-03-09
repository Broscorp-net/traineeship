package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo newObject = new Foo();

  @Test
  public void checkFoo() {
    int i = 10;
    List<String> array = new ArrayList<>();
    newObject.foo(i, array);
    assertEquals(10, i);
    assertEquals(1, array.size());
    assertEquals(array.get(0), "d");
    /* In java all is passed by value. When we pass primitive type, we pass only copy INT I;
    ArrayList it's class. In the variable - array we store a reference(link) to an object of this class;
    Because we can change object; */
  }

}