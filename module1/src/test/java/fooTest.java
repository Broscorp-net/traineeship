import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class fooTest {

  static Foo foo = new Foo();
  static int a = 0;
  static List<String> list = new ArrayList<>();

  @BeforeAll
  public static void init() {
    foo.foo(a, list);
  }
//В методе foo используется копия значения переменной а.
//Значение переменной а не меняется.
  @Test
  public void testInt() {
    assertEquals(0, a);
  }
//В отличии от переменной a, list вместо значения, хранит ссылку.
//В метод передается ссылка и изменяется объект на который она указывает.
  @Test
  public void testList() {
    assertEquals("d", list.get(0));
  }
}
