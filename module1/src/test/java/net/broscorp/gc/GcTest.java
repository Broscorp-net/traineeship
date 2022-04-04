package net.broscorp.gc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GcTest {
  List<Human> humans = new ArrayList<>();

  @Test
  public void checkFillingList() {
    int i = 0;
    while (i < Integer.MAX_VALUE / 10) {
      humans.add(new Human(i));
      i++;
    }
  }

  @Test
  public void checkLooseLinkOfObject() {
    int i = 0;
    while (i < 10000) {
      Human human = new Human(i);
      human = null;
      i++;
    }
    System.gc();
  }

  @Test
  public void checkReachableObject() {
    Human human = new Human(1);
    human = null;
    System.gc();
    human = new Human(2);
    Assertions.assertNotNull(human);
  }

  @Test
  public void checkDeleteObjectsWithSameLink() {
    Human human1 = new Human(1);
    Human human2 = new Human(2);
    human1 = human2;
    human2 = human1;
    human1 = null;
    human2 = null;
    System.gc();
  }
}