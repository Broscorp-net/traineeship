/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.gamelife;

public class Field {

  private final int axisX;
  private final int axisY;
  private final int[][] field;

  /**
   * Constructor for a field.
   *
   * @param axisX length of x-axis
   * @param axisY length of y-axis
   */

  public Field(int axisX, int axisY) {
    this.axisX = axisX;
    this.axisY = axisY;

    field = new int[axisX + 2][axisY + 2];
  }

  /**
   * Constructor for a field.
   *
   * @param axisX length of x-axis
   * @param axisY length of y-axis
   * @param field existent field
   */

  public Field(int axisX, int axisY, int[][] field) {
    this.axisX = axisX;
    this.axisY = axisY;

    this.field = field;
  }

  /**
   * Parses field from a text file.
   *
   * @param text text to parse from
   */
  public void parse(String text) {
    String[] lines = text.split("\n");
    char[] line;

    for (int i = 1; i <= axisY; i++) {
      line = lines[i - 1].replace(" ", "").toCharArray();

      for (int j = 1; j <= axisX; j++) {
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

  /**
   * Fills the outer border of array, mirroring the opposite cells.
   */
  public void fakeMirror() {
    field[0][0] = field[axisX][axisY];
    field[axisX + 1][0] = field[1][axisY];
    field[axisX + 1][axisY + 1] = field[1][1];
    field[0][axisY + 1] = field[axisX][1];

    for (int i = 1; i <= axisX; i++) {
      field[i][0] = field[i][axisY];
      field[i][axisY + 1] = field[i][1];
    }

    for (int i = 1; i <= axisY; i++) {
      field[axisX + 1][i] = field[1][i];
      field[0][i] = field[axisX][i];
    }
  }

  public boolean isAlive(int x, int y) {
    return field[x][y] == 1;
  }

  /**
   * Number of living cells in a radius.
   *
   * @param x x-axis coordinate of cell
   * @param y y-axis coordinate of cell
   * @return number of living cells
   */
  public int numberOfNearestAlive(int x, int y) {

    return field[x - 1][y - 1]
        + field[x - 1][y]
        + field[x - 1][y + 1]
        + field[x][y - 1]
        + field[x][y + 1]
        + field[x + 1][y - 1]
        + field[x + 1][y]
        + field[x + 1][y + 1];

  }

  public int[][] getField() {
    return field;
  }

  public int getAxisX() {
    return axisX;
  }

  public int getAxisY() {
    return axisY;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 1; i <= axisY; i++) {
      for (int j = 1; j <= axisX; j++) {
        if (field[j][i] == 1) {
          stringBuilder.append("X ");
        } else {
          stringBuilder.append("O ");
        }
      }
      stringBuilder.setLength(stringBuilder.length() - 1);
      stringBuilder.append("\n");
    }
    return stringBuilder.substring(0, stringBuilder.length() - 1);
  }

}
