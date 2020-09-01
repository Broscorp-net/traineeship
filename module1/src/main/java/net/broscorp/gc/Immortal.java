package net.broscorp.gc;

import java.util.HashSet;
import java.util.Set;

public class Immortal {
  private static final Set<Immortal> immortals = new HashSet<>();

  @Override
  protected void finalize() throws Throwable {
    System.out.println(Immortal.class.getSimpleName() + "::finalize for " + this);
    immortals.add(this);
  }
}