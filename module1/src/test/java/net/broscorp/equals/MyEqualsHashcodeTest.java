package net.broscorp.equals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import net.broscorp.equals.hashcode.Box;
import org.junit.jupiter.api.Test;

public class MyEqualsHashcodeTest {

  //It is reflexive: for any non-null reference value x, x.equals(x) should return true
  @Test
  void boxReflexiveTest() {
    Box box1 = new Box(20, 30);
    Box box2 = box1;

    assertEquals(box1, box2);
  }

  //It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if
  // and only if y.equals(x) returns true.
  @Test
  void boxSymmetricTest() {
    Box box1 = new Box(20, 30);
    Box box2 = new Box(20, 30);

    assertEquals(box1, box2);
    assertEquals(box2, box1);
  }

  //  It is transitive: for any non-null reference values x, y, and z, if x.equals(y)
  //  returns true and y.equals(z) returns true, then x.equals(z) should return true
  @Test
  void boxTransitiveTest() {
    Box box1 = new Box(20, 30);
    Box box2 = new Box(20, 30);
    Box box3 = new Box(20, 30);

    assertEquals(box2, box1);
    assertEquals(box3, box1);
    assertEquals(box2, box3); //then x.equals(z) should return true
  }

  //It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y)
  //consistently return true or consistently return false, provided no information used in equals
  //comparisons on the objects is modified.
  @Test
  void boxConsistentlyTest() {
    Box box1 = new Box(20, 30);
    Box box2 = new Box(20, 30);

    for (int i = 0; i < 10; i++) {
      assertEquals(box1, box2);
    }
  }

  //For any non-null reference value x, x.equals(null) should return false.
  @Test
  void boxNullReferenceTest() {
    Box box1 = new Box(20, 30);
    Box box2 = null;

    assertFalse(box1.equals(box2));
  }


  @Test
  void boxHashcodeTest() {
    Box box1 = new Box(20, 30);
    Box box2 = new Box(20, 30);

    assertEquals(box1.hashCode(), box2.hashCode());
  }

  @Test
  void boxDifferentHashcodeTest() {
    Box box1 = new Box(20, 30);//hashcode 650
    Box box2 = new Box(21, 39);//hashcode 690

    assertNotEquals(box1.hashCode(), box2.hashCode());
  }

  @Test
  void boxEqualTest() {
    Box box1 = new Box(200, 300);
    Box box2 = new Box(200, 300);

    assertEquals(box1, box2);
  }

  @Test
  void boxNotEqualTest() {
    Box box1 = new Box(10, 380);
    Box box2 = new Box(200, 300);

    assertNotEquals(box1, box2);
  }

  @Test
  void boxHashcodeCollision() {
    List<Box> boxesHashCodeCollision = Box.getBoxesHashcodeCollision();//mock pair of boxes

    Box box1 = boxesHashCodeCollision.get(0); //Box{height=0, width=31} hashcode = 31
    Box box2 = boxesHashCodeCollision.get(1); //Box{height=1, width=0} hashcode = 31

    assertNotEquals(box1.getHeight(), box2.getHeight());
    assertNotEquals(box1.getWidth(), box2.getWidth());

    assertEquals(box1.hashCode(), box2.hashCode());

    for (int i = 0; i < boxesHashCodeCollision.size() / 2 - 1; i++) {
      System.out.println("Вот объект " + boxesHashCodeCollision.get(2 * i) + " , вот объект "
          + boxesHashCodeCollision.get(2 * i + 1) + " , они разные, но их хеш "
          + boxesHashCodeCollision.get(2 * i).hashCode() + " - сопадает.");
    }
  }
}
