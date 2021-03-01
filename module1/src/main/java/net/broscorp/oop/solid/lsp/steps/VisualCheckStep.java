package net.broscorp.oop.solid.lsp.steps;

import net.broscorp.oop.solid.lsp.Weapon;

public class VisualCheckStep extends AbstractReloadStep {

  /**
   * @return null since weapon is reloaded normally and verification doesn't change its state
   */
  @Override
  public Weapon doStepInternal(Weapon weapon) {
    System.out.println("Weapon looks perfect!");
    return null;
  }

}
