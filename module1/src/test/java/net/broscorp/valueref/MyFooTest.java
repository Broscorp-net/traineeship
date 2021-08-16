package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MyFooTest {

  private List<String> list = new ArrayList<>();//created list as data structure in any place of memory
  private int testIntArg = 20;

  @Test
  void fooTest() {

    // testIntArg = 35 in the scopes of method 'foo' after 20+15, but this result was destroyed after
    // executing code in method 'foo' and returning (changes was local), and value testIntArg = 20 in the test
    // list.add("d") writes value "d" in data structure, which situated not in the scopes of the method 'foo',
    // because 'list' was declared not in the scopes of method 'foo'
    new Foo().foo(testIntArg,
        list);//after executing method and return testIntArg = 20, list has 1 element - "d" with index '0'

    assertEquals(1, list.size());//list contains 1 element - "d"

    assertEquals("d",
        list.get(0));//list.get(0).equals("d"), contains 1 element - "d", with index '0'

    assertNotEquals(35, testIntArg);//testIntArg not changed in the body of test, changes
                                              //20+15=35 was local, only in the scopes of method 'foo'

    assertEquals(20, testIntArg);     //in test testIntArg = 20, method 'foo' not changed it;
  }

}
