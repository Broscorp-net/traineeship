package net.broscorp.oop.solid.lsp;

public interface Weapon {

  void block();

  void unBlock();

  void takeEmptyMagazineOff();

  void shoot();

  void insertFullMagazine();

}
