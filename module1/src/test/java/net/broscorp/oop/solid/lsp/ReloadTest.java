package net.broscorp.oop.solid.lsp;

import org.junit.jupiter.api.Test;

public class ReloadTest {

  @Test
  void testShootAndReload() {
    Weapon weapon = new Beretta();

    weapon.unBlock();
    weapon.shoot();
    weapon.shoot();

    weapon = new WeaponReloader().reload(weapon);

    weapon.unBlock();
    weapon.shoot();
    weapon.shoot();
  }

  private static class Beretta implements Weapon {

    @Override
    public void shoot() {
      System.out.println("Beretta: BANG!!!");
    }

    @Override
    public void block() {
      System.out.println("Beretta: Blocked");
    }

    @Override
    public void unBlock() {
      System.out.println("Beretta: Unblocked");
    }

    @Override
    public void takeEmptyMagazineOff() {
      System.out.println("Beretta: Unloaded");
    }

    @Override
    public void insertFullMagazine() {
      System.out.println("Beretta: Loaded");
    }

  }

}
