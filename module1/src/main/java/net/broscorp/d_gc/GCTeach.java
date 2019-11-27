package net.broscorp.d_gc;

public class GCTeach {
    private static int counter = 0;
    private static GCTeach gcTeach_1;

    public static void main(String[] args) {
        method();
    }

    private static void method() {
        for (int i = 0; i < 500_000; i++) { // create 500 thousand objects Date()
            gcTeach_1 = new GCTeach();
            gcTeach_1 = null;
        }
    }

    @Override // method finalize() calling when objects will be deleting of GC Java
    public void finalize() {
        gcTeach_1 = this; // Если объектам снова присвоить ссылки они не удаляются из памяти
        System.out.println("Deleting");
        System.out.println("Obj restore " + gcTeach_1.hashCode());
    }
}
