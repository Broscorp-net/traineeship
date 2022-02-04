package net.broscorp.bytecode;

/**
 * Class contains variable increment and greeting methods
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
public class Hello {

    // program entry point
    public static void main(String[] args) {
        final int variable = 10;
        final int loopSize = 20;

        incr(variable, loopSize);
        hello();

        //change();
    }

    /**
     * The method increases variable var loopSize times and outputs the result
     *
     * @param var      - variable to be incremented
     * @param loopSize - number of variable increments var
     */
    public static void incr(int var, int loopSize) {
        for (int i = 0; i < loopSize; i++) {
            var++;
        }
        System.out.println("Variable increased to " + var);
    }

    /**
     * The method outputs a string greeting
     */
    public static void hello() {
        System.out.println("Hello World !!!!!!!!!!!!!!");
    }

//    public static void change () {
//        System.out.println("Change code !!!");
//    }
}
