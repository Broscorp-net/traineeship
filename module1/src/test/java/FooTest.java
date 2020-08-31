import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Test;

class FooTest {
  private Foo foo = new Foo();
  private int first = 10;
  private List<String> list = new ArrayList();

  @Test
  void foo() {
    foo.foo(first,list);
    assertEquals(10, first);
    // int не является ссылочным типом, так что в метод
    // передается копия примитива и его значение меняется только внутри метода
    assertFalse(list.isEmpty());
    // List является ссылочным типом и ссылка, которая передается в метод,
    // указывает на изначальный обьект. Изменения внутри метода меняют глобальное состояние
  }
}