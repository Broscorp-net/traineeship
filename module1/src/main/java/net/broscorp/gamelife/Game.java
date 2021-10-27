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

  /**
   * Iterates one generation of a game.
   *
   * @param iterations number of total iterations
   * @return new field with remaining survivors
   */
  public Field iterate(int iterations) {

    for (int iteration = 0; iteration < iterations; iteration++) {

      field.fakeMirror();

      Field newField = new Field(field.getAxisX(), field.getAxisY(),
          Arrays.stream(field.getField()).map(int[]::clone).toArray(int[][]::new));

      for (int i = 1; i <= field.getAxisX(); i++) {
        for (int j = 1; j <= field.getAxisY(); j++) {

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
