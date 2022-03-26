package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CatTest {

  private final Cat catX = new Cat("Xerox","Sphinx",3,5);
  private final Cat catY = new Cat("Xerox","Sphinx",3,5);
  private final Cat catZ = new Cat("Xerox","Sphinx",3,5);
  private final Cat catA = new Cat("Tom", "Bombaz", 2, 6);
  private final Cat catB = new Cat("Tob", "Bombay", 10600, 130);

  @Test
  public void shouldBeReflexive() {
    assertTrue(catX.equals(catX));
  }

  @Test
  public void shouldBeSymmetric() {
    assertTrue(catX.equals(catY));
    assertTrue(catY.equals(catX));
  }

  @Test
  public void shouldBeTransitive() {
    assertTrue(catX.equals(catY));
    assertTrue(catY.equals(catZ));
    assertTrue(catX.equals(catZ));
  }

  @Test
  public void shouldBeConsistent() {
    assertTrue(catX.equals(catY));
    assertTrue(catX.equals(catY));
    assertTrue(catX.equals(catY));

    assertFalse(catX.equals(catA));
    assertFalse(catX.equals(catA));
    assertFalse(catX.equals(catA));
  }

  @Test
  public void shouldReturnFalseWhenPassingNull() {
    assertFalse(catX.equals(null));
  }

  @Test
  public void shouldBeSameWhenExecutingOnSameObject() {
    int expected = catX.hashCode();
    int actual = catX.hashCode();

    assertEquals(expected, actual);
  }

  @Test
  public void shouldBeSameWhenExecutingOnEqualObjects() {
    int expected = catX.hashCode();
    int actual = catY.hashCode();

    assertEquals(catX, catY);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldBeNotEqualWhenExecutingForDifferentObjectsInMostCases() {
    int expected = catX.hashCode();
    int actual = catA.hashCode();

    assertNotEquals(expected, actual);
  }

  @Test
  public void shouldBeEqualWhenExecutingForDifferentObjectsInSomeCases() {
    int expected = catB.hashCode();
    int actual = catA.hashCode();

    assertEquals(expected, actual);
  }


}