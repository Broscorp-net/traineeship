package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;


public class TestInterfaceCapabilities {

  private MathOperation sum = new SumOperation();
  private MathOperation multiplication = new MultiplicationOperation();

  @Test
  public void testSumWithDoubleFields() {
    double firstValue = 2.1;
    double secondValue = 2.4;
    System.out.println(sum.operation(firstValue, secondValue));
    assertEquals(4.5, sum.operation(firstValue, secondValue));
  }

  @Test
  public void testSumWithIntFields() {
    int firstValue = 6;
    int secondValue = 12;
    assertEquals(18, sum.operation(firstValue, secondValue));
  }

  @Test
  public void testSumWithRefDoubleFields() {
    Double firstValue = 6.3;
    Double secondValue = 6.2;
    assertEquals(12.5, sum.operation(firstValue, secondValue));
  }

  @Test
  public void testSumWithIntegerFields() {
    Integer firstValue = 2;
    Integer secondValue = 8;
    assertEquals(10, sum.operation(firstValue, secondValue));
  }

  @Test
  public void testMultiplicationWithDoubleFields() {
    double firstValue = 3.1;
    double secondValue = 2.4;
    assertEquals(7.44, multiplication.operation(firstValue, secondValue));
  }

  @Test
  public void testMultiplicationWithIntFields() {
    int firstValue = 8;
    int secondValue = 5;
    assertEquals(40.0, multiplication.operation(firstValue, secondValue));
  }

  @Test
  public void testMultiplicationWithRefDoubleFields() {
    Double firstValue = 2.5;
    Double secondValue = 10.0;
    assertEquals(25.0, multiplication.operation(firstValue, secondValue));
  }

  @Test
  public void testMultiplicationWithIntegerFields() {
    Integer firstValue = 10;
    Integer secondValue = 5;
    assertEquals(50.0, multiplication.operation(firstValue, secondValue));
  }

  @Test
  public void testMultiplicationWithIntegerAndIntFields() {
    Integer firstValue = 10;
    int secondValue = 5;
    assertEquals(50.0, multiplication.operation(firstValue, (Integer) secondValue));
  }
}
