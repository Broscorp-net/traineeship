package net.broscorp.i_equals_hashcode;

import java.util.Objects;

public class Product {

  private int id;
  private double price;
  private String brand;

  public Product(int id, double price, String brand) {
    this.id = id;
    this.price = price;
    this.brand = brand;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
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
    return getId() == product.getId() &&
        Double.compare(product.getPrice(), getPrice()) == 0 &&
        Objects.equals(brand, product.brand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPrice(), brand);
  }
}
