public class Addition implements MathOperation {

    /** Аннотация @Override указывает компилятору использовать
     * именно аннтотированный метод, а не его аналог
     * (такое же имя метода и набор параметров) из родительского класса.
     */

    @Override
    public double operation(double a, double b) {
        return a + b;
    }

    @Override
    public int operation(int a, int b) {
        return a + b;
    }

    @Override
    public double operation(Double a, Double b) {
        return a + b;
    }

    @Override
    public int operation(Integer a, Integer b) {
        return a + b;
    }

}
