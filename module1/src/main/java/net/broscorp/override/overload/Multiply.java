package net.broscorp.override.overload;

import java.math.BigDecimal;

public class Multiply implements MathOperation {

  @Override
  public double calculate(double first, double second) {
    return BigDecimal.valueOf(first).multiply(BigDecimal.valueOf(second)).doubleValue();
  }

  @Override
  public double calculate(int first, int second) {
    return first * second;
  }

  @Override
  public double calculate(Integer first, Integer second) {
    return first * second;
  }

  @Override
  public double calculate(Double first, Double second) {
    return BigDecimal.valueOf(first).multiply(BigDecimal.valueOf(second)).doubleValue();
  }
}
