package net.broscorp.equals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import net.broscorp.equals.hashcode.Box;
import org.junit.jupiter.api.Test;

public class MyEqualsHashcodeTest {

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
