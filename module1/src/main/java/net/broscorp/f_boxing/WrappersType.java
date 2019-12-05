package net.broscorp.f_boxing;

class WrappersType {
    /*public static void main(String[] args) {
        typeComparisonInt(300, 300);
        typeComparisonIntEquals(300, 300);
        explicitBoxing(400, 400);
        explicitUnboxing(250, 250);
    }*/

    static boolean typeComparisonInt(int a1, int a2) {
        Integer i1 = a1;
        Integer i2 = a2;
        System.out.print("a1 == a2 ? ");
        System.out.print("(" + i1.hashCode() + " = " + i2.hashCode()+ ")" + " - ");
        System.out.println(i1 == i2);
        return i1 == i2;
    }

    static boolean typeComparisonIntEquals(int a1, int a2) {
        Integer i1 = a1;
        Integer i2 = a2;
        System.out.print("a1.equals(a2) ? ");
        System.out.print("(" + i1.hashCode() + " = " + i2.hashCode()+ ")" + " - ");
        System.out.println(i1.equals(i2));
        return i1.equals(i2);
    }

    static boolean explicitBoxing(int a, int b) {
        Integer i1 = new Integer(a);
        Integer i2 = new Integer(b);
        System.out.println(i1 == i2);
        return i1 == i2;
    }

    static boolean explicitUnboxing(Integer a, Integer b) {
        int i1 = a.intValue();
        int i2 = a.intValue();
        System.out.println(i1 == i2);
        return i1 == i2;
    }
}
