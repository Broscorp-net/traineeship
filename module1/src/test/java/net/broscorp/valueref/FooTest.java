package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

// Примітиви та об'єкти у джава працюють за різними сценаріями:
// Примітиви зберігають своє значення у Stack пам'яті
// і у випадку викликаного методу (розміщений у Stack) передається якби копія примітиву
// яка змінюється у методі, але первинне значення залишається без зміни.
// Об'єкти ж зберігаються у Heap пам'яті, а у Stack поміщаються їхні посилання (reference) на місця у Heap
// тому у даний метод передається не об'єт а лише його посилання і тому зміна об'єкта у методі
//  призводить до загальної зміни об'єкта який використовується програмою

  @Test
  void initFooClass() {
    Foo instanceOfFoo = new Foo();
    int number = 2;
    List<String> strings = new ArrayList<>();
    instanceOfFoo.foo(number, strings);

    System.out.println("number = " + number + "\n get first element " + strings.get(0));

    Assertions.assertEquals(number, 2);
    Assertions.assertEquals(strings.get(0), "d");

  }
}
