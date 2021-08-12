/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.override.overload;

/**
 * @Override Override forces an inheritor to change a function body of its parent
 */

public interface MathOperation {

  double operation(double a, double b);

  double operation(int a, int b);

  double operation(Double a, Double b);

  double operation(Integer a, Integer b);
}
