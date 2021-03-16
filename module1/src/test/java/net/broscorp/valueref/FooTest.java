package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.*;

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
  Ожидаем что List не null, иначе тест не пройдет,
   так как будет попытка добавления элемента в несуществующую коллекцию
   */
  @Test
  @DisplayName("Should not throw an exception")
  void shouldNotThrowExceptionFoo() {
    int i = 5;
    List<String> s = new ArrayList<>();

    assertDoesNotThrow(()->foo.foo(i, s));
  }

  /*
  При передачи в метод List со значением null,
   ожидаем выброса исключения NullPointerException
   */
  @Test
  @DisplayName("Should throw an exception")
  void shouldThrowExceptionFoo() {
    int i = 0;
    List<String> s = null;

    assertThrows(NullPointerException.class,()->foo.foo(i, s));
  }

}