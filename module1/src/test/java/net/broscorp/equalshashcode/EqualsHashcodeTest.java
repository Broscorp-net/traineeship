package net.broscorp.equalshashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.equals.hashcode.Creature;
import org.junit.jupiter.api.Test;

public class EqualsHashcodeTest {

  private final Creature testCreature1 = new Creature("Dog", "red", 6, "GAV", true);
  private final Creature testCreature2 = new Creature("Dog", "red", 6, "GAV", true);
  private final Creature testCreature3 = new Creature("Monkey", "grey", 2, "Uf", true);
  private final Creature testCreature4 = new Creature("Cat", "white", 4, "Meu", false);
  private final Creature testCreature5 = new Creature("Dog", "red", 6, "GAV", true);

  @Test
  public void equalsReflexiveTest() {
    assertEquals(testCreature1, testCreature1);
  }

  @Test
  public void equalsSymmetricTest() {
    assertTrue(testCreature1.equals(testCreature2));
    assertTrue(testCreature2.equals(testCreature1));
  }

  @Test
  public void equalsTransitiveTest() {
    assertTrue(testCreature1.equals(testCreature2));
    assertTrue(testCreature2.equals(testCreature5));
    assertTrue(testCreature1.equals(testCreature5));
  }

  @Test
  public void equalsConsistentTest() {
    Creature testCreature = new Creature("Dog", "red", 6, "GAV", true);
    assertEquals(testCreature1, testCreature);
    assertEquals(testCreature1, testCreature);

    testCreature.setLegsCount(4);
    testCreature.setColor("Black");

    assertNotEquals(testCreature1, testCreature);
  }

  @Test
  public void hashCodeEqualsTest() {
    assertEquals(testCreature1, testCreature2);
    int hash1 = testCreature1.hashCode();
    int hash2 = testCreature2.hashCode();

    assertEquals(hash1, hash2);
  }

  @Test
  public void hashCodeNotEqualsTest() {
    assertNotEquals(testCreature1, testCreature3);
    int hash1 = testCreature1.hashCode();
    int hash2 = testCreature3.hashCode();

    assertNotEquals(hash1, hash2);
  }

  @Test
  public void hashCodeEqualsButObjectsNotEqualsTest() {
    assertNotEquals(testCreature1, testCreature3);
    int hash1 = testCreature1.hashCode();
    int hash2 = testCreature3.hashCode();

    assertNotEquals(hash1, hash2);
  }

  @Test
  public void checkEqualsHashCodesTest() {
    List<Creature> creaturesList = new ArrayList<>();

    for (int i = 0; i < creaturesList.size(); i++) {
      for (int j = i + 1; j < creaturesList.size(); j++) {
        if (!creaturesList.get(i).equals(creaturesList.get(j))
            && creaturesList.get(i).hashCode() == creaturesList.get(j).hashCode()) {
          System.out.println(
              "Вот объект " + creaturesList.get(i) + ", вот объект " + creaturesList.get(j)
                  + ", они разные, но их хеш сопадает");
        }
      }
    }
  }
}
