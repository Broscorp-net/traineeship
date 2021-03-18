package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class BoxingAndUnboxingTest {


  /*
При сравнении классов-обёрток оператором == или !=,
 происходит сравнение по ссылкам, а не по значениям
 При инициализации через = сначала объект ищется в пуле,
 если он там есть возвращается ссылка на него.
 При инициализации через new сразу создается новый объект.
 */
  @Test
  @DisplayName("Should return true")
  public void souldReturnTrueTest() {
    Integer one = 10;
    Integer two = 10;
    assertTrue(one == two);

  }

  @Test
  @DisplayName("Should return false")
  public void souldReturnFalseTest() {
    Integer one = new Integer(10);
    Integer two = new Integer(10);
    assertFalse(one == two);

  }


  /*
  Unboxing null всегда бросает NullPointerException.
  Boxing имеет более высокий приоритет, чем сравнение ссылок
   */

  @Test
  @DisplayName("Should throw NullPointerException")
  public void souldThrowNullPointerExceptionTest() {
    Integer one = null;
    int i = 0;
    assertThrows(NullPointerException.class, () -> Math.max(one, i));

  }

}
