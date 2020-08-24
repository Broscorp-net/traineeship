package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatInvariantTest {

  List<Cat> cats;

  @BeforeEach
  void setUp() {
    cats = new ArrayList<>();
    cats.add(new Cat(1,2,"Marsik"));
    cats.add(new Cat(1,2,"Marsik"));
    cats.add(new Cat(1,2,"Marsik"));
  }

  @Test
  void equalsNewCatTest() {
    Cat cat = new Cat(1,2,"Marsik");

    assertEquals(cats.get(0), cat);
  }

  @Test
  void equalsNullTest() {
    Cat cat = cats.get(2);

    assertNotEquals(cat, null);
  }

  @Test
  void equalsTwoCatsTest() {
    Cat firstCat = cats.get(0);
    Cat lastCat = cats.get(2);

    assertTrue(firstCat.equals(lastCat) && lastCat.equals(firstCat));
  }

  @Test
  void notEqualsTwoCatsTest() {
    Cat firstCat = cats.get(0);
    Cat lastCat = cats.get(2);

    lastCat.setAge(20);

    assertFalse(firstCat.equals(lastCat) && lastCat.equals(firstCat));
  }


  @Test
  void equalsBetweenAllCatsTest() {
    Cat firstCat = cats.get(0);
    Cat secondCat = cats.get(1);
    Cat thirdCat = cats.get(2);

    assertTrue(firstCat.equals(secondCat) && secondCat.equals(firstCat)
            && secondCat.equals(thirdCat) && thirdCat.equals(firstCat));
  }

  @Test
  void sameHashcodeTest() {
    Cat firstCat = cats.get(0);
    Cat lastCat = cats.get(2);

    assertEquals(lastCat.hashCode(), firstCat.hashCode());
    assertEquals(firstCat.hashCode(), lastCat.hashCode());
  }

  @Test
  void sameHashcodeAndEqualsTest() {
    Cat firstCat = cats.get(0);
    Cat lastCat = cats.get(2);

    assertEquals(lastCat.hashCode(), firstCat.hashCode());
    assertEquals(firstCat, lastCat);
  }
}