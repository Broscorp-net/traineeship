package net.broscorp.i_equals_hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  void testHashCodeProduct() {
    Product camera1 = new Product(1, 250.50);
    Product camera2 = new Product(1, 250.50);

    assertEquals(camera1.hashCode(), camera2.hashCode());
  }

  @Test
  void testEqualsProduct() {
    Product camera1 = new Product(1, 250.5);
    Product camera2 = new Product(1, 250.5);

    assertEquals(camera1, camera2);
  }

  @Test
  void testHashCode() {
    List<Product> products = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      products.add(new Product(i, i));
    }
    products.add(new Product(1, 1.0));

    List<Integer> listHashCodeProducts = products.stream().map(Product::hashCode)
        .collect(Collectors.toList());

    List<Integer> findSameHashCode = listHashCodeProducts.stream()
        .filter(n -> listHashCodeProducts.stream()
            .filter(x -> x.equals(n))
            .count() > 1)
        .distinct()
        .collect(Collectors.toList());

    assertEquals(1, findSameHashCode.size());
  }
}