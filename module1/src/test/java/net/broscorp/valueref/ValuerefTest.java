package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValuerefTest {

  private final List<String> listString = Arrays.asList("1");
  private final List<String> listNewString = new ArrayList<>(Arrays.asList("2"));
  private final Foo foo = new Foo();
  /*
    просто успешный тест
  */

  @Test
  public void passTest() {
    Assertions.assertDoesNotThrow(() -> foo.foo(1, listNewString));
  }
  /*
    При передачи null в метод,
    ожидаем выброс исключения NullPointerException
  */

  @Test
  public void failNullPointerExceptionList() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      foo.foo(0, null);
    });
  }
  /*
    Array.asList()- это просто обертка над массивом с интерфейсом List.
    А массивы имеют фиксированный размер, поэтому добавление
    и удаление элементов не поддерживается
  */

  @Test
  public void failUnsupportedOperationException() {
    Assertions.assertThrows(UnsupportedOperationException.class, () -> {
      foo.foo(1, listString);
    });
  }

}
