/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.gamelife;

public class BoringField {

  private final int axisX;
  private final int axisY;
  private final int[][] field;

  /**
   * Constructor for a field.
   *
   * @param axisX length of x-axis
   * @param axisY length of y-axis
   */
  public BoringField(int axisX, int axisY) {
    this.axisX = axisX;
    this.axisY = axisY;

    field = new int[axisX][axisY];
  }

  /**
   * Constructor for a field.
   *
   * @param axisX length of x-axis
   * @param axisY length of y-axis
   * @param field existent field
   */

  public BoringField(int axisX, int axisY, int[][] field) {
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

    for (int i = 0; i < axisY; i++) {
      line = lines[i].replace(" ", "").toCharArray();

      for (int j = 0; j < axisX; j++) {
        if (line[j] == 'X') {
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

  public boolean isAlive(int x, int y) {
    return field[x][y] == 1;
  }

  /**
   * Method to get a right cell in case of referring to out of bound element.
   *
   * @param x x axis position
   * @param y y axis position
   * @return returns an opposite cell in case it is out of bound and the same cell in other cases.
   */
  public int getSafeCellState(int x, int y) {
    return field[(x + axisX) % axisX][(y + axisY) % axisY];
  }

  /**
   * Number of living cells in a radius.
   *
   * @param x x-axis coordinate of cell
   * @param y y-axis coordinate of cell
   * @return number of living cells
   */
  public int numberOfNearestAlive(int x, int y) {

    return getSafeCellState(x - 1, y - 1)
        + getSafeCellState(x - 1, y)
        + getSafeCellState(x - 1, y + 1)
        + getSafeCellState(x, y - 1)
        + getSafeCellState(x, y + 1)
        + getSafeCellState(x + 1, y - 1)
        + getSafeCellState(x + 1, y)
        + getSafeCellState(x + 1, y + 1);

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
    for (int i = 0; i < axisY; i++) {
      for (int j = 0; j < axisX; j++) {
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
