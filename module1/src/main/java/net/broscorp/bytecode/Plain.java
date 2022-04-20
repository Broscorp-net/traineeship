package net.broscorp.bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plain {

  /**
   * Plain class with plain methods.
   * @author Aziz Abdukarimov
   */
  public static void main(String[] args) {
    int intNumber = 45;
    for (int variable = 0; variable < 55; variable++) {
      intNumber++;
    }
    System.out.println("Hello trainee guys!");
    numberPrint(intNumber);
    List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 56, 1234, 56, 134, 321));
    System.out.println("integerList = " + integerList);
  }

  public static void numberPrint(int number) {
    System.out.println("That number: " + number);
  }
}
