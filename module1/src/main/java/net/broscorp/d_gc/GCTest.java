package net.broscorp.d_gc;

public class GCTest {

    private String name;
    private static int countOfObject = 0;
    private int numberOfObject;

    public GCTest(String name) {
        this.name = name;
        this.numberOfObject = countOfObject++;
    }

    public void largeNumberOfObjects(){
        for (int i = 0; i < 1_000_000; i++) {
            GCTest gcTest = new GCTest("test1");
            if(i%2 == 0)
                gcTest = null;
        }
    }

    public void twoLinksToOneObject(){
        for (int i = 0; i < 1_000_000; i++) {
            GCTest gcTest = new GCTest("test1");
            GCTest gcTest2 = gcTest;
            if(i%2 == 0)
                gcTest2 = null;
        }
    }

    @Override
    protected void finalize()  {
        System.out.println("Упс но я удалил " + this.name + " - " + this.numberOfObject + " объект.");
    }

    @Override
    public String toString() {
        return "NumberOfObject = " + numberOfObject;
    }
}
