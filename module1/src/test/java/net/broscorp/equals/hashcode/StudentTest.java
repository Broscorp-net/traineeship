package net.broscorp.equals.hashcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testContract() {

        Student student1 = new Student(1, "Petya", "University");
        Student student2 = new Student(2, "Vasya", "Collage");
        Student student3 = new Student(1, "Petya", "University");

        assertEquals(student1, student3);

        assertNotEquals(student1, student2);

        assertNotSame(student1, student3);

        int hash = student1.hashCode();

        assertEquals(hash, student3.hashCode());

    }

    @Test
    void hashSearch() {
        List<Student> list = new ArrayList<Student>();
        Student s1 = new Student(1, "Viktor", "University");
        Student s2 = new Student(3, "Aleksey", "School");
        Student s3 = new Student(4, "Vitaliy", "University");
        Student s4 = new Student(2, "Oleg", "Collage");
        Student s5 = new Student(1, "Filip", "University");
        Student s6 = new Student(4, "Ivan", "Academy");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);


        List<Student> chekList = Search.search(list, list.get(0).hashCode());

        assertEquals(list.get(0), chekList.get(0));
        assertEquals(list.get(4), chekList.get(1));
    }

    @Test
    void contractRules(){

        Student s1 = new Student(1, "Roma", "School");
        Student s2 = new Student(1, "Oleg", "School");

        //these students have the same hashcode
        assertEquals(s1.hashCode(), s2.hashCode());
        // but equals return false;
        assertNotEquals(s1, s2);

    }


}
