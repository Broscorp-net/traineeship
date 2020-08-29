package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;


public class TestInterfaceCapabilities {

  private DecimalFormat format = new DecimalFormat("###.#");
  private MathOperation sum = new SumOperation();
  private MathOperation subtraction = new SubtractionOperation();

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
    System.out.println(sum.operation(firstValue, secondValue));
    assertEquals(18, sum.operation(firstValue, secondValue));
  }

  @Test
  public void testSumWithIntegerFields() {
    Integer firstValue = 2;
    Integer secondValue = 8;
    System.out.println(sum.operation(firstValue, secondValue));
    assertEquals(10, sum.operation(firstValue, secondValue));
  }

  @Test
  public void testSubtractionWithDoubleFields() {
    double firstValue = 3.1;
    double secondValue = 2.4;
    double answer = roundAvoid(subtraction.operation(firstValue, secondValue), 1);
    assertEquals(0.7, answer);
  }

  @Test
  public void testSubtractionWithIntFields() {
    int firstValue = 8;
    int secondValue = 5;
    assertEquals(3, subtraction.operation(firstValue, secondValue));
  }

  @Test
  public void testSubtractionWithIntegerFields() {
    Integer firstValue = 10;
    Integer secondValue = 5;
    assertEquals(5, subtraction.operation(firstValue, secondValue));
  }

  @Test
  public void testSubtractionWithIntegerAndIntFields() {
    Integer firstValue = 10;
    int secondValue = 5;
    assertEquals(5, subtraction.operation(firstValue, (Integer) secondValue));
  }

  private double roundAvoid(double value, int places) {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
  }
}
