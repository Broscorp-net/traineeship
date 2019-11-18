package net.broscorp.i_equals_hashcode;

public class Product {

  private int id;
  private Double price;

  public Product(int id, double price) {
    this.id = id;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    Product product = (Product) o;
    return id == product.id &&
        Double.compare(product.price, price) == 0;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (price != 0 ? price.hashCode() : 0);
    return result;
  }
}
