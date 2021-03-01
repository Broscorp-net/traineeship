package net.broscorp.oop.solid.lsp.steps;

import net.broscorp.oop.solid.lsp.Weapon;

public class ReloadMagazineStep extends AbstractReloadStep {

  public Weapon doStepInternal(Weapon weapon) {
    weapon.takeEmptyMagazineOff();
    weapon.insertFullMagazine();
    return weapon;
  }

}
