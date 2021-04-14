package net.broscorp;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.equals.hashcode.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EqualsAndHashcodeTest {

  @Test
    void equalsReflexivity() {
    Player x = new Player(10, "John", "Captain");
    Assertions.assertEquals(x, x);
  }

  @Test
    void equalsSymmetry() {
    Player x = new Player(10, "John", "Captain");
    Player y = new Player(10, "John", "Captain");
    Assertions.assertEquals(x, y);
    Assertions.assertEquals(y, x);
  }

  @Test
    void equalsTransitivity() {
    Player x = new Player(10, "John", "Captain");
    Player y = new Player(10, "John", "Captain");
    Player z = new Player(10, "John", "Captain");
    Assertions.assertEquals(x, y);
    Assertions.assertEquals(y, z);
    Assertions.assertEquals(x, z);
  }

  @Test
    void equalsConsistency() {
    Player x = new Player(10, "John", "Captain");
    Player y = new Player(10, "John", "Captain");
    Assertions.assertEquals(x, y);
    x.setId(15);
    Assertions.assertNotEquals(x, y);
  }

  @Test
    void equalsNull() {
    Player x = new Player(10, "John", "Captain");
    Assertions.assertNotEquals(x, null);
  }

  @Test
    void whenHashcodeTheSameButTheObjectsAreDifferent() {
    List<Player> players = new ArrayList<>();
    players.add(new Player(2, "Chaos", "Captain"));
    players.add(new Player(8, "BOJlk777", "Major"));
    players.add(new Player(17, "Ignite", "First lieutenant"));
    players.add(new Player(13, "Nick", "Colonel"));
    players.add(new Player(27, "TheWorldIsYours", "General"));
    players.add(new Player(15, "xiao8", "Major"));

    int[] array = getSameHashcodeIndex(players);

    System.out.println("Объект " + players.get(array[0]).toString() + " и объект "
            + players.get(array[1]).toString() + " разные, но их хеш совпадает - "
            + players.get(array[0]).hashCode()
            + " и " + players.get(array[1]).hashCode() + " соответственно");
    Assertions.assertNotEquals(players.get(array[0]), players.get(array[1]));
  }

    int[] getSameHashcodeIndex(List<Player> players) {
    int[] array = new int[2];
    for (int i = 0, j = 0; i < players.size(); j++) {
      if (i != j && players.get(i).hashCode() == players.get(j).hashCode()) {
        array[0] = i;
        array[1] = j;
        return array;
      }
      if (j == (players.size() - 1)) {
        i++;
        j = 0;
      }
    }
    return  array;
  }
}
