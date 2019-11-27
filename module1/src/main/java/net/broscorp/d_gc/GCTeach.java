package net.broscorp.d_gc;

public class GCTeach {
    private static int counter = 0;
    private static GCTeach gcTeach_1;
    private static GCTeach gcTeach_2;

    private GCTeach() {
        counter++;
    }

    private int getGcTeach() {
        return counter;
    }

    public static void main(String[] args) {
        method();
    }

    private static void method() {
        for (int i = 0; i < 1_000_000; i++) { // create 1 million objects Date()
            gcTeach_1 = new GCTeach();
            gcTeach_2 = new GCTeach();
            //gcTeach_1 = gcTeach_2;
            //gcTeach_2 = gcTeach_1;
            //gcTeach_1 = null;
            //gcTeach_2 = null;
        }
    }

    @Override // method finalize() calling when objects will be deleting of GC Java
    public void finalize() {
        //gcTeach_1 = this;
        //gcTeach_2 = this;
        if (gcTeach_1.equals(gcTeach_2)) {
            System.out.println("\t" + gcTeach_1.getGcTeach() + " == " + gcTeach_2.getGcTeach());
        }
        // Если объектам снова присвоить ссылки они не удаляются из памяти
        if (gcTeach_1 == this || gcTeach_2 == this) {
            System.out.println(gcTeach_1.getGcTeach() + " " + gcTeach_1.toString() + " Alive!");
            System.out.println(gcTeach_2.getGcTeach() + " " + gcTeach_2.toString() + " Alive!");
        } else {
            System.out.println("Deleting: " + gcTeach_1.getGcTeach() + " " + gcTeach_1.toString());
            System.out.println("Deleting: " + gcTeach_2.getGcTeach() + " " + gcTeach_2.toString());
        }
    }
}
