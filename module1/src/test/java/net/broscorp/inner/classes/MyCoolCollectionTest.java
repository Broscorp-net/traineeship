package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Hryhorii Perets
 */
class MyCoolCollectionTest {

  private MyCoolCollection<Integer> myCoolCollection;

  @BeforeEach
  void setUp() {
    myCoolCollection = new MyCoolCollection<>();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void add() {
    myCoolCollection.add(1);
    myCoolCollection.add(5);
    myCoolCollection.add(10);
    myCoolCollection.add(7);
    System.out.println(myCoolCollection.size());
    System.out.println(myCoolCollection.get(2));

  }

  @Test
  void get() {

  }
}