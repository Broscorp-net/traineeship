import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WrapperClassCompareTest {

  @Test
  public void comparingWrappersWithCompareOperatorBoxing() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    assertFalse(n1 == n2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorUnboxing() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    int num1 = n1;
    int num2 = n2;
    assertTrue(num1 == num2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorBoxingInsideHeap() {
    Integer n1 = 5;
    Integer n2 = 5;
    assertTrue(n1 == n2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorBoxingOutOfHeap() {
    Integer n1 = 128;
    Integer n2 = 128;
    assertFalse(n1 == n2);
  }

  @Test
  public void comparingWrappersWithEqualsBoxing() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    assertTrue(n1.equals(n2));
  }
}