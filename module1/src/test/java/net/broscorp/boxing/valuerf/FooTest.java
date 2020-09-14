package net.broscorp.boxing.valuerf;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  public void testFooWithListExcectedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(1, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
  }
  /*
  * Тестирование void методов в junit довольно проблематична, за частую и не нужна, 
  * так как метод ничего не возращяет мы можем проверить только его вляние на переменные, 
  * которые он принимает в своей сигнатуре, но так как одна из переменных имеет примитивный тип, 
  * мы ее изменения проверить не можем так как при передачи ее методу создается копия с которой уже работает нашь метод,
  * Остается вариант с проверкой только изменений в ссылочной переменной.
  */
  
  @Test
  public void testFooWithDigitAndListExcectedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();
    int number = 14;

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(number, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
    
    Assertions.assertTrue(number == 14);
  }
  
  /*
   * Данный тест показывает, переменная number не изменилась, 
   * хотя метод foo добавляет к ней 15, что потверждает выше сказанное.
   */
}
