package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FooTest {

  private Foo foo;

  @BeforeEach
  void setUp() {
    foo = new Foo();
  }

  /*
  Java всегда передает параметры по значению.
  Скопировать значение и передать копию.
  Для примитивных типов все понятно мы получаем копию содержимого и любые изменения в методе
  не повлияют на переданный аргумент.
  Со ссылками мы тоже получаете копию содержимого, но это копия ссылки на один и тот же объект,
  поэтому изменение объекта в методе приводит к изменению переданного объекта.
  */
  @Test
  @DisplayName("Should changed list")
  void shouldChangedListFoo() {
    int i = 5;
    List<String> s = new ArrayList<>();
    foo.foo(i, s);
    assertEquals(5, i);
    assertFalse(s.isEmpty());
    assertEquals("d", s.get(0));
    assertEquals(1, s.size());

  }


  /*
  При передачи в метод List со значением null,
   ожидаем выброс исключения NullPointerException
   */
  @Test
  @DisplayName("Should throw an exception")
  void shouldThrowExceptionFoo() {
    int i = 0;
    List<String> s = null;
    assertThrows(NullPointerException.class,() -> foo.foo(i, s));
  }

}