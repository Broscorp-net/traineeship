package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

  @Test
  void positiveTestEquals() {
    Computer expectedComputer = new Computer("serialNumber", "cpu", "graphics", 16, 512);
    Computer compareToComputer = new Computer("serialNumber", "cpu", "graphics", 16, 512);
    // they are equals
    assertTrue(expectedComputer.equals(compareToComputer));
    assertTrue(expectedComputer.hashCode() == compareToComputer.hashCode());

  }

  @Test
  void negativeTestEquals() {
    Computer expectedComputer = new Computer("serialNumber", "cpu", "graphics", 16, 512);
    Computer compareToComputer = new Computer("serialNumber", "cpu", "graphics", 15, 511);
    // they are not equals, but the hash code matches
    assertFalse(expectedComputer.equals(compareToComputer));
    assertTrue(expectedComputer.hashCode() == compareToComputer.hashCode());

  }

  @Test
  void positiveTestHashCode() {
    Computer expectedComputer = new Computer("serialNumber", "cpu", "graphics", 16, 512);
    Computer compareToComputer = new Computer("serialNumber", "cpu", "graphics", 16, 512);
    // they are equals
    assertTrue(expectedComputer.hashCode() == compareToComputer.hashCode());
  }

  @Test
  void negativeTestHashCode() {
    Computer expectedComputer = new Computer("serialNumber", "cpu", "graphics", 16, 512);
    Computer compareToComputer = new Computer("serialNumber1", "cpu1", "graphics1", 15, 511);
    // they are not equals
    assertFalse(expectedComputer.hashCode() == compareToComputer.hashCode());
  }

  @Test
  void testHashCode() {
    List<Computer> computers = new ArrayList<>();
    Computer computer = new Computer("serialNumber_2", "cpu_2", "graphics_2", 18, 515);
    final int expectedCounterOfHashCodeCoincidence = 2;
    int hashCode = computer.hashCode();
    int counterOfHashCodeCoincidence = 0;
    int counterOfEqualsObjects = 0;

    computers.add(new Computer("serialNumber_2", "cpu_2", "graphics_2", 16, 513));
    computers.add(new Computer("serialNumber_1", "cpu_1", "graphics_1", 17, 514));
    computers.add(new Computer("serialNumber_2", "cpu_2", "graphics_2", 18, 515));
    computers.add(new Computer("serialNumber_3", "cpu_3", "graphics_3", 19, 516));

    for (Computer comp : computers) {
      if (comp.hashCode() == hashCode) {
        counterOfHashCodeCoincidence++;
      }
      if (computer.equals(comp)) {
        counterOfEqualsObjects++;
      }

    }

    assertEquals(expectedCounterOfHashCodeCoincidence, counterOfHashCodeCoincidence);
    assertNotEquals(counterOfHashCodeCoincidence, counterOfEqualsObjects);

  }

}