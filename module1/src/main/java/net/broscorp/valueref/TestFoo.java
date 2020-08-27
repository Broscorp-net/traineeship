package net.broscorp.valueref;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFoo {

  Foo clazz = new Foo();
  int anInt = 20;
  List<String> list = new ArrayList<>();

  @Test
  public void fooTest() {
    int value = anInt;
    clazz.foo(value, list);
    Assert.assertSame(anInt, value);
    //Примитивный тип не будет подвержен изменению так как в метод поступает его копия
    Assert.assertTrue(list.contains("d"));
    //А вот лист будет изменёт потому что пердаёт свою ссылку в метод
  }
}

