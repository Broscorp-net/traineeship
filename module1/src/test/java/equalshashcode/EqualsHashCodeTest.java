package equalshashcode;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.equals.hashcode.ProgrammingLanguages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class EqualsHashCodeTest {

  private static ProgrammingLanguages java;
  private static ProgrammingLanguages python;
  private static ProgrammingLanguages javaScript;
  private static ProgrammingLanguages java1;
  private static ProgrammingLanguages java2;

  /** Using javadoc method.
   *
   */
  @BeforeAll
  public static void init() {
    java = new ProgrammingLanguages("Java",1990);
    python = new ProgrammingLanguages("Python",1980);
    javaScript = new ProgrammingLanguages("JavaScript",1996);
    java1 = new ProgrammingLanguages("Java",1990);
    java2 = new ProgrammingLanguages("Java",1990);

  }

  @Test
  public void objectsWithDifferentReferencesShouldNotBeEqual() {
    Assertions.assertNotEquals(true, java.equals(javaScript));
  }

  @Test
  public void equalReflexive() {
    Assertions.assertEquals(true, java.equals(java));
  }

  @Test
  public void equalSymmetry() {
    Assertions.assertEquals(java1.equals(java), java.equals(java1));
  }

  @Test
  public void  equalsTransitivity() {
    if (java.equals(java1) && java1.equals(java2)) {
      Assertions.assertEquals(true, java2.equals(java));
    }
  }

  @Test
  public void equalsConsistency() {
    Assertions.assertEquals(true, java.equals(java1));
    Assertions.assertEquals(true,java.equals(java1));
    java1.setNameOfProgrLanguage("Realised Java");
    java1.setYearOfDevelopmentOfThisLanguage(1996);
    Assertions.assertEquals(false,java.equals(java1));
    Assertions.assertNotEquals(true, java.equals(java1));
  }

  @Test
  public void equalsNullComparison() {
    Assertions.assertEquals(false, python.equals(null));
  }

  @Test
  public void hashcodeOnTheSameObjectSeveralTimesShouldReturnTheSameNumber() {
    Assertions.assertEquals(71355403,java.hashCode());
    Assertions.assertEquals(71355403,java.hashCode());
  }

  @Test
  public void objectsThatAreEqualShouldHaveTheSameHashcode() {
    Assertions.assertEquals(true,java2.hashCode() == java.hashCode());
  }

  @Test
  public void objectsThatAreNotEqualByEqualsMethodShouldHaveDifferentHashcode() {
    Assertions.assertNotEquals(true, java.hashCode() == python.hashCode());
  }

  @Test
  public void notEqualObjectsHasTheSameHashcode() {
    List<ProgrammingLanguages> programmingLanguages = new ArrayList<>();

    programmingLanguages.add(java);
    programmingLanguages.add(java1);
    programmingLanguages.add(java2);
    programmingLanguages.add(javaScript);
    programmingLanguages.add(python);

    for (int i = 0; i < programmingLanguages.size() - 1; i++) {

      if (!(programmingLanguages.get(i).equals(programmingLanguages.get(i + 1)))

                        && programmingLanguages.get(i).hashCode()
              == programmingLanguages.get(i + 1).hashCode()) {

        System.out.println("Вот объект " + programmingLanguages.get(i)
                + ", вот объект "
                + programmingLanguages.get(i + 1)
                + ", они разные, но их хеш сопадает.");

        Assertions.assertTrue(programmingLanguages.get(i).hashCode()
                ==
                programmingLanguages.get(i + 1).hashCode());
      }
    }
  }

}
