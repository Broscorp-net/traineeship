import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SomeObjectTests {

    private SomeObject someObj1;
    private SomeObject someObj2;
    private SomeObject someObj3;

    @BeforeEach
    public void initTestObjects() {
        int id = 1;
        String name = "first";
        List<String> tags = new ArrayList<>(
                Arrays.asList(new String[]{"1", "1st", "first", "the first"}));

        someObj1 = new SomeObject(id, name, tags);
        someObj2 = new SomeObject(id, name, tags);
        someObj3 = new SomeObject(id, name, tags);
    }

    @Test
    public void equalsIsReflexive() {
        assertTrue(someObj1.equals(someObj1), "x.equals(x) should return true");
    }

    @Test
    public void equalsIsSymmetric() {
        assertTrue(someObj2.equals(someObj1) == true
                        && someObj1.equals(someObj2) == true,
                "x.equals(y) should return true if and only if y.equals(x) returns true");
    }

    @Test
    public void equalsIsTransitive() {
        assertTrue(someObj1.equals(someObj2)
                        == someObj2.equals(someObj3)
                        == someObj1.equals(someObj3),
                "x.equals(y) returns true and y.equals(z) returns true,"
                        + " then x.equals(z) should return true");
    }

    @Test
    public void equalsIsConsistent() {
        boolean isEqual = someObj1.equals(someObj2);
        for(int i = 0; i < 100; i++) {
            assertEquals(isEqual, someObj1.equals(someObj2),
                    "multiple invocations of x.equals(y)"
                    + "should consistently return true or consistently return false");
        }
    }

    @Test
    public void objectDoesNotEqualNull() {
        int id = 1;
        String name = "first";
        List<String> tags = new ArrayList<>(
                Arrays.asList(new String[]{"1", "1st", "first", "the first"}));

        SomeObject someObj1 = new SomeObject(id, name, tags);

        assertFalse(someObj1.equals(null), "x.equals(null) should return false");

    }


    @Test
    public void hashCodeEquals_whenObjectEquals() {
        assertTrue(someObj1.hashCode() == someObj2.hashCode(),
                "x and y hashCodes are equal if x.equals(y)");
    }

    @Test
    public void hashCodeIsConsistent() {
        int hashCode = someObj1.hashCode();
        for(int i = 0; i < 100; i++) {
            assertEquals(hashCode, someObj1.hashCode(),
                    "multiple invocations of x.hashCode()"
                            + "should consistently return true or consistently return false");
        }
    }

    @Test
    public void whenHasNoHashCodeCollisions_thenAssertionSucceeds() {
        HashSet<SomeObject> someObjHashSet = new HashSet<>();
        Map<Integer, List<SomeObject>> hashCodes = new HashMap<>();

        Random rand = new Random();
        for(int i = 0; i < 100; i++) {
            SomeObject someObj = new SomeObject(
                    rand.nextInt(),
                    "name_" + i,
                    new ArrayList<>());
            someObjHashSet.add(someObj);

            if(!hashCodes.containsKey(someObj.hashCode())) {
                hashCodes.put(someObj.hashCode(), new ArrayList<>());
            }

            hashCodes.get(someObj.hashCode())
                    .add(someObj);
        }

        assertTrue(hashCodes.size() == someObjHashSet.size());

    }

}
