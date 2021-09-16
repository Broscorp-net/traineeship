package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyObjectTest {

  private MyObject myObj1;
  private MyObject myObj2;
  private MyObject myObj3;
  private MyObject testObj;
  private MyObject testObj2;
  List<MyObject> list;

  public int search() {
    int a = 0;
    for (int i = 0; i <= 100; i++) {
      int b = 0;
      for (MyObject c : list) {
        if (c.hashCode() == i) {
          b++;
        }
        if (b >= 2) {
          a++;
        }
      }
    }
    if (a > 0) {
      return 1;
    } else {
      return -1;
    }
  }

  @BeforeEach
  void setUp() {
    list = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      list.add(new MyObject("Name" + i, i));
    }
    myObj1 = new MyObject("Object", 30);
    myObj2 = new MyObject("Object", 30);
    myObj3 = new MyObject("Object", 30);
    myObj1.setNumber(99);
    myObj2.setNumber(99);
    myObj3.setNumber(99);
  }

  @Test
  public void testToReflexiveBehaviorOfOverrideMethodEquals() {
    assertTrue(myObj1.equals(myObj1));
  }

  @Test
  public void testSymmetricBehaviorOfOverrideMethodEquals() {
    assertTrue(myObj1.equals(myObj2));
    assertTrue(myObj2.equals(myObj1));
  }

  @Test
  public void testTransitiveBehaviorOfOverrideMethodEquals() {
    assertTrue(myObj1.equals(myObj2));
    assertTrue(myObj1.equals(myObj3));
    assertTrue(myObj2.equals(myObj3));
  }

  @Test
  public void testConsistentBehaviorOfOverrideMethodEquals() {
    myObj2.setNumber(98);
    assertFalse(myObj1.equals(myObj2));
    assertFalse(myObj1.equals(myObj2));
    assertFalse(myObj1.equals(myObj2));
  }

  @Test
  public void testEqualsToNull() {
    assertFalse(myObj1.equals(null));
    assertFalse(myObj2.equals(null));
    assertFalse(myObj3.equals(null));
  }

  @Test
  public void overrideHashCodeMethodTest() {
    assertEquals(myObj1, myObj2);
    assertEquals(myObj1.hashCode(), myObj2.hashCode());
    myObj2.setId(35);
    assertEquals(myObj1.hashCode(), myObj2.hashCode());
    assertNotEquals(myObj1, myObj2);
    assertEquals(99, myObj1.hashCode());
    assertEquals(99, myObj1.hashCode());
    assertEquals(99, myObj1.hashCode());
  }

  @Test
  public void ifFoundDifferentObjectsThatHasSameHash() {
    assertEquals(1, search());
  }

  @Test
  public void ifNotFoundDifferentObjectsThatHasSameHash() {
    list = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      list.add(new MyObject("Name" + i, i, i));
    }
    assertEquals(-1, search());
  }

  @Test
  public void testFindsDifferentObjectsWithSameHashAndChecksMethodsEqualsAndHashCode() {
    for (int i = 0; i < list.size(); i++) {
      testObj = list.get(i);
      testObj2 = null;
      for (MyObject c : list) {
        if (testObj.hashCode() == c.hashCode() && !testObj.equals(c)) {
          testObj2 = c;
          break;
        }
      }
      if (testObj2 != null) {
        System.out.println(
            "Object " + testObj.toString() + " has same hash as object " + testObj2.toString()
                + " but objects are different.");
        break;
      }
    }
    assertNotEquals(testObj, testObj2);
    assertEquals(testObj.hashCode(), testObj2.hashCode());
  }
}