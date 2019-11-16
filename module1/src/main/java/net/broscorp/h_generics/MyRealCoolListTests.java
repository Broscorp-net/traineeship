import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class MyRealCoolListTests {

    @Test
    public void addElementsWithValidTypes_whenExceptionDoesNotThrown_thenAssertionSucceeds() {
        MyRealCoolList tester = new MyRealCoolList();

        Byte byteItem = 1;
        assertDoesNotThrow(() -> {
            tester.add(byteItem);
        }, "List can be parametrized with Byte");

        Integer intItem = 10;
        assertDoesNotThrow(() -> {
            tester.add(intItem);
        }, "List can be parametrized with Integer");

        Long longItem = 10l;
        assertDoesNotThrow(() -> {
            tester.add(longItem);
        }, "List can be parametrized with Long");

        Float floatItem = 10f;
        assertDoesNotThrow(() -> {
            tester.add(floatItem);
        }, "List can be parametrized with Float");

        Double doubleItem = 10d;
        assertDoesNotThrow(() -> {
            tester.add(doubleItem);
        }, "List can be parametrized with Double");

        Number numberItem = 10;
        assertDoesNotThrow(() -> {
            tester.add(numberItem);
        }, "List can be parametrized with Number");

    }

    @Test
    public void addElementsWithInvalidTypes_whenExceptionThrown_thenAssertionSucceeds() {
        MyRealCoolList tester = new MyRealCoolList();

        Boolean booleanItem = Boolean.TRUE;
        assertThrows(ClassCastException.class, () -> {
            tester.add(booleanItem);
        }, "List cannot be parametrized with Boolean");

        Character charItem = 'a';
        assertThrows(ClassCastException.class, () -> {
            tester.add(charItem);
        }, "List cannot be parametrized with Character");

        String stringItem = "abcdefg";
        assertThrows(ClassCastException.class, () -> {
            tester.add(stringItem);
        }, "List cannot be parametrized with String");

        Collection collectionItem = new ArrayList<>();
        assertThrows(ClassCastException.class, () -> {
            tester.add(collectionItem);
        }, "List cannot be parametrized with Collection");

        Object objectItem = new ArrayList<ArrayList<Integer>>();
        assertThrows(ClassCastException.class, () -> {
            tester.add(objectItem);
        }, "List cannot be parametrized with Object");

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
