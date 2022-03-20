package net.broscorp.equals.hashcode;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EqualsHashCodeTest {

  private EqualsHashCode eh1;
  private EqualsHashCode eh2;
  private EqualsHashCode eh3;
  private EqualsHashCode eh4;

  @BeforeEach
  public void setUp() {
    eh1 = new EqualsHashCode(1, "s", new Integer(1));
    eh2 = new EqualsHashCode(1, "s", new Integer(1));
    eh3 = new EqualsHashCode(1, "s", new Integer(1));
    eh4 = new EqualsHashCode(1, "s", new Integer(2));
  }

  @Test
  public void reflexivityTest() {
    Assertions.assertEquals(eh1, eh1); // reflexivity
  }

  @Test
  public void symmetricTest() {
    Assertions.assertEquals(eh1, eh2); // symmetric
  }

  @Test
  public void transitivityTest() {
    Assertions.assertTrue(eh1.equals(eh2) && eh1.equals(eh3) && eh2.equals(eh3)); // transitivity
  }

  @Test
  public void consistentTest() {
    for (int i = 0; i < 5; i++) {
      Assertions.assertEquals(eh1, eh2); // consistent
    }
  }

  @Test
  public void falseForNullTest() {
    Assertions.assertNotEquals(eh1, null); // false for null
  }

  @Test
  public void sameHashCodeProductionTest() {
    int ehOneHash = eh1.hashCode();

    for (int i = 0; i < 5; i++) {
      Assertions.assertEquals(ehOneHash, eh1.hashCode()); // same hashcode production
    }
  }

  @Test
  public void equalsHashCodeContractShouldAssertTrue() {
    Assertions.assertTrue(
        eh1.equals(eh2) && eh1.hashCode() == eh2.hashCode());
  }

  @Test
  public void equalsAndHashCodeContractShouldAssertFalse() {
    Assertions.assertFalse(eh1.equals(eh4)
            && eh1.hashCode() == eh4.hashCode());
  }

  @Test
  public void enumerationForObjects() {
    while (true) {
      byte[] bytes1 = new byte[7];
      byte[] bytes2 = new byte[7];

      new Random().nextBytes(bytes1);
      new Random().nextBytes(bytes2);

      EqualsHashCode e1 =
          new EqualsHashCode(
              new Random().nextInt(10 - 1) + 1,
              new String(bytes1, StandardCharsets.UTF_8),
              new Integer(new Random().nextInt(10 - 1) + 1));

      EqualsHashCode e2 =
          new EqualsHashCode(
              new Random().nextInt(10 - 1) + 1,
              new String(bytes2, StandardCharsets.UTF_8),
              new Integer(new Random().nextInt(10 - 1) + 1));

      if (!e1.equals(e2) && e1.hashCode() == e2.hashCode()) {
        System.out.println(e1 + "\n and \n" + e2 + "\n" + "are not equal, but have same hashcode");
        Assertions.assertEquals(e1.hashCode(), e2.hashCode());
        break;
      }
    }
  }
}
