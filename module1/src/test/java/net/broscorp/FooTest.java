package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;

import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  void fooTest() {
    Foo instance = new Foo();

    List<String> objectsList = new ArrayList<>(3);
    instance.foo(1, objectsList);

    assertEquals("d", objectsList.get(0));
  }
}

/*
Для вызова метода foo необходимо создать обьект класса Foo.
Объекты передаются по ссылке или по значению (при передаче по ссылке передается
ссылка на объект и метод может модифицировать переданный объект).
После чего вызываем метод foo у данного обьекта и передаем как аргумент ссылку на лист строк.
При вызове метода Java делает копию примитивной переменной.
Все действия Java выполняет с копией, а на исходную переменную никакого влияния не имеет.
Что касается списка Java копирует значение этой примитивной переменной из памяти, а там
хранится адрес ячейки памяти.
В итоге исходная переменная и копия сделанная Java ссылаются на одну и ту же ячейку,
это значит что и действия произведенные с копией повлияют на исходную переменную.
 */
