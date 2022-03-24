package net.broscorp.override.overload;

/**.
 * @Override не обязательная аннотация. Служит для: Облегчение понимания кода. Если метод
 * родительского класса будет нерпавильно переопредлен - компилчятор укажет ошибку. Сообщает
 * компилятору, что метод переопреляет метод родительского класса.
 */
public interface MathOperation {

  double function(double num1, double num2);

  double function(int num1, int num2);

  double function(Double num1, Double num2);

  double function(Integer num1, Integer num2);

}
