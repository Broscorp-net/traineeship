package net.broscorp.oop.solid.lsp.steps;

import net.broscorp.oop.solid.lsp.Weapon;

public class ShootTestStep extends AbstractReloadStep {

  @Override
  public Weapon doStepInternal(Weapon weapon) {
    weapon.unBlock();
    weapon.shoot();
    weapon.block();
    return weapon;
  }

}
