package net.broscorp.override.overload;

/**
 * Аннотация override - по сути, сообщение компилятору
 * что метод переопределен.
 * Но его можно явно не писать, компилятор сам поймет,
 * поэтому это скорее сообщение для программиста.
 */
public interface MathOperations {
  double someMathOperation(double first, double second);

  double someMathOperation(int first, int second);

  double someMathOperation(Integer first, Integer second);

  double someMathOperation(Double first, Double second);
}
