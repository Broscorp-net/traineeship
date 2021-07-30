package net.broscorp.equals.hashcode;

import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class StudentTest {

  @Test
  void testReflection() {
    Student s1 = new Student(1, "Oleg", "Collage");

    assertTrue(s1.equals(s1));
  }

  @Test
  void testSymmetric() {
    Student s1 = new Student(1, "Oleg", "Collage");
    Student s2 = new Student(1, "Oleg", "Collage");

    assertTrue(s1.equals(s2));
    assertTrue(s2.equals(s1));
  }

  @Test
  void testTransitive() {
    Student s1 = new Student(1, "Oleg", "Collage");
    Student s2 = new Student(1, "Oleg", "Collage");
    Student s3 = new Student(1, "Oleg", "Collage");

    assertTrue(s1.equals(s2));
    assertTrue(s2.equals(s3));
    assertTrue(s1.equals(s3));
  }

  @Test
  void testConsistent() {
    Student s1 = new Student(1, "Oleg", "Collage");
    Student s2 = new Student(1, "Oleg", "Collage");

    assertTrue(s1.equals(s2));

    s2.setCourse(2);

    assertFalse(s1.equals(s2));
  }

  @Test
  void testNotNull() {
    Student s1 = new Student(1, "Oleg", "Collage");
    Student s2 = null;

    assertFalse(s1.equals(s2));
  }

  @Test
  void hashSearch() {
    List<Student> list =
        Arrays.asList(
            new Student(1, "Viktor", "University"),
            new Student(3, "Aleksey", "School"),
            new Student(4, "Vitaliy", "University"),
            new Student(4, "Oleg", "Collage"),
            new Student(1, "Filipp", "University"),
            new Student(4, "Ivan", "Academy"));

    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        boolean hash = list.get(i).hashCode() == list.get(j).hashCode();
        boolean equals = list.get(i).equals(list.get(j));
        if (equals) {
          assertTrue(hash);
          assertTrue(equals);

        } else if (hash && !equals) {

          assertTrue(hash);
          assertFalse(equals);
        }
      }
    }
  }

  @Test
  void contractRules() {

    Student s1 = new Student(1, "Roma", "School");
    Student s2 = new Student(1, "Oleg", "School");

    // these students have the same hashcode
    assertTrue(s1.hashCode() == s2.hashCode());
    // but equals return false;
    assertFalse(s1.equals(s2));
  }
}
