package net.broscorp.gc;

public class GoldAsteroid {

  Asteroid asteroid;
  int id;

  public GoldAsteroid(int id) {
    this.id = id;
  }

  public GoldAsteroid(Asteroid asteroid) {
    this.asteroid = asteroid;
  }

  @Override
  protected void finalize() throws Throwable{
    super.finalize();
    System.out.println("finalize() in golden asteroid id: " + id);
    asteroid.goldAsteroid = this;
  }


}
