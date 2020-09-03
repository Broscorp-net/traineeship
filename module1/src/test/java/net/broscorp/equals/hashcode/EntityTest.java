package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityTest {

  Entity entity1;
  Entity entity2;
  Entity entity3;

  @BeforeEach
  public void initTestObjects() {
    entity1 = new Entity(1, "Entity1", "param1");
    entity2 = new Entity(1, "Entity1", "param1");
    entity3 = new Entity(1, "Entity1", "param1");
  }

  // в реальном проекте я бы протестировал equals/hashcode с помощью EqualsVerifier...

  // проверка на транзитивность
  @Test
  public void objectsTransitiveTest() {
    assertAll(
        () -> assertTrue(entity1.equals(entity2)),
        () -> assertTrue(entity1.equals(entity3)),
        () -> assertTrue(entity2.equals(entity3))
    );
  }

  // проверка на рефлексивность
  @Test
  public void objectsReflexiveTest() {
    assertTrue(entity1.equals(entity1));
  }

  // проверка на симметричность
  @Test
  public void objectsSymmetricTest() {
    assertTrue(entity1.equals(entity2)
        && entity2.equals(entity1));
  }

  // проверка на согласованность
  @Test
  public void objectsConsistentTest() {
    boolean isEqual = entity1.equals(entity2);
    for (int i = 0; i < 100; i++) {
      assertEquals(isEqual, entity1.equals(entity2));
    }
  }

  // проверка на null
  @Test
  public void objectDoesNotEqualNull() {
    assertFalse(entity1.equals(null));
  }

  @Test
  void findObjectsWithSameHashes() {
    ArrayList<Entity> list = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 100_000; i++) {
      list.add(new Entity(random.nextInt(), "Entity" + i, "param1" + i));
    }

    Map<Integer, List<Entity>> sameHash =
        list.stream().collect(Collectors.groupingBy(Entity::hashCode));

    sameHash.forEach((key, value) -> {
      for (int i = 0; i < value.size(); i++) {
        for (int j = value.size() - 1; j > i; j--) {
          if (!value.get(i).equals(value.get(j))) {
            System.out.println(
                "Вот объект " + value.get(i).toString() + ", вот объект " + value.get(j)
                    + ", они разные, но их хеш сопадает");
            assertFalse(value.get(i).equals(value.get(j)));
            assertTrue(value.get(i).hashCode() == value.get(j).hashCode());
          }
        }
      }
    });
  }
}
