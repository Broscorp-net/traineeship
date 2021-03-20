package net.broscorp;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  /*
    Java передает параметры по значению.
    В этом примере в метод foo мы передаём 2 параметра:
    1 - int i - примитив типа int
    2 - List<String> s - ссылочный тип данных List
    Это означает что мы скопировали значение и передали копию
    в методе foo.
    Именно поэтому значение i не меняется, мы увеличивали копию i, а List<String> s меняется
    так как мы сделали копию ссылки которая ссылается на один и тот же объект,
    и методом add мы изменяем тот самый объект.
   */

  @Test
  void fooTestValues() {
    Foo foo = new Foo();
    List<String> strings = new ArrayList<>();
    int i = 10;
    foo.foo(i, strings);
    foo.foo(i, strings);
    foo.foo(i, strings);
    foo.foo(i, strings);
    Assertions.assertEquals(i, 10);
    Assertions.assertEquals(strings.size(), 4);
  }
}