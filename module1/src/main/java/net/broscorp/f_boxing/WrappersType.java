package net.broscorp.f_boxing;

class WrappersType {
    /*public static void main(String[] args) {
        typeComparisonInt(300, 300);
        typeComparisonIntEquals(300, 300);
    }*/

    static boolean typeComparisonInt(Integer a1, Integer a2) {
        System.out.print("a1 == a2 ? ");
        System.out.print("(" + a1.hashCode() + " = " + a2.hashCode()+ ")" + " - ");
        System.out.print(a1 == a2);

        return a1 == a2;
    }

    static boolean typeComparisonIntEquals(Integer a1, Integer a2) {
        System.out.print("a1.equals(a2) ? ");
        System.out.print("(" + a1.hashCode() + " = " + a2.hashCode()+ ")" + " - ");
        System.out.print(a1.equals(a2));
        return a1.equals(a2);
    }
}
