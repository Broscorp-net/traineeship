package net.broscorp.boxing.valuerf;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  public void testFooWithListExcectedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(1, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
  }
  /*
  * Testing a void methode in junit is 
  * quite problematic and often not needed.
  * Method don't return value, so we can only check its effect on variables.
  * but one of variables has primitives type that's it mean that we can't check how it changes,
  * because when we passed this type of variable to our method, 
  * it will create copy of this variable.
  * There is only one option left - check the reference type of the variable
  */
  
  @Test
  public void testFooWithDigitAndListExcectedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();
    int number = 14;

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(number, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
    
    Assertions.assertTrue(number == 14);
  }
  
  /*
   * This test show us, that variable "number" didn't change, 
   * but method foo added to it 15, which confirms the above.
   */
}
