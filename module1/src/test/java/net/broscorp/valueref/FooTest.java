package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

///primitive integer is stored in a stack memory because of his low size
//this way integers may be accessed and operated faster

//list, on the other hand, is stored in heap ram memory due to its variable length and stored items size

//by passing integer as a function arg, i am passing an actual value of integer, so function does not
//know about what the actual address of the variable is

//by passing a list as a function arg, i am actually passing the address in memory, which references
//the lists' start

//that is why modifying integer makes no effect on the integer outside function
//but modifying list actually modifies the list

public class FooTest {

  private final Foo garbageAdder = new Foo();

  @Test
  public void referenceTest() {
    int x = 0;

    garbageAdder.foo(x, new ArrayList<>());

    assertEquals(0, x);

  }

  @Test
  public void valueTest() {
    List<String> list = new ArrayList<>();

    garbageAdder.foo(0, list);

    assertEquals("d", list.get(0));
  }


}
