package net.broscorp.valueref;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValueRefTest {

  Foo foo = new Foo();

  @Test
    public void fooTest() {
    int local = 0;
    List<String> list = new ArrayList<>();
    foo.foo(local,list);
    assertEquals(0,local);
  }

  @Test
  public void fooTest2() {
    List<String> list = new ArrayList<>();
    foo.foo(0,list);
    assertEquals("d",list.get(0));
  }
}
