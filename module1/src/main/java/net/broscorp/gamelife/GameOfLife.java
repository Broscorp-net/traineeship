package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class GameOfLife {

  private char[][] grid;
  private int rows;
  private int columns;
  private int iterations;

  /**
   * run game of life.
   * @param fileNameInput input file
   * @param fileNameOutput output file
   */
  public void game(String fileNameInput, String fileNameOutput) {
    try {
      readFile(fileNameInput);
      mainIteration();
      writeFile(fileNameOutput);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  private void mainIteration() {
    for (int i = 0; i < iterations; i++) {
      char[][] newCells = new char[columns][rows];
      for (int j = 0; j < columns; j++) {
        for (int k = 0; k < rows; k++) {
          refreshGrid(newCells, j, k);
        }
      }
      grid = newCells;
    }
  }

  private boolean checkForGridX(int y, int x) {
    return (grid[(y + columns) % columns][(x + rows) % rows] == 'X');
  }

  private void refreshGrid(char[][] newGrid, int y, int x) {
    int neighbors = checkNeighbors(y, x);
    if (checkForGridX(y, x)) {
      newGrid[y][x] = neighbors > 1 && neighbors < 4 ? 'X' : 'O';
    } else {
      newGrid[y][x] = neighbors == 3 ? 'X' : 'O';
    }
  }

  private int checkNeighbors(int y, int x) {
    int count = 0;

    count += checkForGridX(y + 1, x + 1) ? 1 : 0;
    count += checkForGridX(y + 1, x) ? 1 : 0;
    count += checkForGridX(y + 1, x - 1) ? 1 : 0;
    count += checkForGridX(y, x + 1) ? 1 : 0;
    count += checkForGridX(y, x - 1) ? 1 : 0;
    count += checkForGridX(y - 1, x - 1) ? 1 : 0;
    count += checkForGridX(y - 1, x) ? 1 : 0;
    count += checkForGridX(y - 1, x + 1) ? 1 : 0;

    return count;
  }

  private void readFile(String fileNameInput) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(fileNameInput))));

    String input = bufferedReader.readLine();
    String[] settingsReader = input.split(",");

    columns = Integer.parseInt(settingsReader[0]);
    rows = Integer.parseInt(settingsReader[1]);
    iterations = Integer.parseInt(settingsReader[2]);
    grid = new char[columns][rows];

    for (int y = 0; y < columns; y++) {
      input = bufferedReader.readLine();
      input = input.replaceAll(" ", "");
      for (int x = 0; x < rows; x++) {
        grid[y][x] = input.charAt(x);
      }
    }
    bufferedReader.close();
  }

  private void writeFile(String fileNameOutput) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("./src/test/resources/" + fileNameOutput));

    StringBuilder result = new StringBuilder();

    for (int y = 0; y < columns; y++) {
      for (int x = 0; x < rows; x++) {
        result.append(grid[y][x]).append(" ");
      }
      result = new StringBuilder(result.substring(0, result.length() - 1) + "\n");
    }
    result = new StringBuilder(result.substring(0, result.length() - 1));
    bufferedWriter.write(result.toString());
    bufferedWriter.close();
  }
}
