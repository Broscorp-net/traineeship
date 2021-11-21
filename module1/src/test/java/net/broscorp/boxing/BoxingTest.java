package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  /*
   * If 2 values are in the range of Integer pool (-128..127),
   * then 2 references to one object are compared,
   * and if the variables exceed this range,
   * then a separate reference is created for each variable.
   * */

  @Test
  void comparisonOfWrapperTypesUpTo128Test() {
    Integer var1 = 127;
    Integer var2 = 127;
    assertTrue(Boxing.comparisonOfWrapperTypes(var1, var2));
  }

  @Test
  void comparisonOfWrapperTypesEqualTo128() {
    Integer var1 = 128;
    Integer var2 = 128;
    assertFalse(Boxing.comparisonOfWrapperTypes(var1, var2));
  }

  @Test
  void comparisonOfWrapperTypesOver128Test() {
    Integer var1 = 555;
    Integer var2 = 555;
    assertFalse(Boxing.comparisonOfWrapperTypes(var1, var2));
  }

  @Test
  void comparingVariablesUsingNewTest() {
    Integer var1 = new Integer(55);
    Integer var2 = new Integer(55);
    assertFalse(Boxing.comparisonOfWrapperTypes(var1, var2));
  }

  @Test
  void comparingVariablesUsingNewTrueTest() {
    Integer var1 = new Integer(55);
    Integer var2 = var1;
    assertTrue(Boxing.comparisonOfWrapperTypes(var1, var2));
  }

  @Test
  void demonstrationOfGettingAnErrorTest() {
    Integer var1 = null;
    NullPointerException exception = assertThrows(NullPointerException.class, () -> {
      Boxing.demonstrationOfGettingAnError(var1);
      throw new NullPointerException("Null value cannot be converted to int ");
    });
    Assertions.assertEquals("Null value cannot be converted to int ", exception.getMessage());
  }
}
