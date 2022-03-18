package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  private Car car1;
  private Car car2;
  private Car car3;
  private Car car4;
  private List<Car> carList;

  @BeforeEach
  void init() {
    car1 = new Car("BMW", "M5", 4);
    car2 = new Car("BMW", "M5", 4);
    car3 = new Car("Audi", "A7", 7);
    car4 = new Car("A7", "Audi", 7);
    carList = new ArrayList<>();
    carList.add(car1);
    carList.add(car2);
    carList.add(car3);
    carList.add(car4);
  }

  @Test
  void carEqualsTrueTest() {
    Assertions.assertEquals(car1, car2);
  }

  @Test
  void carHashCodeTrueTest() {
    Assertions.assertEquals(car1.hashCode(), car2.hashCode());
  }

  @Test
  void carEqualsFalseTest() {
    Assertions.assertNotEquals(car1, car3);
    Assertions.assertNotEquals(car1, car4);
    Assertions.assertNotEquals(car2, car3);
    Assertions.assertNotEquals(car2, car4);
    Assertions.assertNotEquals(car3, car4);
  }

  @Test
  void carHashCodeFalseTest() {
    Assertions.assertNotEquals(car1.hashCode(), car3.hashCode());
    Assertions.assertNotEquals(car1.hashCode(), car4.hashCode());
    Assertions.assertNotEquals(car2.hashCode(), car3.hashCode());
    Assertions.assertNotEquals(car2.hashCode(), car4.hashCode());
  }

  @Test
  void findSameHashCode() {
    for (int i = 0; i < carList.size() - 1; i++) {
      if (carList.get(i).hashCode() == carList.get(i + 1).hashCode()) {
        System.out.println(carList.get(i).toString() + " Xеш = " + carList.get(i).hashCode() + " | "
            + carList.get(i + 1).toString() + " Xеш = " + carList.get(i + 1).hashCode());
        Assertions.assertEquals(carList.get(i).hashCode(), carList.get(i + 1).hashCode());
      }
    }
  }

  @Test
  void findSameHashCodeAndNotSameEquals() {
    for (int i = 0; i < carList.size() - 1; i++) {
      if (!carList.get(i).equals(carList.get(i + 1))
          && carList.get(i).hashCode() == carList.get(i + 1).hashCode()) {
        System.out.println(
            "Вот объект " + carList.get(i).toString()
                + " вот его хеш " + carList.get(i).hashCode()
                + "\nВот объект " + carList.get(i + 1).toString()
                + " вот его хеш " + carList.get(i + 1).hashCode()
                + "\nОбъекты разные, но их хеш совпадает"
        );
        Assertions.assertEquals(carList.get(i).hashCode(), carList.get(i + 1).hashCode());
        Assertions.assertNotEquals(carList.get(i), carList.get(i + 1));
      }
    }
  }
}
