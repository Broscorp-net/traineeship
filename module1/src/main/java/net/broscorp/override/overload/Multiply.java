/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.override.overload;

public class Multiply implements MathOperation {

  @Override
  public double operation(double a, double b) {
    System.out.println("Multiplication of two double primitives called.");
    return a * b;
  }

  @Override
  public double operation(int a, int b) {
    System.out.println("Multiplication of two integers primitives called.");
    return a * b;
  }

  @Override
  public double operation(Double a, Double b) {
    System.out.println("Multiplication of two double wrappers called.");
    return a * b;
  }

  @Override
  public double operation(Integer a, Integer b) {
    System.out.println("Multiplication of two integer wrappers called.");
    return a * b;
  }
}
