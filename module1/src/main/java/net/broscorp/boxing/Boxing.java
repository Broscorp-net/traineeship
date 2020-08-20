package net.broscorp.boxing;

public class Boxing {

  public static void main(String[] args) {
    Integer a = 4;
    Integer b = new Integer(4);

    System.out.println(a == b);

    System.out.println(a.equals(b));
  }
}
