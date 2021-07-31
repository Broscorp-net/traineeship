package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class DoterTest {

  @Test
  public void doterVariationTest() {

    Doter doter1 = new Doter(1500, BigDecimal.valueOf(.9), "depressed kid");
    Doter doter2 = new Doter(1500, BigDecimal.valueOf(.9), "depressed kid");
    Doter doter3 = new Doter(1500, BigDecimal.valueOf(.9), "depressed kid");

    //reflexive
    assertTrue(doter1.equals(doter1));
    //symmetric
    assertTrue(doter1.equals(doter2) && doter2.equals(doter1));
    //transitive
    assertTrue(doter1.equals(doter2) && doter2.equals(doter3) && doter3.equals(doter1));
    //consistent
    assertTrue(doter1.equals(doter2) && doter1.equals(doter2)
        && doter1.equals(doter2) && doter1.equals(doter2));
    //null equals
    assertFalse(doter1.equals(null));

    //consistent hashcode
    assertTrue(doter1.hashCode() == doter1.hashCode() &&
        doter1.hashCode() == doter1.hashCode());
    //equal to hashcode
    assertTrue(doter1.equals(doter2) && doter1.hashCode() == doter2.hashCode());
  }

  @Test
  public void sameHashDoterTest() {
    Doter doter = new Doter(1500, BigDecimal.valueOf(.9), "depressed kid");
    Doter nullDoter = new Doter(0, BigDecimal.valueOf(0), "null");

    do {
      nullDoter.setRanked(nullDoter.getRanked() + 1);
    } while (nullDoter.hashCode() != doter.hashCode());

    //so now we have two different object, but their hashcode is different
    System.out.println(doter + "\n" + nullDoter);

    assertEquals(doter.hashCode(), nullDoter.hashCode());

  }

}
