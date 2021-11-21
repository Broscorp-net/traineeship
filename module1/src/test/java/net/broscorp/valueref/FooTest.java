package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  @Test
  void foo() {
    Foo f = new Foo();

    int i = 1;
    List<String> fooObjects = new ArrayList<>(1);

    f.foo(i, fooObjects);

    assertEquals(1, i);
    assertEquals("d", fooObjects.get(0));

    /*
     *В java объекты могут быть переданы по ссылке или по значению.
     *При передаче по ссылке передается ссылка на объект и метод может модифицировать переданный
     *объект.
     *При передаче по значению объект копируется и изменения будут произведены над копией.
     *В java примитивы передаются по значению - была создана копия int`a и изменения в методе foo()
     *были произведены над копией.
     *Объекты передаются по ссылке - в метод foo() передана ссылка на лист строк, все изменения
     *были произведены над тем же объектом. По этому, в листе есть значение, которое было добавлено
     *в методе foo().
     */

  }
}