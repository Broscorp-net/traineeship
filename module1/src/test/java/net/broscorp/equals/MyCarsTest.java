package net.broscorp.equals;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCarsTest {

  private static final String[] colorArray = {"Red", "Blue", "Green", "Black"};
  private static final List<MyCars> carRepository = new ArrayList<>();

  @BeforeAll
  static void initAll() {
    for (int i = 0; i < 6; i++) {
      MyCars car = new MyCars("Mazda", colorArray);
      carRepository.add(car);
    }

  }

  @Test
  void equalsReflexiveTest() {
    MyCars car = new MyCars("VW", "Red", 1);
    assertTrue(car.equals(car));
  }

  @Test
  void equalsSymmetricTest() {
    MyCars carOne = new MyCars("VW", "Red", 1);
    MyCars carTwo = new MyCars("VW", "Red", 1);
    assertAll(
        () -> assertTrue(carOne.equals(carTwo)),
        () -> assertTrue(carTwo.equals(carOne))
    );
  }

  @Test
  void equalsConsistencyTest() {
    MyCars carOne = new MyCars("VW", "Red", 1);
    MyCars carTwo = new MyCars("VW", "Red", 1);
    for (int i = 0; i < 2; i++) {
      assertTrue(carOne.equals(carTwo));
    }
  }

  @Test
  void equalsTransitiveTest() {
    MyCars carOne = new MyCars("VW", "Red", 1);
    MyCars carTwo = new MyCars("VW", "Red", 1);
    MyCars carThree = new MyCars("VW", "Red", 1);
    assertAll(
        () -> assertTrue(carOne.equals(carTwo)),
        () -> assertTrue(carTwo.equals(carThree)),
        () -> assertTrue(carOne.equals(carThree))
    );
  }

  @Test
  void equalsNullTest() {
    MyCars car = new MyCars("VW", "Red", 1);
    assertFalse(car.equals(null));
  }

  @Test
  void hashCodeMultipleCallTest() {
    MyCars car = new MyCars("VW", "Red", 1);
    int hashTemp = car.hashCode();
    for (int i = 0; i < 5; i++) {
      assertEquals(hashTemp, car.hashCode());
    }
  }

  @Test
  void hashCodeEqualsObjectTest() {
    MyCars carOne = new MyCars("VW", "Red", 1);
    MyCars carTwo = new MyCars("VW", "Red", 1);
    assertAll(
        () -> assertTrue(carOne.equals(carTwo)),
        () -> assertTrue(carOne.hashCode() == (carTwo.hashCode()))
    );
  }

  @Test
  void hashCodeDifferentObjectTest() {
    MyCars carOne = new MyCars("VW", "Red", 1);
    MyCars carTwo = new MyCars("VW", "Black", 1);
    assertAll(
        () -> assertFalse(carOne.equals(carTwo)),
        () -> assertFalse(carOne.hashCode() == (carTwo.hashCode()))
    );
  }

  /*
  Для выполнения п.5 задания необходимо создать коллизию, т.е. различные объекты с одинаковым
  HashCode. Этого можно гарантировано добиться заполнив коллекцию 2^32+1 элементами. Я решил
  сделать проще и переопределил в классе метод hashCode() только по 1 полю "color". Таким образом
  разные объекты (машины) с одинаковым цветом будут иметь одинаковый HashCode. А минимальный размер
  коллекции объектов с гарантированной коллизией = размер массива цветов + 1, в данном случае 5.
   */
  @Test()
  void differentObjectWithSameHashCodeTest() {
    System.out.println("Fill a garage with cars:");
    for (MyCars myCars : carRepository) {
      System.out.println(myCars);
    }
    System.out.println();
    for (int i = 0; i < carRepository.size(); i++) {
      MyCars carOne = carRepository.get(i);
      for (int j = i + 1; j < carRepository.size(); j++) {
        MyCars carTwo = carRepository.get(j);
        if (carOne.hashCode() == carRepository.get(j).hashCode() & !carOne.equals(carTwo)) {
          System.out.println(
              "This objects not equals, but their HashCode is same - " + carOne.hashCode());
          System.out.println("Object 1 - " + carOne);
          System.out.println("Object 2 - " + carTwo);
          System.out.println();
        }
      }
    }
  }
}
