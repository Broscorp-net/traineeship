package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FooTest {
  private Foo fooObject;
  private List<String> stringList;

  /* Проверим что значение примитивной переменной i не изменилось после передачи в метод*/
  @Test
  public void checkInputDataPrim() {
    int i = 1;
    stringList = new ArrayList<>();
    fooObject = new Foo();
    int tempI = i;
    fooObject.foo(i,stringList);
    Assertions.assertEquals(i,tempI);
  }

  /* Проверим что количество элементов коллекции изменилось после передачи в метод*/
  @Test
  public void checkInputDataRef() {
    stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");
    fooObject = new Foo();
    int listSize = stringList.size();

    fooObject.foo(1,stringList);
    Assertions.assertNotEquals(stringList.size(),listSize);
  }

  /*Проверим корректность сохранения "d" в методе*/
  @Test
  public void saveStringTest() {
    stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");
    fooObject = new Foo();

    fooObject.foo(1,stringList);
    Assertions.assertEquals(stringList.get(3),"d");
  }

}