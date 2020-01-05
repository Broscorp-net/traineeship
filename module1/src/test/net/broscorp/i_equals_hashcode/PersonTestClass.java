package net.broscorp.i_equals_hashcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTestClass {
    @Test
    void equalsReflexivenessTest() {
        Person alex = new Person("Alex", 22, 180);
        assertTrue(alex.equals(alex));
    }

    @Test
    void equalsSymmetricTest() {
        Person alex1 = new Person("Alex", 22, 180);
        Person alex2 = new Person("Alex", 22, 180);

        assertEquals(alex1.equals(alex2), alex2.equals(alex1));
    }

    @Test
    void equalsTransitivenessTest() {
        Person alex1 = new Person("Alex", 22, 180);
        Person alex2 = new Person("Alex", 22, 180);
        Person alex3 = new Person("Alex", 22, 180);
        assertTrue(alex1.equals(alex2));
        assertTrue(alex2.equals(alex3));
        assertTrue(alex1.equals(alex3));

    }

    @Test
    void equalsConsistencyTest() {
        Person alex1 = new Person("Alex", 22, 180);
        Person alex2 = new Person("Alex", 22, 180);
        for (int i = 0; i < 5; i++) {
            assertEquals(alex1.equals(alex2), alex2.equals(alex1));
        }

    }

    @Test
    void equalsNullTest() {
        Person alex1 = new Person("Alex", 22, 180);
        assertFalse(alex1.equals(null));
    }

    @Test
    void hashCodeConsistencyTest() {
        Person alex1 = new Person("Alex", 22, 180);
        Person alex2 = new Person("Alex", 22, 180);
        assertTrue(alex1.equals(alex2));
        assertTrue(alex1.hashCode() == alex2.hashCode());
    }

    @Test
    void hashCodeInternalConsistencyTest() {
        Person alex1 = new Person("Alex", 22, 180);
        Person alex2 = new Person("Alex2", 32, 170);
        assertFalse(alex1.equals(alex2));
        assertFalse(alex1.hashCode() == alex2.hashCode());
    }

    @Test
    void hashCodeCollisionsTest() {
        Map<Integer, Person> personMapCollision = new HashMap<>();
        int duplicatedHashCodes = 0;
        Random random = new Random(1_00_000);
        for (int i = 0; i < 1_00_000; i++) {
            Person person = new Person("Vasia", 22, random.nextInt(1_000_000));
            if (!personMapCollision.containsKey(person.hashCode())) {
                personMapCollision.put(person.hashCode(), person);
            } else {
                System.out.println(person.hashCode() + " this hashCode already exist");
                duplicatedHashCodes++;
            }
        }
        assertTrue(duplicatedHashCodes > 0);
    }
}
