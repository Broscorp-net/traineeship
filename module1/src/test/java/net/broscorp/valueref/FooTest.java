package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo foo;
  int testInt;
  List<String> testStringList;

  @BeforeEach
  void setUp() {
    this.foo = new Foo();
    this.testInt = 0;
    this.testStringList = new ArrayList<>();
  }


  /*это происходит потому что int примитивный тип данных и храниться в стеке
  * в то время как ArrayList ссылочной тип данных и храниться в куче,
  *  в стеке храниться только ссылка на него */
  @Test
  void foo() {
    int expectedTestInt = 0;
    int expectedTestStringListOne = 0;
    assertEquals(expectedTestInt,testInt);
    assertEquals(expectedTestStringListOne,testStringList.size());
    foo.foo(testInt,testStringList);
    int expectedTestStringListTwo = 1;
    assertEquals(expectedTestInt,testInt);
    assertEquals(expectedTestStringListTwo,testStringList.size());
  }
}