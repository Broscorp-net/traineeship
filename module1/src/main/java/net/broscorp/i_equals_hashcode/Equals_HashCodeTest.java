package net.broscorp.i_equals_hashcode;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.Test;

class Equals_HashCodeTest {

  @Test
  void testEquals_HashCodeReflexivity() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    assertTrue(eh1.equals(eh1));
  }

  @Test
  void testEquals_HashCodeSymetry() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    Equals_HashCode eh2 = new Equals_HashCode(1, "Jack");
    assertEquals(eh1.equals(eh2), eh2.equals(eh1));
  }

  @Test
  void testEquals_HashCodeTrancitivity() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    Equals_HashCode eh2 = new Equals_HashCode(1, "Jack");
    Equals_HashCode eh3 = new Equals_HashCode(1, "Jack");
    assertTrue(eh1.equals(eh2));
    assertTrue(eh2.equals(eh3));
    assertTrue(eh1.equals(eh3));
  }

  @Test
  void testEquals_HashCodeConsistencyForEquals() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    Equals_HashCode eh2 = new Equals_HashCode(1, "Jack");
    for (int i = 0; i < 10; i++) {
      assertTrue(eh1.equals(eh2));
    }
  }

  @Test
  void testEquals_HashCodeNullUnequlity() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    assertFalse(eh1.equals(null));
  }

  @Test
  void testEquals_HashCodeEqualityForSameObjects() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    Equals_HashCode eh2 = new Equals_HashCode(1, "Jack");
    assertTrue(eh1.equals(eh2));
    assertTrue(eh1.hashCode() == eh2.hashCode());
  }

  @Test
  void testEquals_HashCodeConsistencyForHashCode() {
    Equals_HashCode eh1 = new Equals_HashCode(1, "Jack");
    Equals_HashCode eh2 = new Equals_HashCode(1, "Jack");
    for (int i = 0; i < 10; i++) {
      assertTrue(eh1.equals(eh2));
      assertTrue(eh1.hashCode() == eh2.hashCode());
    }
  }

  @Test
  void testRepeatedHashCodes() {
    Random random = new Random();
    int iteration = 100_000;
    Set<Equals_HashCode> mySet = new HashSet<>();
    for (int i = 0; i < iteration; i++) {
      Equals_HashCode eh = new Equals_HashCode(random.nextInt(100_000), "Jack");
      mySet.add(eh);
    }
    assertTrue(iteration - mySet.size() > 0);
  }
}
