package net.broscorp.equals.hashcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class имитирует сущность Employee
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
@AllArgsConstructor
@Getter
public class Employee {
    private String name;
    private int age;
    private double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        if (!name.equals(employee.getName())) return false;
        if (age != employee.getAge()) return false;
        if (salary != employee.getSalary()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = name == null ? 31 : name.hashCode();
        int result = 31;
        result = prime * result + age;
        result = prime * result + (int) salary;
        return result;
    }

    @Override
    public String toString() {
        return "Employee name=" + name + ", age=" + age + ", salary=" + salary;
    }
}
