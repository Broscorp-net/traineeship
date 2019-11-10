package net.broscorp.d_gc.result_first;

public class Car {

    public void display() {
        System.out.println("Car live " + this.hashCode());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Car destroyed: hashCode - " + this.hashCode());
    }

    public static void main(String[] args) throws Throwable {
        for (int i = 1; i <= 1_000_000; i++) {
            Car car = new Car();
            car.display();
            car = null;
        }
    }
}
