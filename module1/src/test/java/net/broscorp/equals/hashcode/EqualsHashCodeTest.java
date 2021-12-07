package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.Random;
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


//  Whenever it is invoked on the same object more than once during an execution of a Java application,
//   the hashCode method must consistently return the same integer,
//   provided no information used in equals comparisons on the object is modified.
//   This integer need not remain consistent from one execution of an application to another execution of the same application.
  @Test
  void multipleInvokingHashCode() {
    int hashCodeOne = playerList.get(0).hashCode();
    int hashCodeTwo = playerList.get(0).hashCode();
    Assertions.assertEquals(true, hashCodeOne == hashCodeTwo);
  }

//  If two objects are equal according to the equals(Object) method,
//   then calling the hashCode method on each of the two objects must produce the same integer result.
  @Test
  void twoSameObjectsHaveSameHashCode () {
    Assertions.assertEquals(playerList.get(4).equals(playerList.get(5)),
        playerList.get(4).hashCode() == playerList.get(5).hashCode());
  }

//  It is not required that if two objects are unequal according to the equals(java.lang.Object) method,
//  then calling the hashCode method on each of the two objects must produce distinct integer results.
  @Test
  void unequalObjectsHaveDifferenceHasCode() {
    Assertions.assertEquals(playerList.get(1).equals(playerList.get(5)),
        playerList.get(1).hashCode() == playerList.get(5).hashCode());
  }

  @Test
  void unequalObjectsHaveSameHasCode() {
    ArrayList<Player> randomPlayerList = generateRandomPlayerList();
    System.out.println(randomPlayerList.size());
    for(int i = 0; i < randomPlayerList.size() - 1; i++){
      if(randomPlayerList.get(i).hashCode() == randomPlayerList.get(i + 1).hashCode() &&
      randomPlayerList.get(i).equals(randomPlayerList.get(i + 1))){
        System.out.println("Object A = " + randomPlayerList.get(i).toString()
            + "\n" + "Object B = " + randomPlayerList.get(i + 1).toString()
            + "\n" + "and they difference but its HASHCODE equals "
            + "\n" + randomPlayerList.get(i).equals(randomPlayerList.get(i + 1)));
      }
      System.out.println("End comparison");
    }
  }

  private ArrayList<Player> generateRandomPlayerList() {
    ArrayList<Player> playerList = new ArrayList<>();
    Random random = new Random();
    int yearOfPlayer = random.nextInt(33 - 20) + 20;
    int heightOfPlayer = random.nextInt(205 - 185) + 185;
    int numberForPlayer = random.nextInt(1000 - 1) + 1;
    int playerId = random.nextInt(100_000);
    for(int i = 0; i < 100_000; i++){
      playerList.add(new Player(playerId, "bot" + numberForPlayer, yearOfPlayer,heightOfPlayer));
    }
    return playerList;
  }

}
