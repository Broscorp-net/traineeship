package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrimitivesTest {
  @Test
  @DisplayName("Bigger number")
  public void ifIntIsBiggerThanByteCanContain() {
    assertFalse(Primitives.intToByte(159));
  }

  @Test
  public void ifIntCanBeStoredAsByte() {
    assertTrue(Primitives.intToByte(100));
  }

  @Test
  public void ifLongCanBeStoredAsInt() {
    int a = Primitives.longToInt(256569886);
    assertEquals(256569886,a);
  }

  @Test
  public void ifLongCanNotBeStoredAsInt() {
    int a = Primitives.longToInt(0xffffffffL);
    assertEquals(-1,a);
  }

  @Test
  public void convertFloatToDouble() {
    assertEquals(10.01,Primitives.floatToDoubleVarOne(10.01f),0.01);
  }

  @Test
  public void convertFloatToDoubleUsingString() {
    assertEquals(10.01,Primitives.floatToDoubleVarTwo(10.01f));
  }

  @Test
  public void convertFloatToDoubleUsingBigDecimal() {
    assertEquals(10.01,Primitives.floatToDoubleVarThree(10.010125f));
  }

}