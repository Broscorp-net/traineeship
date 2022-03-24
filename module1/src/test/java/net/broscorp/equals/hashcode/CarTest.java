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

  @BeforeEach
  void init() {
    car1 = new Car("BMW", "M5", 4);
    car2 = new Car("BMW", "M5", 4);
    car3 = new Car("Audi", "A7", 7);
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
  void carEqualsFalseTest1() {
    Assertions.assertNotEquals(car1, car3);
  }

  @Test
  void carEqualsFalseTest2() {
    Assertions.assertNotEquals(car2, car3);
  }

  @Test
  void carHashCodeFalseTest1() {
    Assertions.assertNotEquals(car1.hashCode(), car3.hashCode());
  }

  @Test
  void carHashCodeFalseTest2() {
    Assertions.assertNotEquals(car2.hashCode(), car3.hashCode());
  }

  @Test
  void findSameHashCodeAndNotSameEquals() {
    List<Car> carList = new ArrayList<>();
    for (int i = 1; i < 15; i++) {
      carList.add(new Car("Tesla", "Model S", 1 + (int) (Math.random() * i)));
      carList.add(new Car("Tesla", "Model S", 1 + (int) (Math.random() * i)));
      carList.add(new Car("Porsche", "Taycan", 1 + (int) (Math.random() * i)));
      carList.add(new Car("Taycan", "Porsche", 1 + (int) (Math.random() * i)));
    }
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
        System.out.println();
        Assertions.assertEquals(carList.get(i).hashCode(), carList.get(i + 1).hashCode());
        Assertions.assertNotEquals(carList.get(i), carList.get(i + 1));
      }
    }
  }
}
