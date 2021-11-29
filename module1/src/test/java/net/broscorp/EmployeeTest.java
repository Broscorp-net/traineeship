package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.equals.hashcode.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  void reflexiveTest() {
    Employee employeeOne = new Employee("John", 123);
    assertEquals(employeeOne, employeeOne);
  }

  @Test
  void symmetricTest() {
    Employee employeeOne = new Employee("John", 123);
    Employee employeeTwo = new Employee("John", 123);
    assertEquals(employeeOne, employeeTwo);
    assertEquals(employeeTwo, employeeOne);
  }

  @Test
  void transitiveTest() {
    Employee employeeOne = new Employee("John", 123);
    Employee employeeTwo = new Employee("John", 123);
    Employee employeeThree = new Employee("John", 123);
    assertTrue(employeeOne.equals(employeeTwo) & employeeTwo.equals(employeeThree)
            & employeeOne.equals(employeeThree));
  }

  @Test
  void consistentTest() {
    Employee employeeOne = new Employee("John", 123);
    Employee employeeTwo = new Employee("John", 123);
    assertTrue(employeeOne.equals(employeeTwo));
    assertTrue(employeeOne.equals(employeeTwo));
    assertTrue(employeeOne.equals(employeeTwo));
  }

  @Test
  void nonNullTest() {
    Employee employeeOne = new Employee("John", 123);
    assertFalse(employeeOne.equals(null));
  }

  @Test
  void hashCodeTest() {
    Employee employeeOne = new Employee("John", 123);
    Employee employeeTwo = new Employee("John", 123);
    assertEquals(employeeOne.hashCode(), employeeTwo.hashCode());
  }

  @Test
  void notEqualObjectsTest() {
    StringBuilder message = new StringBuilder();
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("John", 121));
    employees.add(new Employee("Nick", 122));
    employees.add(new Employee("Pole", 123));

    for (int i = 0; i < employees.size(); i++) {
      Employee current = employees.get(i);
      for (int j = 1; j < employees.size(); j++) {
        Employee next = employees.get(j);
        if (!current.equals(next) && current.hashCode() == next.hashCode()) {
          assertNotEquals(current, next);
          assertEquals(current.hashCode(), next.hashCode());

          message.append("Вот объект: ").append(current.getName())
                   .append("вот объект: ").append(next.getName())
                   .append(" они разные ").append("но их хеш сопадает ")
                   .append(current.hashCode()).append(" == ").append(next.hashCode());
          System.out.println(message);
        }
      }
    }
  }
}

