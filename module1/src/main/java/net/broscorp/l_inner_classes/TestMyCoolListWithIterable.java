package net.broscorp.l_inner_classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyCoolListWithIterable {

    private Function <Integer, Double> intToDouble = integer -> integer.doubleValue();
    private MyCoolList<Integer> integerList = new MyCoolList<>(0);

    @BeforeEach
    public void init(){
        integerList.add(12);
    }

    @Test
    public void addToList(){
        integerList.add(47);
        int expectedSize = 2;
        assertEquals(expectedSize, integerList.size());
    }

    @Test
    public void removeFromList(){
        integerList.add(41);
        integerList.remove(0);
        int expectedSize = 1;
        assertEquals(expectedSize, integerList.size());
    }

    @Test
    public void getElementByIndexFromList(){
        assertEquals(12, integerList.get(0));
    }

    @Test
    public void getSizeFromList(){
        integerList.add(18);
        integerList.add(116);
        integerList.add(1144);
        assertEquals(4, integerList.size());
    }

    @Test
    public void mapFromIntegerToDoubleList(){
        integerList.add(78);
        integerList.add(8);
        integerList.add(38);
        MyCoolList<Double> doubleList = integerList.map(intToDouble);
        System.out.println(doubleList.showList());
        String expectedArray = "[12.0, 78.0, 8.0, 38.0]";
        assertEquals(expectedArray, doubleList.showList());
    }

    @Test
    public void testMyIterable(){
        integerList.add(78);
        integerList.add(29);
        integerList.add(11);
        integerList.add(78);
        MyCoolList<Integer>.ArrayIterable iterable = integerList.new ArrayIterable();
        while (iterable.iterator().hasNext()){
            System.out.print(iterable.iterator().next() + " ");
        }
    }

}
