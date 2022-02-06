package net.broscorp.gc;

/**
 * Class демонстрирует поведение системы при возобновлении ссылки
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
public class GCTest {
    public static GCTest MY_OBJECT = null;
    static boolean trigger = true;

    public static void main(String[] args) throws InterruptedException, Throwable {
        MY_OBJECT = new GCTest();
        MY_OBJECT = null;
        System.gc();
        Thread.sleep(500);

        if (MY_OBJECT != null) {
            System.out.println("OBJECT ALIVE 1");
        } else {
            System.out.println("OBJECT DESTROY 1");
        }

        MY_OBJECT = null;
        trigger = false;
        System.gc();
        Thread.sleep(500);
        if (MY_OBJECT != null) {
            System.out.println("OBJECT ALIVE 2");
        } else {
            System.out.println("OBJECT DESTROY 2");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute method finalize()");
        if (trigger) {
            MY_OBJECT = new GCTest();
            System.out.println("object reachable");
        }

    }

}
