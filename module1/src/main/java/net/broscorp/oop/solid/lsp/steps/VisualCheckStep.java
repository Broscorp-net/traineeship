package net.broscorp.oop.solid.lsp.steps;

import net.broscorp.oop.solid.lsp.Weapon;

public class VisualCheckStep extends AbstractReloadStep {

  /**
   * Weapon is reloaded normally and verification doesn't change its state.
   * May be we shouldn't return unchanged state.
   * @return null
   */
  @Override
  public Weapon doStepInternal(Weapon weapon) {
    System.out.println("Weapon looks perfect!");
    return null;
  }

}
