package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

    int firstPrimitiveNumber = 2;
    int secondPrimitiveNumber = 2;

    Integer firstNumber = Integer.valueOf(firstPrimitiveNumber);
    Integer secondNumber = Integer.valueOf(secondPrimitiveNumber);

    boolean isWrapperNumbersEqual = firstNumber == secondNumber;

    @Test
    void isWrappersEqual(){
        Assertions.assertTrue(isWrapperNumbersEqual);
    }

    @Test
    void boxingEqualing(){
        Assertions.assertEquals(firstNumber, secondNumber);
    }

}
