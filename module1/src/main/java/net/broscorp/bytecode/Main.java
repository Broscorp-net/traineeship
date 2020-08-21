package net.broscorp.bytecode;
/**
 * @author Nikita Oleksin
 */
public class Main {

    public static void main(String[] args) {
        int i = 2;
        while(i++<8){
            System.out.println("i = " + i);
        }

        i = print(5545);

        System.out.println("new i = " + i);
        System.out.println("Hello World! by Nikita");
    }

    public static int print(int tmp){
        tmp += 10;
        return tmp;
    }
}
