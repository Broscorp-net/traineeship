package net.broscorp.gc;

public class Asteroid {

  GoldAsteroid goldAsteroid;
  int id;

  public Asteroid(int id) {
    this.id = id;
  }

  @Override
  protected void finalize() throws Throwable{
    System.out.println("finalize() in asteroid id:" + id);
    Asteroid asteroid = this;
    super.finalize();
  }
}
