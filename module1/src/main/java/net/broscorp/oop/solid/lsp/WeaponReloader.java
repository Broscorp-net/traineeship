package net.broscorp.oop.solid.lsp;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.oop.solid.lsp.steps.AbstractReloadStep;
import net.broscorp.oop.solid.lsp.steps.MakeSafeStep;
import net.broscorp.oop.solid.lsp.steps.ReloadMagazineStep;
import net.broscorp.oop.solid.lsp.steps.ShootTestStep;
import net.broscorp.oop.solid.lsp.steps.VisualCheckStep;

public class WeaponReloader {

  Weapon reload(Weapon weapon) {
    List<AbstractReloadStep> steps = new ArrayList<AbstractReloadStep>();
    steps.add(new MakeSafeStep(weapon));
    steps.add(new VisualCheckStep());
    steps.add(new ReloadMagazineStep());
    steps.add(new ShootTestStep());

    for (AbstractReloadStep step : steps) {
      Weapon weapon1 = step.doStep(weapon);
      // Some steps may produce null, so this workaround is needed
      if (weapon1 == null) {
        weapon1 = weapon;
      }
      weapon = weapon1;
    }

    System.out.println("Weapon reloaded");
    return weapon;
  }

}

