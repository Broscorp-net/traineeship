package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



class FooTest {

  Foo foo = new Foo();
  List<String> list = new ArrayList<>();
  int myValue = 10;

  @Test
  void foo() {
    foo.foo(myValue, list);
    //передаем методу foo  примитив i и ссылку на наш список list
    assertEquals(10, myValue);
    //т.к. i  примитив, то передаваемо значение не было изменено,
    // потому что фактически передалась копия i
    assertTrue(list.contains("d"));
    //Также мы передали ссылку на список list, данный объект был изменен,
    // была добавлена строка "d", т.к. мы передали ссылку в методе.
  }
}