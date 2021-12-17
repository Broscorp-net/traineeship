package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GarbageCollectorTest {

  @Test
  void createLotsOfObjects() {
    for(int id = 0; id < 10_000; id++) {
      Asteroid asteroid = new Asteroid(id);
      asteroid = null;
    }
    System.gc();
  }

  @Test
  void isDeletedPairOfObject() {
    for(int id = 0; id < 100; id++) {
      Asteroid asteroid = new Asteroid(id);
      GoldAsteroid goldAsteroid = new GoldAsteroid(id);
      goldAsteroid.asteroid = asteroid;
      goldAsteroid = null;
    }
    System.gc();
  }

  @Test
  void isObjectAlive() {
    Random random = new Random();
    Asteroid asteroid = new Asteroid(random.nextInt(20));
    asteroid.goldAsteroid = new GoldAsteroid(asteroid);
    asteroid.goldAsteroid = null;
    System.gc();
    if (asteroid.goldAsteroid != null ) {
      System.out.println("golden asteroid still 'present'");
    }

  }

}
