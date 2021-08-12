/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.override.overload;

import org.junit.jupiter.api.Test;

public class OverloadClassTest {

  @Test
  public void differentArgTypes() {
    Multiply multiply = new Multiply();

    //java: reference to operation is ambiguous
    //multiply.operation(Double.valueOf(3.15d), 3.15d);
  }

}
