package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManTest {

  private Man man1;
  private Man man2;
  private Man man3;

  @BeforeEach
  public void setUp() {
    man1 = new Man("Tony", 40);
    man2 = new Man("Tony", 40);
    man3 = new Man("Tony", 40);
  }

  @Test
  public void testReflexive() {
    assertEquals(man1, man1);
  }

  @Test
  public void testSymmetric() {
    assertEquals(man1, man2);
    assertEquals(man2, man3);
    assertEquals(man1, man3);
  }

  @Test
  public void testTransitive() {
    assertTrue(man1.equals(man2) && man2.equals(man3) && man3.equals(man1));
  }


  @Test
  public void testConsistent() {
    assertTrue(man1.equals(man2) && man1.equals(man2) && man1.equals(man2));
  }

  @Test
  public void testCompareWithNull() {
    assertNotNull(man1);
  }

  @Test
  public void testHashCode() {
    assertEquals(man1, man2);
    assertEquals(man1.hashCode(), man2.hashCode());

    assertEquals(man1.hashCode(), man1.hashCode());
  }

  @Test
  public void testFindCollisionHashesForNotEqualsObjects() {
    List<Man> manList = createList();
    StringBuilder message = new StringBuilder();

    Iterator<Man> iterator = manList.iterator();

    Man curr = iterator.next();
    while (iterator.hasNext()) {
      Man next = iterator.next();

      if (!curr.equals(next) && curr.hashCode() == next.hashCode()) {
        assertNotEquals(curr, next);
        assertEquals(curr.hashCode(), next.hashCode());

        message.append("Объект ").append(curr.toString()).append(" и объект ")
            .append(next.toString()).append(" не совпадают, но их хеш совпадает\n");
        System.out.print(message.toString());
      }
      curr = next;
    }
  }

  private List<Man> createList() {
    List<Man> list = new ArrayList<>();
    list.add(man1);
    list.add(man2);
    list.add(man3);
    for (int i = 1; i <= 5; i++) {
      list.add(new Man("Test Man " + i, i));
    }
    return list;
  }

}