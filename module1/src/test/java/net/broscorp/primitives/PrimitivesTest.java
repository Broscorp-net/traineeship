package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void overflowNumericType() {
    System.out.println("overflow integer max val through exp = >" + Integer.MAX_VALUE);
    ArithmeticException arithmeticException =
        Assertions.assertThrows(ArithmeticException.class, () -> {
          System.out.println("overflow int = >" + Math.incrementExact(Integer.MAX_VALUE));
          throw new ArithmeticException();
        });
    Assertions.assertEquals("integer overflow", arithmeticException.getMessage());
  }

//  *	конвертация между примитивными типами: __long__ в __int__, __float__ в __double__, показать какие могут возникать проблемы;
  @Test
  void convertingLongInt(){
    System.out.println("intMaxNumber = " + Integer.MAX_VALUE);
    System.out.println("longMaxNumber = " + Long.MAX_VALUE);
    int number = (int) Long.MAX_VALUE;
    System.out.println("number after cast Long.MAX_VALUE = " + number);
//    sout: number = -1 -- in this case we have overflow and lose integer values

//    another example
    long longNumber = Integer.MAX_VALUE + 100136564;
    int overflowNumber = (int) longNumber;
    System.out.println("overflowNumber = " + overflowNumber);

  }

  @Test
  void convertingFloatDouble(){
    System.out.println("maxFloatNumber = " + Float.MAX_VALUE);
    System.out.println("maxDoubleNumber = " + Double.MAX_VALUE);
    float number = (float) Double.MAX_VALUE / (Integer.MAX_VALUE);
    if (number == Float.POSITIVE_INFINITY){
      System.out.println("number after cast Long.MAX_VALUE = " + number);
    }
//  when worked is largest primitive date and then cast them
//  we can get infinity for float type, or lose precision
  }

  @Test
  void precisionInDouble(){
//    unit of least precision – ULP
//    for float 6-7 digits : 0.0000001
//    for double - 15-15 digits

    double doubleTest = 2.0d - 1.1d;
    System.out.println("doubleTest = " + doubleTest);
    //    in this doubleTest = 0.8999999999999999 get some confused situation
    //    caused about that how natural number in binary system represented by binary code
    float floatTest = 22.50f - 15.13f;
    System.out.println("doubleTest = " + floatTest);

  }
}
