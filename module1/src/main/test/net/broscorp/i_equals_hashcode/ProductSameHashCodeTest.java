package net.broscorp.i_equals_hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ProductSameHashCodeTest {

  @Test
  void testHashCodeCollisionSearch() {
    List<Product> products = new ArrayList<>();
    String symbol = "A";

    for (int i = 0; i < 1_000_000; i++) {
      products.add(new Product(i, i, symbol + i));
    }

    String message = null;

    Map<Integer, List<Product>> productByHash = products.stream()
        .collect(Collectors.groupingBy(Product::hashCode));
    for (Entry<Integer, List<Product>> entry : productByHash.entrySet()) {
      List<Product> value = entry.getValue();
      int collisions = value.size() - 1;
      if (collisions > 0) {
        message = "Bingo! Collisions!";
      }
    }
    assertEquals("Bingo! Collisions!", message);
  }
}
