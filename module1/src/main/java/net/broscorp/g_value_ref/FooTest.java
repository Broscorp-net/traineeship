import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class FooTest {

 /**
  *В этом задании, как я его понял, мы должны увидеть, что при тестировании приватоного метода,доступ к нему закрыт
  *Но есть вариант через Рефлексию все таки получить доступ к методу. Что я и сделал
  *Но при инициализации параметров в этом методе, на параметр list выскакивает ошибка 
  *java.lang.IllegalArgumentException: argument type mismatch.
  *Я пробовал с разными комбинациями, без листа, с примитивами, все работает. С list - нет.
  *Также метод ничего не возвращает, поэтому проверяем что он запускаеся, тоесть приравниваем его к возвращаемому обьекту, любому
  *и веррифицируем это через assertNull(obj). 
  *Так работает, кроме случая с аргументом list
  *
  *Куда можно еще копнуть?
  *
  */
  @Test
  void myTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
   
    int b = 0;
    
    // creating Arrays of String type 
    String a[] = new String[] { "A", "B", "C", "D" }; 

    // getting the list view of Array 
    List<String> list = Arrays.asList(a);
  
        Class<?> foo = Class.forName("Foo");
   Method method[] = foo.getDeclaredMethods();
   method[0].setAccessible(true);
  // System.out.println(Arrays.deepToString(method));
  Object obj = method[0].invoke(null,b, list);//<-в этой части кода ошибка java.lang.IllegalArgumentException: argument type mismatch.
  
   assertNull(obj);
   
  }

}
