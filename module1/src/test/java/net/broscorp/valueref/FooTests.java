package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTests {

  @Test
  public void testNull() {
    Assertions.assertThrows(NullPointerException.class,
        () -> new Foo().foo(0, null)); //If List link is null
  }

  @Test
  public void testFixedSizeList() {
    List<String> list = Arrays.asList("a", "b", "c");

    Assertions.assertThrows(UnsupportedOperationException.class,
        () -> new Foo().foo(0, list)); //If List has fixed size
  }

  @Test
  void testListAdding() {
    List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    new Foo().foo(1, list);
    Assertions.assertEquals(list.size(), 4); //Testing that element was added to list
    Assertions.assertEquals(list.get(list.size() - 1), "d"); //Testing that added element equals "d"
  }

  @Test
  void testIntIncrement() {
    List<String> list = new ArrayList<>();
    int i = 0;
    new Foo().foo(0, list);
    Assertions.assertEquals(i, 0); //Testing that int increment in method not change incoming value
  }
}
