package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EqualsHashcodeTest {

  private List<Cat> cats;

  @BeforeEach
  void setUp() {
    cats = new ArrayList<>();
    Cat homeCat = new Cat("Murka", 2, 3);
    Cat wildCat = new Cat("Barsic", 5, 5);
    Cat fatCat = new Cat("Tishka", 3, 15);
    Cat lazyCat = new Cat("Bris", 7, 5);
    Cat twinCat = new Cat("Murka", 2, 3);
    Cat tripletCat = new Cat("Murka", 2, 3);

    Cat cat1 = new Cat("AaAaAa", 0, 0);
    Cat cat2 = new Cat("AaAaBB", 0, 0);
    Cat cat3 = new Cat("AaBBAa", 0, 0);
    Cat cat4 = new Cat("AaBBBB", 0, 0);
    Cat cat5 = new Cat("BBAaAa", 0, 0);
    Cat cat6 = new Cat("BBAaBB", 0, 0);
    Cat cat7 = new Cat("BBBBAa", 0, 0);
    Cat cat8 = new Cat("BBBBBB", 0, 0);


    cats.add(homeCat);
    cats.add(wildCat);
    cats.add(fatCat);
    cats.add(lazyCat);
    cats.add(twinCat);
    cats.add(tripletCat);

    cats.add(cat1);
    cats.add(cat2);
    cats.add(cat3);
    cats.add(cat4);
    cats.add(cat5);
    cats.add(cat6);
    cats.add(cat7);
    cats.add(cat8);


  }

  @AfterEach
  void tearDown() {
  }

  @Test
  @DisplayName("Should get false if null")
  public void shouldGetFalseIfNull() {

    assertFalse(cats.get(0).equals(null));
    assertFalse(cats.get(1).equals(null));
    assertFalse(cats.get(2).equals(null));
    assertFalse(cats.get(3).equals(null));
    assertFalse(cats.get(4).equals(null));
    assertFalse(cats.get(5).equals(null));

  }

  @Test
  @DisplayName("Should get true in reflexive")
  public void shouldGetTrueInReflexive() {

    assertTrue(cats.get(0).equals(cats.get(0)));
    assertTrue(cats.get(1).equals(cats.get(1)));
    assertTrue(cats.get(2).equals(cats.get(2)));
    assertTrue(cats.get(3).equals(cats.get(3)));
    assertTrue(cats.get(4).equals(cats.get(4)));
    assertTrue(cats.get(5).equals(cats.get(5)));

  }

  @Test
  @DisplayName("Should get true in symmetric")
  public void shouldGetTrueInSymmetric() {

    assertTrue(cats.get(0).equals(cats.get(4)));
    assertTrue(cats.get(4).equals(cats.get(0)));

    assertTrue(cats.get(0).equals(cats.get(5)));
    assertTrue(cats.get(5).equals(cats.get(0)));

    assertTrue(cats.get(4).equals(cats.get(5)));
    assertTrue(cats.get(5).equals(cats.get(4)));

  }

  @Test
  @DisplayName("Should get false in symmetric")
  public void shouldGetFalseInSymmetric() {

    assertFalse(cats.get(0).equals(cats.get(1)));
    assertFalse(cats.get(1).equals(cats.get(0)));

    assertFalse(cats.get(0).equals(cats.get(2)));
    assertFalse(cats.get(2).equals(cats.get(0)));

    assertFalse(cats.get(0).equals(cats.get(3)));
    assertFalse(cats.get(3).equals(cats.get(0)));

    assertFalse(cats.get(1).equals(cats.get(2)));
    assertFalse(cats.get(2).equals(cats.get(1)));

    assertFalse(cats.get(1).equals(cats.get(3)));
    assertFalse(cats.get(3).equals(cats.get(1)));

    assertFalse(cats.get(2).equals(cats.get(3)));
    assertFalse(cats.get(3).equals(cats.get(2)));

  }


  @Test
  @DisplayName("Should get true in transitive")
  public void shouldGetTrueInTransitive() {

    assertTrue(cats.get(0).equals(cats.get(4)));
    assertTrue(cats.get(4).equals(cats.get(5)));
    assertTrue(cats.get(0).equals(cats.get(5)));

  }

  @Test
  @DisplayName("Should get false in transitive")
  public void shouldGetFalseInTransitive() {

    assertFalse(cats.get(0).equals(cats.get(1)));
    assertFalse(cats.get(1).equals(cats.get(2)));
    assertFalse(cats.get(0).equals(cats.get(2)));

    assertFalse(cats.get(2).equals(cats.get(3)));
    assertFalse(cats.get(3).equals(cats.get(4)));
    assertFalse(cats.get(2).equals(cats.get(4)));

    assertFalse(cats.get(1).equals(cats.get(3)));
    assertFalse(cats.get(3).equals(cats.get(5)));
    assertFalse(cats.get(1).equals(cats.get(5)));

  }

  @Test
  @DisplayName("Should get true in consistent")
  public void shouldGetTrueInConsistent() {

    assertTrue(cats.get(0).equals(cats.get(4)));
    assertTrue(cats.get(0).equals(cats.get(4)));
    assertTrue(cats.get(0).equals(cats.get(4)));

    assertTrue(cats.get(0).equals(cats.get(5)));
    assertTrue(cats.get(0).equals(cats.get(5)));
    assertTrue(cats.get(0).equals(cats.get(5)));

    assertTrue(cats.get(4).equals(cats.get(5)));
    assertTrue(cats.get(4).equals(cats.get(5)));
    assertTrue(cats.get(4).equals(cats.get(5)));

  }


  @Test
  @DisplayName("Should get false in consistent")
  public void shouldGetFalseInConsistent() {

    assertFalse(cats.get(0).equals(cats.get(2)));
    assertFalse(cats.get(0).equals(cats.get(2)));
    assertFalse(cats.get(0).equals(cats.get(2)));

    assertFalse(cats.get(1).equals(cats.get(3)));
    assertFalse(cats.get(1).equals(cats.get(3)));
    assertFalse(cats.get(1).equals(cats.get(3)));

    assertFalse(cats.get(3).equals(cats.get(5)));
    assertFalse(cats.get(3).equals(cats.get(5)));
    assertFalse(cats.get(3).equals(cats.get(5)));

  }


  @Test
  @DisplayName("Should get equals hashcode in internal consistency")
  public void shouldGetEqualsHashCodeNoChange() {
    int expected;
    int actual;

    expected = cats.get(0).hashCode();

    actual = cats.get(0).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(0).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(0).hashCode();
    assertEquals(expected, actual);

    expected = cats.get(1).hashCode();

    actual = cats.get(1).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(1).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(1).hashCode();
    assertEquals(expected, actual);

    expected = cats.get(2).hashCode();

    actual = cats.get(2).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(2).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(2).hashCode();
    assertEquals(expected, actual);

    expected = cats.get(3).hashCode();

    actual = cats.get(3).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(3).hashCode();
    assertEquals(expected, actual);
    actual = cats.get(3).hashCode();
    assertEquals(expected, actual);

  }

  @Test
  @DisplayName("Should get equals hashcode in objects equals consistency")
  public void shouldGetEqualsHashCodeIfEqualsObjects() {

    assertEquals(cats.get(0), cats.get(4));
    assertEquals(cats.get(0).hashCode(), cats.get(4).hashCode());

    assertEquals(cats.get(0), cats.get(5));
    assertEquals(cats.get(0).hashCode(), cats.get(5).hashCode());

    assertEquals(cats.get(4), cats.get(5));
    assertEquals(cats.get(4).hashCode(), cats.get(5).hashCode());
  }

  @Test
  @DisplayName("Should get not equals hashcode in objects not equals consistency")
  public void shouldGetNotEqualsHashCodeIfNotEqualsObjects() {

    assertNotEquals(cats.get(0), cats.get(1));
    assertNotEquals(cats.get(0).hashCode(), cats.get(1).hashCode());

    assertNotEquals(cats.get(0), cats.get(2));
    assertNotEquals(cats.get(0).hashCode(), cats.get(2).hashCode());

    assertNotEquals(cats.get(2), cats.get(3));
    assertNotEquals(cats.get(2).hashCode(), cats.get(3).hashCode());

    assertNotEquals(cats.get(3), cats.get(4));
    assertNotEquals(cats.get(3).hashCode(), cats.get(4).hashCode());

    assertNotEquals(cats.get(3), cats.get(5));
    assertNotEquals(cats.get(3).hashCode(), cats.get(5).hashCode());

  }

  /*
   * Объекты Cat в списке List<Cat> с 6 по 13 не равны между собой, но их hashcode - равны.
   */
  @Test
  @DisplayName("Should get equals hashcode but various objects in collisions")
  public void shouldGetEqualsHashCodeButVariousObjects() {

    assertNotEquals(cats.get(6), cats.get(7));
    assertEquals(cats.get(6).hashCode(), cats.get(7).hashCode());

    assertNotEquals(cats.get(7), cats.get(8));
    assertEquals(cats.get(7).hashCode(), cats.get(8).hashCode());

    assertNotEquals(cats.get(8), cats.get(9));
    assertEquals(cats.get(8).hashCode(), cats.get(9).hashCode());

    assertNotEquals(cats.get(9), cats.get(10));
    assertEquals(cats.get(9).hashCode(), cats.get(10).hashCode());

    assertNotEquals(cats.get(12), cats.get(13));
    assertEquals(cats.get(12).hashCode(), cats.get(13).hashCode());

  }

  @Test
  @DisplayName("Should get objects with equals hashcode")
  public void shouldGetObjectsWithEqualsHashCode() {
    int hashCode = cats.get(0).hashCode();
    List<Cat> catList = cats.stream().filter(cat -> cat.hashCode() == hashCode)
        .collect(Collectors.toList());
    assertTrue(catList.size() > 1);
  }

}