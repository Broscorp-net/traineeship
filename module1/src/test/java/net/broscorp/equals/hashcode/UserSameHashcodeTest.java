package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class UserSameHashcodeTest {

  @Test
  void testHashcodeCollisionSearch() {
    Random random = new Random();
    List<User> users = new ArrayList<>();
    String symbol = "A";

    for (int i = 0; i < 1_000_000; i++) {
      users.add(new User(i, random.nextInt(), symbol + i));
    }

    String message = null;
    Map<Integer, List<User>> usersByHash = users.stream()
        .collect(Collectors.groupingBy(User::hashCode));
    for (Entry<Integer, List<User>> entry : usersByHash.entrySet()) {
      List<User> listUsers = entry.getValue();
      for (int i = 0; i < listUsers.size() - 1; i++) {
        System.out.println(
            "Вот объект " + listUsers.get(i) + ", вот объект " + listUsers.get(i + 1)
                + ", они разные, но их хеш совпадает");
        assertFalse(listUsers.get(i).equals(listUsers.get(i + 1)));
        assertTrue(listUsers.get(i).hashCode() == listUsers.get(i + 1).hashCode());
      }

      int size = listUsers.size() - 1;
      if (size > 0) {
        message = "Collision is true";
      }
    }

    assertEquals("Collision is true", message);
  }
}
