public class Test {
static Test test1;

    public static void main(String[] args) {
       Test test = new Test();
       test1 = test;
       test = null;
       System.gc();
       System.out.println(test1.hashCode());
       System.out.println(test.hashCode());
       
       
    }