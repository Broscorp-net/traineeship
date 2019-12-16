
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;
import net.broscorp.i_equals_hashcode.EqualsHashCode;

class EqualsHashCodeTest {

  @Test
  void testEquals_HashCodeReflexivity() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    assertTrue(eh1.equals(eh1));
  }

  @Test
  void testEquals_HashCodeSymetry() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    EqualsHashCode eh2 = new EqualsHashCode(1, "Jack");
    assertEquals(eh1.equals(eh2), eh2.equals(eh1));
  }

  @Test
  void testEquals_HashCodeTrancitivity() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    EqualsHashCode eh2 = new EqualsHashCode(1, "Jack");
    EqualsHashCode eh3 = new EqualsHashCode(1, "Jack");
    assertTrue(eh1.equals(eh2));
    assertTrue(eh2.equals(eh3));
    assertTrue(eh1.equals(eh3));
  }

  @Test
  void testEquals_HashCodeConsistencyForEquals() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    EqualsHashCode eh2 = new EqualsHashCode(1, "Jack");
    for (int i = 0; i < 10; i++) {
      assertTrue(eh1.equals(eh2));
    }
  }

  @Test
  void testEquals_HashCodeNullUnequlity() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    assertFalse(eh1.equals(null));
  }

  @Test
  void testEquals_HashCodeEqualityForSameObjects() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    EqualsHashCode eh2 = new EqualsHashCode(1, "Jack");
    assertTrue(eh1.equals(eh2));
    assertTrue(eh1.hashCode() == eh2.hashCode());
  }

  @Test
  void testEquals_HashCodeConsistencyForHashCode() {
    EqualsHashCode eh1 = new EqualsHashCode(1, "Jack");
    EqualsHashCode eh2 = new EqualsHashCode(1, "Jack");
    for (int i = 0; i < 10; i++) {
      assertTrue(eh1.equals(eh2));
      assertTrue(eh1.hashCode() == eh2.hashCode());
    }
  }

  @Test
  public void equalHashCodeVerification() {
    HashSet<EqualsHashCode> mockSet = new HashSet<>();
    Map<Integer, String> mockMap = new HashMap<>();
    int seed = 200;
    Random random = new Random(seed);
    for (int i = 0; i < 1_00_000; i++) {
      EqualsHashCode mockElement = new EqualsHashCode(random.nextInt(1_000_000), "Jack");
      mockSet.add(mockElement);

      if (!mockMap.containsKey(mockElement.hashCode())) {
        mockMap.put(mockElement.hashCode(), new String("Hello" + i));
      } else {
        System.out.printf("Element %s with hash code %d already exist in map \n", mockElement,
            mockElement.hashCode());
      }
    }
    assertTrue(mockSet.size() == mockMap.size());

  }
}
