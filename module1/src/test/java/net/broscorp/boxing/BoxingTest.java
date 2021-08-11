package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BoxingTest {
  
  
  /**
   * �������� �� -128 �� 127 �����������. ������� ����� �����������.
   */
  @Test
  void testIntegerEqual() {
    Integer firstInt = 120;
    Integer secondInt = Integer.valueOf(120);
    
    assertTrue(compare(firstInt, secondInt));
  }
  
  /**
   * 400 ��� ��������� ���� Integer'��.
   * new Integer(); ������� ����� ������, �������� ����� �� �����.
   */
  @Test
  void testIntegerNotEqual() {
    Integer firstInt = 400;
    Integer secondInt = Integer.valueOf(400);
    assertFalse(compare(firstInt, secondInt));
    
    Integer thirdInt = new Integer(120);
    Integer fourthInt = 120;
    assertFalse(compare(thirdInt, fourthInt));
  }
  
  boolean compare(Object o1, Object o2) {
    boolean same = o1 == o2;
    System.out.println(o1 + " = " + o2 + " " + same);
    return same;
  }
  
  @Test
  void testUnboxingException() {
    Integer integer = null;
    
    assertThrows(NullPointerException.class, () -> {
      int i = integer; 
    });
  }

  
}
