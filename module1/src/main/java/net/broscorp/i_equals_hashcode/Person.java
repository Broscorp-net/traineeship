package net.broscorp.i_equals_hashcode;

import java.util.Objects;

public class Person {

    private String name;
    private String lastName;
    private String yearsOld;

    public Person(String name, String lastName, String yearsOld) {
        this.name = name;
        this.lastName = lastName;
        this.yearsOld = yearsOld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(yearsOld, person.yearsOld);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Person - " + name;
    }
}
