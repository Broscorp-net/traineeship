package net.broscorp.override.overload;

/**
 * Math Operation Interface.
 * @override - аннотация, которая позволяет в классе-наследнике переопределить (реализовать)
 *     существующий метод класса-родителя. (Полиморфизм)
 */
public interface MathOperation {

  double execute(double first, double second);

  double execute(Double first, Double second);

  double execute(int first, int second);

  double execute(Integer first, Integer second);
}
