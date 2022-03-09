package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.broscorp.equals.hashcode.Country;
import org.junit.jupiter.api.Test;

public class CountryTest {

  //Generic test cases
  Country germany = new Country("Germany", 100, 10, true);
  Country pakistan = new Country("Pakistan", 50, 2, false);

  @Test
  public void equalsReflectionTest() {
    assertTrue(germany.equals(germany));
  }

  @Test
  public void equalsSymmetryTest() {
    Country alsoGermany = new Country("Germany", 100, 10, true);
    assertTrue(germany.equals(alsoGermany));
    assertTrue(alsoGermany.equals(germany));
    assertFalse(germany.equals(pakistan));
  }

  @Test
  public void equalsTransitivityTest() {
    Country alsoGermany = new Country("Germany", 100, 10, true);
    Country yetAnotherGermany = new Country("Germany", 100, 10, true);
    assertTrue(germany.equals(alsoGermany));
    assertTrue(alsoGermany.equals(yetAnotherGermany));
    assertTrue(germany.equals(yetAnotherGermany));
  }

  @Test
  public void equalsConsistencyTest() {
    Country alsoGermany = new Country("Germany", 100, 10, true);
    for (int i = 0; i < 10; i++) {
      assertTrue(germany.equals(alsoGermany));
    }
  }

  @Test
  public void hashCodeConsistencyTest() {
    Country alsoGermany = new Country("Germany", 100, 10, true);
    for (int i = 0; i < 10; i++) {
      assertTrue(alsoGermany.hashCode() == germany.hashCode());
    }
  }

  @Test
  public void hashCodeEqualityTest() {
    Country alsoGermany = new Country("Germany", 100, 10, true);
    assertTrue(germany.equals(alsoGermany) && germany.hashCode() == alsoGermany.hashCode());
  }

  @Test
  public void hashCodeCollissionTest() {
    Country a = new Country("Aa", 5, 5, true);
    Country b = new Country("BB", 25, 1, true);
    //a has the same hashcode as b
    assertTrue(a.hashCode() == b.hashCode());
    //but they are not the same objects
    assertFalse(a.equals(b));
  }
}