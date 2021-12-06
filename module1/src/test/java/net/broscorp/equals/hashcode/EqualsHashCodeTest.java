package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EqualsHashCodeTest {

  static ArrayList<Player> playerList = new ArrayList<>();

  @BeforeAll
  public static void init() {
    playerList.add(new Player(23, "Bibo", 20, 185));
    playerList.add(new Player(20, "Sipo", 22, 180));
    playerList.add(new Player(21, "Rito", 25, 195));
    playerList.add(new Player(25, "Bibo", 20, 185));
    playerList.add(new Player(21, "Rito", 25, 195));
    playerList.add(new Player(21, "Rito", 25, 195));
  }

//  It is reflexive: for any non-null reference value x, x.equals(x) should return true.
  @Test
  void reflexiveComparison() {
    Assertions.assertTrue(playerList.get(0).equals(playerList.get(0)));
  }

//  It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
  @Test
  void symmetricComparison() {
    Assertions.assertTrue(playerList.get(2).equals(playerList.get(5)));
    Assertions.assertTrue(playerList.get(5).equals(playerList.get(2)));
  }

//  It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
  @Test
  void transitiveComparison() {
    Assertions.assertEquals(true, playerList.get(2).equals(playerList.get(5)));
    Assertions.assertEquals(true, playerList.get(5).equals(playerList.get(4)));
    Assertions.assertEquals(true, playerList.get(4).equals(playerList.get(2)));
  }

//  It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y)
//  consistently return true or consistently return false,
//  provided no information used in equals comparisons on the objects is modified.
  @Test
  void consistentComparison() {
    Assertions.assertEquals(true, playerList.get(2).equals(playerList.get(5)));
    Assertions.assertEquals(false, playerList.get(1).equals(playerList.get(3)));
    Assertions.assertEquals(true, playerList.get(2).equals(playerList.get(5)));
    Assertions.assertEquals(false, playerList.get(1).equals(playerList.get(3)));
  }

//  For any non-null reference value x, x.equals(null) should return false.
  @Test
  void nullComparison() {
    Assertions.assertEquals(false, playerList.get(1).equals(null));
  }

}
