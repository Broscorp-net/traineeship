package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValueRefTest {

  private Foo foo;
  private List<String> list;

  @BeforeEach
  void init() {
    foo = new Foo();
    list = new ArrayList<>();
    list.add("a");
  }

  @Test
  void fooValueTest() {
    int value = 1;
    //При передаче параметров по значению, метод создает копию аргумента и затем его использует
    foo.foo(value, list);
    //Так как работа ведется с копией, на параметр value это никак не повлияет
    Assertions.assertEquals(1, value); //Поэтому value будет равно 1
  }

  @Test
  void fooReferenceTest() {
    //При передаче параметров по ссылке на исходную переменную, метод не создает копию,
    //а ссылается на исходное значение
    foo.foo(1, list);
    //Поэтому при изменении значения в методе, будет изменено исходное значении
    Assertions.assertEquals(Arrays.asList("a", "d"), list);
  }

  @Test
  void fooNullPointerTest() {
    //Вылезет NullPointerException так как значение второго параметра null
    Assertions.assertThrows(NullPointerException.class, () -> foo.foo(1, null));
  }

}