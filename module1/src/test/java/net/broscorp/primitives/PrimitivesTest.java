package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  void test() {
    testOverflow();
    testCast();
    testFloatCalculation();
  }

  void testOverflow() {
    int value = Integer.MAX_VALUE;
    int overflowValue = value + 10;
    
    System.out.println("Overflow value: " + overflowValue);
    
    assertFalse(overflowValue > value);
  }
  
  void testCast() {
    assertFalse(longToIntCompare(123456789012345L));
    assertTrue(longToIntCompare(12345L));
    
    assertTrue(floatToDoubleCompare(12345.4612456F));
  }
  
  boolean longToIntCompare(long l) {
    long longValue = l;
    int intValue = (int) longValue;
    System.out.println("Origin long: " + longValue + " -> " 
                      + "Casted int: " + intValue);
    return longValue == intValue;
  }
  
  boolean floatToDoubleCompare(float f) {
    float floatValue = f;
    double doubleValue = (double) floatValue;
    System.out.println("Origin float: " + floatValue + " -> " 
                      + "Converted double: " + doubleValue);
    return floatValue == doubleValue;
  }
  
  void testFloatCalculation() {
    float f = 1.1F; 
    BigDecimal dec = new BigDecimal(1.1);
    
    for (int i = 0; i < 10; i++) {
      f += 1.1F;
      dec = dec.add(new BigDecimal(1.1));
    }
    
    System.out.println("Correct value: " + dec.floatValue() + " | Actual value " + f);
    assertNotEquals(dec.floatValue(), f);
  }
  
}
