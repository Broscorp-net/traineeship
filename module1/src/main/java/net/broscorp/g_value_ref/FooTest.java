package net.broscorp.g_value_ref;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class FooTest {

  @Test
  public void fooCheckList() {
    Foo foo = new Foo();
    int i = 10;
    ArrayList s = new ArrayList<String>();
    //передали в метод ArrayList ожидаем что метод добавит "d" в этот лист
    foo.foo(i, s);
    assertEquals("d", s.get(0));

  }

  @Test
  public void fooCheckInt() {
    Foo foo = new Foo();
    int i = 10;
    ArrayList s = new ArrayList<String>();
    //передали в метод int ожидаем что int не измениться
    //потому что примитивы передаются по значению
    foo.foo(i, s);
    assertEquals(10, i);

  }
}