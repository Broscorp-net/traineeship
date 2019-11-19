package net.broscorp.i_equals_hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductEqualsHashCodeContractTest {

  private List<Product> products;

  @BeforeEach
  void setUp() {
    products = Arrays.asList(
        new Product(1, 250.50, "Sony"),
        new Product(1, 250.50, "Sony"),
        new Product(1, 250.50, "Sony"));
  }

  @Test
  void testProductReflexive() {
    Product camera = new Product(1, 250.50, "Sony");
    assertTrue(camera.equals(products.get(0)));
  }

  @Test
  void testProductSymmetric() {
    Product x = products.get(0);
    Product y = products.get(1);
    assertTrue(x.equals(y) && y.equals(x));
  }

  @Test
  void testProductTransitivity() {
    Product x = products.get(0);
    Product y = products.get(1);
    Product z = products.get(2);
    assertTrue(x.equals(y) && y.equals(z) && x.equals(z));
  }

  @Test
  void testProductNull() {
    Product x = products.get(0);
    assertFalse(x.equals(null));
  }

  @Test
  void testProductConsistent() {
    Product x = products.get(0);
    Product y = products.get(1);
    assertTrue(x.equals(y) && y.equals(x));

    x.setPrice(200.0);
    assertFalse(x.equals(y));
  }

  @Test
  void testProductHashcodeOneOrMore() {
    Product x = products.get(0);
    Product y = products.get(1);
    assertTrue(x.hashCode() == y.hashCode());
    assertTrue(x.hashCode() == y.hashCode());
  }

  @Test
  void testProductHashcodeIfEquals() {
    Product x = products.get(0);
    Product y = products.get(1);
    assertTrue(x.equals(y) && x.hashCode() == y.hashCode());
  }
}