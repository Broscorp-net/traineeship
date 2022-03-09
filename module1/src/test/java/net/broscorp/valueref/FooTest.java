package test.java.net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Test;

public class FooTest {

  private Foo object = new Foo();

  @Test
  public void showcaseValueRefTest() {
    int i = 10;
    List<String> s = new ArrayList<String>();
    object.foo(i, s);
    //Not equals, i = 10 because primitives are sent as a value.
    assertNotEquals(i, 25);
    // First element of list is actually "d", because objects are sent by reference
    assertTrue(s.get(0).equals("d"));
    /*Exactly for this reason Wrapper classes exist. If we would need to pass i as an object,
     we would need to wrap our primitive into an Integer.*/
  }
}
