package net.broscorp.oop.solid.lsp.steps;

import net.broscorp.oop.solid.lsp.Weapon;

public abstract class AbstractReloadStep {

  /**
   * This prestep is required to ensure that all humans are paying attention.
   */
  public final Weapon doStep(Weapon weapon) {
    System.out.println("Hey, humans! Pay attention! I'm doing " + this.getClass().getSimpleName());
    weapon = doStepInternal(weapon);
    System.out.println("Ok, that's it.");
    System.out.println();
    return weapon;
  }

  protected abstract Weapon doStepInternal(Weapon weapon);

}
