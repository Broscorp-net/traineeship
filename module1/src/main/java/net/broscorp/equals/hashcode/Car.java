package net.broscorp.equals.hashcode;


public class Car {

  String brand;
  String model;
  int age;

  /**
   * Class Car needed for testing equals() and hashCode().
   *
   * @param brand - brand of car
   * @param model - model of car
   * @param age   - car age
   */

  public Car(String brand, String model, int age) {
    this.brand = brand;
    this.model = model;
    this.age = age;
  }

  public Car() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return age == car.age && brand.equals(car.brand) && model.equals(car.model);
  }

  @Override
  public int hashCode() {
    return brand.hashCode() + model.hashCode() + age * 31;
  }

  @Override
  public String toString() {
    return "Car: "
        + "brand = '" + brand + '\''
        + ", model = '" + model + '\''
        + ", age = " + age + ';';
  }
}
