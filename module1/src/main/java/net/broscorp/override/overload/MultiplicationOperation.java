public class MultiplicationOperation implements MathOperation {

  public double operation(double num1, double num2) {
    System.out.println("Operation with two double values");
    return num1 * num2;
  }

  public double operation(int num1, int num2) {
    System.out.println("Operation with two int values");
    return num1 * num2;
  }

  public double operation(Double num1, Double num2) {
    System.out.println("Operation with two Double values");
    return num1 * num2;
  }

  public double operation(Integer num1, Integer num2) {
    System.out.println("Operation with two Integer values");
    return num1 * num2;
  }
}
