package net.broscorp.boxing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestWrapperType {

    public static void main(String[] args) {
        Integer i = new Integer(8);
        Integer y = new Integer(8);
        System.out.println(i.equals(y));
    }

    /**
     * Операция сравнения "==" для ссылочных типов сравнивает ссылку на объект в Heap, и т.к. переменные firstValue и secondValue
     * были созданы с помощью ключевого слова new, то в Heap под каждую переменную было выделено память, т.е. ссылки на память у них разные.
     */

    @Test
    public void equalsBetweenWrapperType(){
        Integer firstValue = new Integer(8);
        Integer secondValue = new Integer(8);
        assertFalse(firstValue == secondValue);
    }

    @Test
    public void equalsBetweenWrapperTypeBoxing(){
        Integer firstValue = 8;
        Integer secondValue = 8;
        assertTrue(firstValue == secondValue);
    }

    @Test
    public void equalsBetweenWrapperTypeUnboxing(){
        Integer firstValue = new Integer(8);
        Integer secondValue = new Integer(8);
        int firstUnboxingValue = firstValue;
        int secondUnboxingValue = secondValue;
        assertTrue(firstUnboxingValue == secondUnboxingValue);
    }

}
