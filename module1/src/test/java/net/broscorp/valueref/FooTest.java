package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FooTest {

  private int testInt = 9;
  private Integer testInteger = 7;
  private Integer nullTestInteger;
  private List<String> resizableList;
  private final List<String> emptyList = new ArrayList<>();
  private List<String> nullList;
  private final List<String> fixedSizedList = Arrays.asList("a", "b", "c");
  private final Foo fooTestInstance = new Foo();

  @BeforeEach
  public void update() {
    resizableList = new ArrayList<>(Arrays.asList("a", "b", "c"));
  }

  //  A copy of the value is passed to the method as parameters in Java.
  //  For a primitive this copy is a value of the same type with the same value.
  //  Inside the method, the value of such copy can change, but this will not affect
  //  the value of the original variable outside the method.
  //  But for a reference type, such copy is a copy of reference itself.
  //  That is, it points to the same object that the original reference points to.
  //  Therefore, when an object change occurs within a method,
  //  this change will not be on the method stack, but on the heap.
  //  And after the execution of the modifying method,
  //  the original variable outside the method will point to the object
  //  in which the changes made by the completed method will remain.
  @Test
  public void intWillNotBeChangedButListWillBeAppendedSuccessfulTest() {
    fooTestInstance.foo(testInt, resizableList);
    Assertions.assertEquals(9, testInt);
    Assertions.assertEquals(4, resizableList.size());
    Assertions.assertEquals("d", resizableList.get(3));
  }

  //  Integer can be successfully passed to a method that takes int as a parameter.
  //  This will auto-unboxing the wrapper.
  @Test
  public void insteadIntPassedIntegerInMethodAsParameterSuccessfulTest() {
    fooTestInstance.foo(testInteger, resizableList);
    Assertions.assertEquals(7, testInteger);
    Assertions.assertEquals(4, resizableList.size());
    Assertions.assertEquals("d", resizableList.get(3));
  }

  //  An empty List<String> can be successfully passed to a method as a parameter.
  @Test
  public void emptyListPassedInMethodAsParameterSuccessfulTest() {
    fooTestInstance.foo(testInteger, emptyList);
    Assertions.assertEquals(7, testInteger);
    Assertions.assertEquals(1, emptyList.size());
    Assertions.assertEquals("d", emptyList.get(0));
  }

  //  Passing null as an Integer parameter to the method throws NullPointerException.
  @Test
  public void throwsNullPointerExceptionWhenNullPassedInMethodAsIntegerParameter() {
    Assertions.assertThrows(
        NullPointerException.class, () -> fooTestInstance.foo(nullTestInteger, resizableList));
  }

  //  Passing null as a List<String> parameter to the method throws NullPointerException.
  @Test
  public void throwsNullPointerExceptionWhenNullPassedInMethodAsListParameter() {
    Assertions.assertThrows(
        NullPointerException.class, () -> fooTestInstance.foo(testInteger, nullList));
  }

  //  Arrays.asList() returns a fixed-length list that does not allow adding or removing elements.
  //  The add() and remove() methods will throw an UnsupportedOperationException if an attempt is
  //  made to add or remove an element from such list.
  @Test
  public void throwsUnsupportedOperationExceptionWhenFixedSizedListPassedInMethodAsParameter() {
    Assertions.assertThrows(
        UnsupportedOperationException.class, () -> fooTestInstance.foo(testInt, fixedSizedList));
  }
}
