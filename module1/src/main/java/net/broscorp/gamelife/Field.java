/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.gamelife;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Field {

  private int xSize, ySize;
  private List<Pair<Integer, Integer>> liveCells;

  public Field(int xSize, int ySize) {
    this.xSize = xSize;
    this.ySize = ySize;

    liveCells = new ArrayList<>();
  }

  public void createCell(int x, int y) {
    liveCells.add(new Pair<>(x, y));
  }

  public void killCell(int x, int y) {
    liveCells.remove(Pair.of(x, y));
  }

  public void printField(PrintStream output) {
    for (int i = 0; i < ySize; i++) {
      for (int j = 0; j < xSize; j++) {
        if (liveCells.contains(Pair.of(j, i))) {
          output.print("X ");
        } else {
          output.print("O ");
        }
      }
      output.println();
    }
  }

}
