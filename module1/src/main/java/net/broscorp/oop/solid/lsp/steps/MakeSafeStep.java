package net.broscorp.oop.solid.lsp.steps;

import net.broscorp.oop.solid.lsp.Weapon;

/**
 * Initial step to be sure the weapon is safe for operations.
 */
public class MakeSafeStep extends AbstractReloadStep {

    private final Weapon weapon;

    public MakeSafeStep(Weapon weapon) {
        this.weapon = weapon;
    }

    // Ignoring argument since we already got the weapon in the constructor.
    @Override
    public Weapon doStepInternal(Weapon weapon) {
        weapon = this.weapon;
        weapon.block();
        return weapon;
    }

}
