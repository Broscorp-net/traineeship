/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.gamelife;

import java.util.Arrays;

public class Game {

  private Field field;

  public Game(Field field) {
    this.field = field;
  }

  public Field iterate(int iterations) {

    for (int iteration = 0; iteration < iterations; iteration++) {

      field.fakeMirror();

      Field newField = new Field(field.getxSize(), field.getySize(),
          Arrays.stream(field.getField()).map(int[]::clone).toArray(int[][]::new));

      for (int i = 1; i <= field.getxSize(); i++) {
        for (int j = 1; j <= field.getySize(); j++) {

          int aliveNear = field.numberOfNearestAlive(i, j);
          if (field.isAlive(i, j)) {
            if (aliveNear < 2 || aliveNear > 3) {
              newField.killCell(i, j);
            }
          } else {
            if (aliveNear == 3) {
              newField.createCell(i, j);
            }
          }
        }
      }

      field = newField;

    }

    return field;
  }

}
