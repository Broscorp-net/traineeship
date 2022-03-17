package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  private Foo foo = new Foo();

  @Test
  public void listEqualsNullTest() {
    //This test shows that method foo will throw an exception if parameter List<String> s is null
    Assertions.assertThrows(NullPointerException.class, () -> foo.foo(0, null));
  }

  @Test
  public void changeValueByRefTest() {
    /*This test shows that if you pass an instance of a reference type
     to a method foo, then all changes to that instance in the method will change the instance.*/
    List<String> list = new ArrayList<>();
    foo.foo(0, list);
    Assertions.assertTrue(list.size() > 0);
  }

  @Test
  public void doesNotChangeValueByRefTest() {
    /*This test shows that if you pass an instance of a non-reference type
    to a method, then all changes to that instance in the method will not change the instance.*/
    int value = 1;
    foo.foo(value, new ArrayList<>());
    Assertions.assertEquals(1, value);
  }
}
