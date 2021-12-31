package net.broscorp.equals.hashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleClassTest {

  /**
   * Below are checks for invariants for equals method.
   * The equals method implements an equivalence relation on non-null object references:
   * 1) It is reflexive: for any non-null reference value x, x.equals(x) should return true.
   * 2) It is symmetric: for any non-null reference values x and y, x.equals(y) should return true
   * if and only if y.equals(x) returns true.
   * 3) It is transitive: for any non-null reference values x, y,and z, if x.equals(y) returns true
   * and y.equals(z) returns true, then x.equals(z) should return true.
   * 4) It is consistent: for any non-null reference values x and y, multiple invocations of
   * x.equals(y) consistently return true or consistently return false, provided no information used
   * in equals comparisons on the objects is modified.
   * 5) For any non-null reference value x, x.equals(null) should return false.
   */

  /**
   * 1) It is reflexive: for any non-null reference value x, x.equals(x) should return true.
   */
  @Test
  void equalsIsReflexive() {
    SampleClass x = new SampleClass(5, "s");
    Assertions.assertTrue(x.equals(x));
  }

  /**
   * 2) It is symmetric: for any non-null reference values x and y, x.equals(y) should return true
   * if and only if y.equals(x) returns true.
   */
  @Test
  void equalsIsSymmetric() {
    SampleClass x = new SampleClass(5, "s");
    SampleClass y = new SampleClass(5, "s");
    Assertions.assertTrue(x.equals(y) && y.equals(x));
  }

  /**
   * 3) It is transitive: for any non-null reference values x, y,and z, if x.equals(y) returns true
   * and y.equals(z) returns true, then x.equals(z) should return true.
   * */
  @Test
  void equalsIsTransitive() {
    SampleClass x = new SampleClass(5, "s");
    SampleClass y = new SampleClass(5, "s");
    SampleClass z = new SampleClass(5, "s");
    Assertions.assertTrue(x.equals(y) && y.equals(z) && x.equals(z));
  }

  /**
   * 4) It is consistent: for any non-null reference values x and y, multiple invocations of
   * x.equals(y) consistently return true or consistently return false, provided no information used
   * in equals comparisons on the objects is modified.
   */
  @Test
  void equalsIsConsistent() {
    SampleClass x = new SampleClass(5, "s");
    SampleClass y = new SampleClass(5, "s");
    SampleClass z = new SampleClass(6, "f");
    Assertions.assertTrue(x.equals(y) == x.equals(y) && x.equals(z) == x.equals(z));
  }

  /**
   * 5) For any non-null reference value x, x.equals(null) should return false.
   */
  @Test
  void equalsWithNull() {
    SampleClass x = new SampleClass(5, "s");
    Assertions.assertFalse(x.equals(null));
  }

  /**
   * Following checks are for invariants of hashCode method.
   * The general contract of hashCode is:
   * 1) Whenever it is invoked on the same object more than once during an execution of a
   * Java application, the hashCode method must consistently return the same integer,
   * provided no information used in equals comparisons on the object is modified.
   * This integer need not remain consistent from one execution of an application to another
   * execution of the same application.
   * 2) If two objects are equal according to the equals(Object) method, then calling the hashCode
   * method on each of the two objects must produce the same integer result.
   * It is not required that if two objects are unequal according to the equals(java.lang.Object)
   * method, then calling the hashCode method on each of the two objects must produce distinct
   * integer results. However, the programmer should be aware that producing distinct integer
   * results for unequal objects may improve the performance of hash tables.
   */

  /**
   * Whenever it is invoked on the same object more than once during an execution of a
   * Java application, the hashCode method must consistently return the same integer,
   * provided no information used in equals comparisons on the object is modified.
   * This integer need not remain consistent from one execution of an application to another
   * execution of the same application.
   */
  @Test
  void hcMultipleCallsOnSameObject() {
    SampleClass x = new SampleClass(5, "s");
    Assertions.assertEquals(x.hashCode(),x.hashCode());
  }

  /**
   * If two objects are equal according to the equals(Object) method, then calling the hashCode
   * method on each of the two objects must produce the same integer result.
   * It is not required that if two objects are unequal according to the equals(java.lang.Object)
   * method, then calling the hashCode method on each of the two objects must produce distinct
   * integer results. However, the programmer should be aware that producing distinct integer
   * results for unequal objects may improve the performance of hash tables.
   */
  @Test
  void hcEqualObjects() {
    SampleClass x = new SampleClass(5, "s");
    SampleClass y = new SampleClass(5, "s");
    Assertions.assertTrue(x.equals(y) && x.hashCode() == y.hashCode());
  }

  @Test
  void locateNonEqualSameHC() {
    SampleClass target = new SampleClass(5, "s");
    int targetHC = target.hashCode();

    // Making a shortcut since I am familiar with the implementation of hashCode()
    SampleClass base = new SampleClass(0, "x");
    int baseHC = base.hashCode();

    int delta = targetHC - baseHC;
    SampleClass targetEqualHC = new SampleClass(delta, "x");

    System.out.println(String.format("Objects o1: %s and o2: %s are different,"
        + " however they have the same hashCode %d.",
        target.toString(), targetEqualHC.toString(), targetHC));
    Assertions.assertTrue(!target.equals(targetEqualHC) && targetHC == targetEqualHC.hashCode());
  }
}