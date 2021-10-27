/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.gamelife;

public class Field {

  private final int xSize;
  private final int ySize;
  private final int[][] field;

  public Field(int xSize, int ySize) {
    this.xSize = xSize;
    this.ySize = ySize;

    field = new int[xSize + 2][ySize + 2];
  }

  public Field(int xSize, int ySize, int[][] field) {
    this.xSize = xSize;
    this.ySize = ySize;

    this.field = field;
  }

  public void parse(String text) {
    String[] lines = text.split("\n");
    char[] line;

    for (int i = 1; i <= ySize; i++) {
      line = lines[i - 1].replace(" ", "").toCharArray();

      for (int j = 1; j <= xSize; j++) {
        if (line[j - 1] == 'X') {
          createCell(j, i);
        }
      }
    }
  }

  public void createCell(int x, int y) {
    field[x][y] = 1;
  }

  public void killCell(int x, int y) {
    field[x][y] = 0;
  }

  public void fakeMirror() {
    field[0][0] = field[xSize][ySize];
    field[xSize + 1][0] = field[1][ySize];
    field[xSize + 1][ySize + 1] = field[1][1];
    field[0][ySize + 1] = field[xSize][1];

    for (int i = 1; i <= xSize; i++) {
      field[i][0] = field[i][ySize];
      field[xSize + 1][i] = field[1][i];
      field[i][ySize + 1] = field[i][1];
      field[0][i] = field[xSize][i];
    }
  }

  public boolean isAlive(int x, int y) {
    return field[x][y] == 1;
  }

  public int numberOfNearestAlive(int x, int y) {

    return field[x - 1][y - 1] +
        field[x - 1][y] +
        field[x - 1][y + 1] +
        field[x][y - 1] +
        field[x][y + 1] +
        field[x + 1][y - 1] +
        field[x + 1][y] +
        field[x + 1][y + 1];

  }

  public int[][] getField() {
    return field;
  }

  public int getxSize() {
    return xSize;
  }

  public int getySize() {
    return ySize;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 1; i <= ySize; i++) {
      for (int j = 1; j <= xSize; j++) {
        if (field[j][i] == 1) {
          stringBuilder.append("X ");
        } else {
          stringBuilder.append("O ");
        }
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

}
