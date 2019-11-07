class MyObject {
    Test main;

    public MyObject(Test t) {    
        main = t; 
    }

    protected void finalize() {
        main.ref = this; // let instance become reachable again
        System.out.println("This is finalize"); //test finalize run only once
    }
}

public class Test {
    MyObject ref;

    public static void main(String[] args) {
        Test test = new Test();
        test.ref = new MyObject(test);
        test.ref = null; //MyObject become unreachable，finalize will be invoked
        System.gc(); 
        if (test.ref != null) System.out.println("MyObject still alive!");  
    }
} 
