package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

    int firstPrimitiveNumber = 2;
    int secondPrimitiveNumber = 2;

    Integer firstNumber;
    Integer secondNumber;

    @Test
    void whenWrapperIsNotEqual(){
        firstNumber = new Integer(8);
        secondNumber = new Integer(8);
        Assertions.assertFalse(firstNumber == secondNumber);

    }

    @Test
    void isWrappersEqual(){
        firstNumber = Integer.valueOf(firstPrimitiveNumber);
        secondNumber = Integer.valueOf(secondPrimitiveNumber);
        Assertions.assertTrue(firstNumber == secondNumber);
    }

    @Test
    void boxingEqualing(){
        Assertions.assertEquals(firstNumber, secondNumber);
    }

}
