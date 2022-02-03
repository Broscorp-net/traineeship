package net.broscorp.equals.hashcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class содержит методы для тестирования класса {@link Employee}
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
class EmployeeTest {
    private static List<Employee> employees;

    @BeforeAll
    private static void init() {
        employees = new ArrayList<>();
        employees.add(new Employee("Viktor", 21, 1500.0));
        employees.add(new Employee("Viktor", 21, 1500.0));
        employees.add(new Employee("Viktor", 21, 1500.0));
        employees.add(new Employee("Viktor", 22, 1500.0));
        employees.add(new Employee("Viktor", 29, 1500.0));
        employees.add(new Employee("Viktor", 26, 1600.0));
        employees.add(new Employee("pollinating sandboxes", 20, 1600.0));
        employees.add(new Employee("grinnerslaphappier.org", 20, 1600.0));
    }

    @Test
    void testToString() {
        String expected = "Employee name=Viktor, age=21, salary=1500.0";
        String actual = employees.get(0).toString();
        assertEquals(expected, actual);
    }

    @Test
    void testEqualsReflection() {
        assertEquals(true, employees.get(0).equals(employees.get(0)));
    }

    @Test
    void testEqualsSymmetry() {
        assertEquals(true, employees.get(0).equals(employees.get(1)));
        assertEquals(true, employees.get(1).equals(employees.get(0)));
    }

    @Test
    void testEqualsTransitive() {
        assertEquals(true, employees.get(0).equals(employees.get(1)));
        assertEquals(true, employees.get(1).equals(employees.get(2)));
        assertEquals(true, employees.get(0).equals(employees.get(2)));
    }

    @Test
    void testEqualsConsistently() {
        assertEquals(true, employees.get(0).equals(employees.get(1)));
        assertEquals(true, employees.get(0).equals(employees.get(1)));
        assertEquals(true, employees.get(0).equals(employees.get(1)));
    }

    @Test
    void testEqualsNull() {
        assertEquals(false, employees.get(0).equals(null));
    }

    @Test
    void testHashCodeEqualsCode() {
        int expected = employees.get(0).hashCode();
        for (int i = 0; i < 5; i++) {
            assertEquals(expected, employees.get(0).hashCode());
        }
    }

    @Test
    void testHashCodeEqualsObject() {
        int hash1 = employees.get(0).hashCode();
        int hash2 = employees.get(1).hashCode();

        assertEquals(true, employees.get(0).equals(employees.get(1)));
        assertEquals(true, hash1 == hash2);
    }

    @Test
    void testHashCodeNotEqualsObject() {
        int hash1 = employees.get(0).hashCode();
        int hash2 = employees.get(5).hashCode();

        assertEquals(false, employees.get(0).equals(employees.get(5)));
        assertEquals(false, hash1 == hash2);
    }

    @Test
    void testNotEqualsObjectButEqualsHashCode() {
        Employee employee1 = employees.get(6);
        Employee employee2 = employees.get(7);

        assertEquals(false, employee1.equals(employee2));
        assertEquals(true, (employee1.hashCode() == employee2.hashCode()));
    }

    @Test
    void testLoopFindEqualsObjectHashCode() {
        int findObjectHashCode = employees.get(0).hashCode();
        int counter = 0;
        int expected = 3;

        for (Employee employee : employees) {
            if (employee.hashCode() == findObjectHashCode) {
                counter++;
            }
        }
        assertEquals(expected, counter);
    }

    @Test
    void testNotEqualsButEqualsHasCode() {
        Employee employee1 = employees.get(6);
        Employee employee2 = employees.get(7);
        System.out.println("Вот объект А " + employee1);
        System.out.println("вот объект В " + employee2);
        System.out.println("они разные, но их хеш сопадает ");
        System.out.println("HashCode object A= " + employee1.hashCode());
        System.out.println("HashCode object B= " + employee2.hashCode());
        System.out.println("Сравнение HashCode " + (employee1.hashCode() == employee2.hashCode()));
        System.out.println("Сравнение по equals " + (employee1.equals(employee2)));
    }

}