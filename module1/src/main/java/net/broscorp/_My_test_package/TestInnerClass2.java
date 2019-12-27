package net.broscorp._My_test_package;
// Возврат ссылки на внутренний класс
public class TestInnerClass2 {
    class Content {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }
    // метод для возврата ссылки на внутренний класс
    public Destination to(String s) {
        return new Destination(s);
    }
    // метод для возврата ссылки на внутренний класс
    public Content content() {
        return new Content();
    }

    void ship(String destinat) {
        Content cont = new Content();
        Destination d = to(destinat);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        TestInnerClass2 testInnerClass2 = new TestInnerClass2();
        testInnerClass2.ship("UA");
        TestInnerClass2 testInnerClass22 = new TestInnerClass2();
        // определение ссылок на внутренние классы
        TestInnerClass2.Content c = testInnerClass22.content();
        TestInnerClass2.Destination d = testInnerClass22.to("USA");
    }// Если понадобится созд объект внутреннего класса, кроме как в нестатичес
    // методе внешнего класса, надо указать тип этого объекта так образом:
    // ИмяВнешКласса.ИмяВнутренКласса, что и делается в main(). Плюс обращаемся
    // через ссылку внешнего класса
}
