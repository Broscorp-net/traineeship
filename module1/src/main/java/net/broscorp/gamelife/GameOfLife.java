package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  private int[][] generateDualArray;
  private int iter;
  private int rows;
  private int columns;

  /**
   * The method that launches the game.
   * Rules:
   * - Any live cell with fewer than two live neighbours
   * dies, as if by underpopulation.
   * - Any live cell with two or three live neighbours lives on to
   * the next generation.
   * - Any live cell with more than three live neighbours dies, as if by
   * overpopulation.
   * - Any dead cell with exactly three live neighbours becomes a live cell, as if
   * by reproduction.
   *
   * @param fileNameInput  - incoming file for Game
   * @param fileNameOutput - output file for Game
   */
  public void game(String fileNameInput, String fileNameOutput) {
    List<String> list = readFile(fileNameInput);
    if (list != null) {
      createDualArrays(list);
      for (int i = 0; i < iter; i++) {
        nextGeneration();
      }
      writeFile(fileNameOutput);
    } else {
      throw new NullPointerException();
    }
  }

  private void generateSizes(String s) {
    String[] arr = s.split(",");
    int[] sizes = new int[3];
    for (int i = 0; i < sizes.length; i++) {
      sizes[i] = Integer.parseInt(arr[i]);
    }
    rows = sizes[0];
    columns = sizes[1];
    iter = sizes[2];
  }

  private void createDualArrays(List<String> stringList) {
    generateSizes(stringList.get(0));
    generateDualArray = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      String[] arr = stringList.get(i + 1).split(" ");
      for (int j = 0; j < columns; j++) {
        if (arr[j].equals("O")) {
          generateDualArray[i][j] = 0;
        } else {
          generateDualArray[i][j] = 1;
        }
      }
    }
  }

  private void nextGeneration() {
    int[][] futureArr = new int[rows][columns];

    for (int l = 0; l < rows; l++) {
      for (int m = 0; m < columns; m++) {

        int aliveNeighbours = aliveNeighbors(rows, columns, l, m);

        if ((generateDualArray[l][m] == 1) && (aliveNeighbours < 2)) {
          futureArr[l][m] = 0;
        } else if ((generateDualArray[l][m] == 1) && (aliveNeighbours > 3)) {
          futureArr[l][m] = 0;
        } else if ((generateDualArray[l][m] == 0) && (aliveNeighbours == 3)) {
          futureArr[l][m] = 1;
        } else {
          futureArr[l][m] = generateDualArray[l][m];
        }
      }
    }
    generateDualArray = futureArr;
  }

  /**
   * A method that defines living neighbors.
   *
   * @param m - max by rows
   * @param n - max by column
   * @param i - index by rows
   * @param j - index by column
   * @return number alive neighbors
   */
  public int aliveNeighbors(int m, int n, int i, int j) {
    int alive = 0;
    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        alive += generateDualArray[(i + x + m) % m][(j + y + n) % n];
      }
    }
    alive -= generateDualArray[i][j];
    return alive;
  }

  private List<String> readFile(String fileName) {
    Stream<String> gameStreamResult = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))).lines();
    return gameStreamResult.collect(Collectors.toList());
  }

  private void writeFile(String fileName) {

    StringBuilder stringBuilder = new StringBuilder();
    for (int l = 0; l < rows; l++) {
      for (int m = 0; m < columns; m++) {
        if (generateDualArray[l][m] == 0) {
          stringBuilder.append("O");
        } else {
          stringBuilder.append("X");
        }
        if (m != columns - 1) {
          stringBuilder.append(" ");
        }
      }
      if (l != rows - 1) {
        stringBuilder.append("\n");
      }
    }
    File file = new File(GameOfLife.class.getClassLoader().getResource(".").getFile() + fileName);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(stringBuilder.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
