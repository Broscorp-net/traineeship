import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;


class FooTest {

  Foo testedFoo = new Foo();
  int i = 1;
  List<String> list = new ArrayList<String>();

  /*Примитивы передаются по значению, объекты по ссылке => значение примитива копируется для использования внутри метода
  и при любых манипуляциях внутри этого метода не может менять значение глобальной переменной.
   Передавая list в метод мы делимся ссылкой доступа к объекту
   и с этим пультом управления мы можем менять объект даже изнутри метода.*/

  @Test
  void testFoo() {
    testedFoo.foo(i, list);
    assertEquals(16, i);
    assertTrue(list.contains("d"));
  }

}