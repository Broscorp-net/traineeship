package net.broscorp.equals.hashcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EntityTest {
  List<Entity> entities = new ArrayList<>();

  void setEntities() {
    Entity entity = new Entity("Bob", "Bill", 22);
    Entity entity2 = new Entity("Bill", "Bob", 22);
    Entity entity3 = new Entity("Santa", "Clause", 50);
    entities.add(entity);
    entities.add(entity2);
    entities.add(entity3);
  }

  @Test
    void testEquals() {
    Entity entity = new Entity("Bob","Smit",36);
    Entity secondEn = new Entity("Bob","Farell",36);
    assertFalse(entity.equals(secondEn));
  }

  @Test
    void testEquals2() {
    Entity entity = new Entity("Bob", "Smit", 36);
    Entity secondEn = new Entity("Bob", "Smit", 36);
    assertTrue(entity.equals(secondEn));
  }

  @Test
    void testEquals3() {
    Entity entity = new Entity("Boy", "Smit", 36);
    Entity secondEn = new Entity("Bob", "Smit", 36);
    assertFalse(entity.equals(secondEn));
  }

  @Test
   void testHashCode() {
    Entity entity = new Entity("Tomas", "Shelby", 52);
    assertTrue(entity.hashCode() != 0);
  }

  @Test
  void testSameHash() {
    setEntities();
    for (int i = 0;i < entities.size();i++) {
      Entity localEntity = entities.get(i);
      Iterator<Entity> iterator = entities.listIterator(i + 1);
      while (iterator.hasNext()) {
        Entity comparable = iterator.next();
        if (localEntity.hashCode() == comparable.hashCode()) {
          System.out.println("There are entities with same hashCode \n"
                  + localEntity
                  + "\n"
                  + "Entity hash is "
                  + localEntity.hashCode()
                  + "\n"
                  + "---------------------\n"
                  + "Second Entity \n"
                  + comparable
                  + "Second Entity hash is "
                  + comparable.hashCode()
                  + "\n"
                  + "However equals show false");
          assertTrue(comparable.hashCode() == localEntity.hashCode());
          assertFalse(comparable.equals(localEntity));
        }
        }
    }
  }
}

