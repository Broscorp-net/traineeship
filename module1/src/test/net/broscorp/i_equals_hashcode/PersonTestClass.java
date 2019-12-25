package net.broscorp.i_equals_hashcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
<<<<<<< HEAD
        Map<Integer, Person> personMapCollision = new HashMap<>();
        for (int i = 0; i < 2147; i++) {
            Person person = new Person("Vasia", i, i);
            if (person.hashCode() == person.hashCode()) personMapCollision.put(i, person);
            System.out.println("Person A has hashCode: " + personMapCollision.get(i).hashCode());
            System.out.println("Person B has hashCode: " + personMapCollision.get(i).hashCode());
=======
        Map<Integer, Person> personMap = new HashMap<>();
        Map<Integer, Person> personMapCollision = new HashMap<>();
        for (int i = 0; i < 2147; i++) {
            Person person = new Person("Vasia", i, i);
            if (person.hashCode() != person.hashCode()) personMap.put(i, person);
            else if (person.hashCode() == person.hashCode()) personMapCollision.put(i, person);
>>>>>>> 5f0b776... i_equals_hashcode commit
        }
        assertTrue(personMapCollision.size() > 0);
    }
}
