package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  public void equalsStudentsTest() {
    Student student1 = new Student(1L, "Ivan", 22);
    Student student2 = new Student(1L, "Ivan", 22);
    Assertions.assertEquals(student1, student2);
  }

  @Test
  public void notEqualsStudentsTest() {
    Student student1 = new Student(1L, "Ivan", 22);
    Student student2 = new Student(2L, "Petr", 33);
    Assertions.assertNotEquals(student1, student2);
  }

  @Test
  public void hashCodeStudentsTest() {
    Student student1 = new Student(1L, "Ivan", 22);
    Student student2 = new Student(1L, "Ivan", 22);
    Assertions.assertEquals(student1.hashCode(), student2.hashCode());
  }

  @Test
  public void notHashCodeStudentsTest() {
    Student student1 = new Student(1L, "Ivan", 22);
    Student student2 = new Student(2L, "Petr", 33);
    Assertions.assertNotEquals(student1.hashCode(), student2.hashCode());
  }

  @Test
  public void findSameHashCodeStudentsTest() {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1L, "Ivan", 22));
    students.add(new Student(1L, "Ivaa", 425));
    students.add(new Student(1L, "IvaN", 1014));
    students.add(new Student(1L, "Ivam", 53));

    boolean[] check = new boolean[students.size()];

    for (int i = 0; i < students.size(); i++) {
      if (check[i]) {
        continue;
      }
      Student student = students.get(i);
      for (int j = i + 1; j < students.size(); j++) {
        Student student1 = students.get(j);
        if (!student.equals(student1)) {
          if (student.hashCode() == student1.hashCode()) {
            System.out.print("student = " + student + " not equals ");
            System.out.println("student1 = " + student1);
            System.out.println(
                "but has same hasCode " + student.hashCode() + " == " + student1.hashCode());
            System.out.println();
            check[j] = true;
          }
        }
      }
    }
  }
}