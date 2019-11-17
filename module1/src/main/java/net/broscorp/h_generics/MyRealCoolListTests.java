import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class MyRealCoolListTests {

    @Test
    public void addElementsWithValidTypes_whenExceptionDoesNotThrown_thenAssertionSucceeds() {

        MyRealCoolList<Byte> byteTester = new MyRealCoolList();
        Byte byteItem = 1;
        assertDoesNotThrow(() -> {
            byteTester.add(byteItem);
        }, "List can be parametrized with Byte");

        MyRealCoolList<Integer> intTester = new MyRealCoolList();
        Integer intItem = 10;
        assertDoesNotThrow(() -> {
            intTester.add(intItem);
        }, "List can be parametrized with Integer");

        MyRealCoolList<Long> longTester = new MyRealCoolList();
        Long longItem = 10l;
        assertDoesNotThrow(() -> {
            longTester.add(longItem);
        }, "List can be parametrized with Long");

        MyRealCoolList<Float> floatTester = new MyRealCoolList();
        Float floatItem = 10f;
        assertDoesNotThrow(() -> {
            floatTester.add(floatItem);
        }, "List can be parametrized with Float");

        MyRealCoolList<Double> doubleTester = new MyRealCoolList();
        Double doubleItem = 10d;
        assertDoesNotThrow(() -> {
            doubleTester.add(doubleItem);
        }, "List can be parametrized with Double");

        MyRealCoolList<Number> numberTester = new MyRealCoolList();
        Number numberItem = 10;
        assertDoesNotThrow(() -> {
            numberTester.add(numberItem);
        }, "List can be parametrized with Number");

    }

    @Test
    public void listSize() {
        MyRealCoolList<Integer> tester = new MyRealCoolList<>();

        Integer intItem = 3;
        tester.add(intItem);

        assertEquals(1, tester.size());
    }

    @Test
    public void getElement() {
        MyRealCoolList<Integer> tester = new MyRealCoolList<>();

        Integer intItem = 3;
        tester.add(intItem);

        assertEquals(intItem, tester.get(0));
    }

    @Test
    public void getElementWithInvalidIndex_whenExceptionThrown_thenAssertionSucceeds() {
        MyRealCoolList tester = new MyRealCoolList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tester.get(-1);
        }, "Attempt to get element must be followed by IndexOutOfBoundsException");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tester.get(0);
        }, "Attempt to get element must be followed by IndexOutOfBoundsException");
    }

    @Test
    public void removeElement() {
        MyRealCoolList<Integer> tester = new MyRealCoolList<>();

        Integer intItem = 3;
        tester.add(intItem);

        assertEquals(intItem, tester.remove(0));
    }

    @Test
    public void removeElementWithInvalidIndex_whenExceptionThrown_thenAssertionSucceeds() {
        MyRealCoolList tester = new MyRealCoolList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tester.remove(-1);
        }, "Attempt to remove element must be followed by IndexOutOfBoundsException");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tester.remove(0);
        }, "Attempt to remove element must be followed by IndexOutOfBoundsException");
    }

    @Test
    public void mapList() {
        MyRealCoolList<Long> tester = new MyRealCoolList<>();

        Long[] longItems = {1l, 2l, 3l};
        for(Long item : longItems) {
            tester.add(item);
        }

        Function<Long, Integer> f = x -> Math.toIntExact(x);
        MyRealCoolList<Integer> mappedList = (MyRealCoolList<Integer>) tester.map(f);

        for(int i = 0; i < mappedList.size(); i++) {
            assertEquals(new Integer(0).getClass(), mappedList.get(i).getClass());
        }
    }

}
