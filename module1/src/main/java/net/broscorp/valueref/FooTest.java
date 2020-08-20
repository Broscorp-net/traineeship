package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FooTest {
  
  private int number = 10;
  private int expectedNumber = 10;
  private List<String> list = new ArrayList<String>();
  private String expectedString = "d";
  private Foo foo = new Foo();
  
  @Test
  public void foo() {
    foo.foo(number, list);
    assertEquals(expectedNumber, number); 
    // int is primitive type, and inside method, java worked with copy
    assertEquals(expectedString, list.get(0)); 
    // ArrayList is class, and inside method, java worked with object by link
  }
  
}
