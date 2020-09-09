package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WrapperClassCompareTest {

  @Test
  public void comparingWrappersWithCompareOperatorInsideHeap() {
    Integer n1 = 5;
    Integer n2 = 5;
    assertTrue(n1 == n2);
  }

  @Test
  public void comparingWrappersWithCompareOperatorOutOfHeap() {
    Integer n1 = 128;
    Integer n2 = 128;
    assertFalse(n1 == n2);
  }

  @Test
  public void comparingNewObjectsWrappersWithCompareOperator() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    assertFalse(n1 == n2);
  }

  @Test
  public void comparingWrappersWithEquals() {
    Integer n1 = new Integer(5);
    Integer n2 = new Integer(5);
    assertTrue(n1.equals(n2));
  }

  @Test
  public void intToByteExplicitDownCasting() {
    int n1 = 45;
    byte n2 = (byte) n1;
    assertTrue(n1 == n2);
  }

  @Test
  public void intToLongImplicitUpCasting() {
    int n1 = 256;
    long n2 = n1;
    assertTrue(n1 == n2);
  }
}

