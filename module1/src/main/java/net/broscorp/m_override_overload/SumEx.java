package net.broscorp.m_override_overload;

/**
 * Override - это аннотация указывающая программисту на то
 *             что метод над которым она стоит переопределен от наследуемого класса или 
 *             интерфейса. Этот  метод возможно  уже реализован в классе предке. 
 *             По большому счету можно обойтись и без этой аннотации, так как это просто 
 *             маркер, но с ней проще понимать код.
 *
 */
public class SumEx implements MathOperation {

  @Override
  public double math(double i, double t) {
    return i+t;
  }

  @Override
  public double math(int i, int t) {
    return i+t;
  }

  @Override
  public double math(Integer i, Integer t) {
    return i+t;
  }

  @Override
  public double math(Double i, Double t) {
    return i+t;
  }
}
