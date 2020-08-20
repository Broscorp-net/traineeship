import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class WrapperClassCompareTest {

  @Test
  public void comparingWrappersWithCompareOperatorBoxing() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    assertNotSame(n1, n2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorUnboxing() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    int num1 = n1;
    int num2 = n2;
    assertEquals(num1, num2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorBoxingInsideHeap() {
    Integer n1 = 5;
    Integer n2 = 5;
    assertSame(n1, n2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorBoxingOutOfHeap() {
    Integer n1 = 128;
    Integer n2 = 128;
    assertNotSame(n1, n2);
  }

  @Test
  public void comparingWrappersWithEqualsBoxing() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    assertEquals(n1, n2);
  }
}