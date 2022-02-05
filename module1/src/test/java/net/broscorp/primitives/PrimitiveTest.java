package net.broscorp.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrimitiveTest {

  PrimitiveInterface primitive = new Primitive();

  @Test
   public void overFlowLong() {
    long result = primitive.overflowLong();
    assertEquals(result,Long.MIN_VALUE);
  }

  @Test
  public void overFlowByte() {
    byte result = primitive.overflowByte();
    assertEquals(result,Byte.MIN_VALUE);
  }

  @Test
  public void overFlowInt() {
    int result = primitive.overflowInt();
    assertEquals(result,Integer.MIN_VALUE);
  }

  @Test
  public void conversionToIntTest() {
    Object result = primitive.conversionToInt(100L);
    assertEquals(java.lang.Integer.class, result.getClass());
  }

  @Test
   public void conversionToFloat() {
    Object result = primitive.conversionToFloat(100.0d);
    assertEquals(java.lang.Float.class, result.getClass());
  }

  @Test
   public void floatErrors() {
    float result = primitive.floatErrors();
    assertNotEquals(result,0.9);
  }

  @Test
   public void doubleErrors() {
    double result = primitive.doubleErrors();
    assertNotEquals(result,0.9);
  }
}
