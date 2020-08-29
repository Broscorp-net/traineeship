package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.broscorp.equals.hashcode.Entity;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class EntityTest {

  @Test
  /* сомневаюсь, что вы хотели увидеть мою реализацию проверки на транзитивность, рефлексивность,
   согласованность, и обработку null.
   тест подтверждает что equals/hashcode реализованы не правильно (для выполнения задания)
   */
  void equalsVerify() {
    Throwable thrown = assertThrows(AssertionError.class,
        EqualsVerifier.forClass(Entity.class)::verify);
    assertNotNull(thrown.getMessage());
  }


  @Test
  void findSameHash() {
    ArrayList<Entity> list = new ArrayList<>();
    list.add(new Entity(1, "first", "parametr"));
    list.add(new Entity(2, "second", "another parametr"));
    list.add(new Entity(1, "third", "param"));
    list.add(new Entity(1, "fourth", "another param"));

    Map<Integer, List<Entity>> sameHash =
        list.stream()
            .collect(Collectors.groupingBy(Entity::hashCode));

    sameHash.forEach((key, value) -> {
      for (int i = 0; i < value.size(); i++) {
        for (int j = value.size() - 1; j > i; j--) {
          if (!value.get(i).equals(value.get(j))) {
            System.out.println(
                "Вот объект " + value.get(i).toString() + ", вот объект " + value.get(j)
                    + ", они разные, но их хеш сопадает");
            assertFalse(value.get(i).equals(value.get(j)));
            assertTrue(value.get(i).hashCode() == value.get(j).hashCode());
          }
        }
      }
    });
  }
}
