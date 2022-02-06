package net.broscorp.gc;

/**
 * Class демонстрирует поведение системы при удалении пары объектов, которые ссылаются друг на друга
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
public class TwoLinkTest {
    public TwoLinkTest MY_OBJECT;

    public static void main(String[] args) throws InterruptedException {
        TwoLinkTest one = new TwoLinkTest();
        TwoLinkTest two = new TwoLinkTest();

        one.MY_OBJECT = two;
        two.MY_OBJECT = one;
        System.gc();

        Thread.sleep(500);
        System.out.println(one);
        System.out.println(two);

        System.out.println("ONE LINK=null");
        one = null;

        Thread.sleep(500);
        System.gc();

        Thread.sleep(500);
        System.out.println(one);
        System.out.println(two);

        System.out.println("TWO LINK=null");
        two = null;
        System.gc();

        Thread.sleep(500);
        System.out.println(one);
        System.out.println(two);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute method finalize()");
    }

}
