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

  /**
   * The method that launches the game. Rules: - Any live cell with fewer than two live neighbours
   * dies, as if by underpopulation. - Any live cell with two or three live neighbours lives on to
   * the next generation. - Any live cell with more than three live neighbours dies, as if by
   * overpopulation. - Any dead cell with exactly three live neighbours becomes a live cell, as if
   * by reproduction.
   *
   * @param fileNameInput  - incoming file for Game
   * @param fileNameOutput - output file for Game
   */
  public void game(String fileNameInput, String fileNameOutput) {
    List<String> list = readFile(fileNameInput);
    int[] sizes = readSizes(list.get(0));
    int rows = sizes[0];
    int columns = sizes[1];
    int iter = sizes[2];

    int[][] dualArray = createDualArrays(list, rows, columns);
    for (int i = 0; i < iter; i++) {
      dualArray = nextGeneration(dualArray);
    }
    writeToFile(fileNameOutput, dualArray);
  }

  private int[] readSizes(String s) {
    String[] arr = s.split(",");
    int[] sizes = new int[3];
    for (int i = 0; i < sizes.length; i++) {
      sizes[i] = Integer.parseInt(arr[i]);
    }
    return sizes;
  }

  private int[][] createDualArrays(List<String> stringList, int rows, int columns) {
    int[][] dualArray = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      String[] arr = stringList.get(i + 1).split(" ");
      for (int j = 0; j < columns; j++) {
        if (arr[j].equals("O")) {
          dualArray[i][j] = 0;
        } else {
          dualArray[i][j] = 1;
        }
      }
    }
    return dualArray;
  }

  private int[][] nextGeneration(int[][] dualArray) {
    int rows = dualArray.length;
    int columns = dualArray[0].length;

    int[][] futureArr = new int[rows][columns];

    for (int l = 0; l < rows; l++) {
      for (int m = 0; m < columns; m++) {

        int aliveNeighbours = definitionAliveNeighbors(dualArray, rows, columns, l, m);

        if ((dualArray[l][m] == 1) && (aliveNeighbours < 2)) {
          futureArr[l][m] = 0;
        } else if ((dualArray[l][m] == 1) && (aliveNeighbours > 3)) {
          futureArr[l][m] = 0;
        } else if ((dualArray[l][m] == 0) && (aliveNeighbours == 3)) {
          futureArr[l][m] = 1;
        } else {
          futureArr[l][m] = dualArray[l][m];
        }
      }
    }
    return futureArr;
  }

  /**
   * A method that defines living neighbors.
   *
   * @param dualArray      - array with elements
   * @param numberRows     - number of rows
   * @param numberColumns  - number of column
   * @param indexByRows    - index by rows
   * @param indexByColumns - index by columns
   * @return number alive neighbors
   */
  public int definitionAliveNeighbors(int[][] dualArray, int numberRows, int numberColumns,
      int indexByRows, int indexByColumns) {
    int alive = 0;
    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        int neighborIndexByRows = (indexByRows + x + numberRows) % numberRows;
        int neighborIndexByColumns = (indexByColumns + y + numberColumns) % numberColumns;

        alive += dualArray[neighborIndexByRows][neighborIndexByColumns];
      }
    }
    alive -= dualArray[indexByRows][indexByColumns];
    return alive;
  }

  private List<String> readFile(String fileName) {
    Stream<String> gameStreamResult = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))).lines();
    return gameStreamResult.collect(Collectors.toList());
  }

  private void writeToFile(String fileName, int[][] dualArray) {

    StringBuilder stringBuilder = new StringBuilder();
    int rows = dualArray.length;
    int columns = dualArray[0].length;
    for (int l = 0; l < rows; l++) {
      for (int m = 0; m < columns; m++) {
        if (dualArray[l][m] == 0) {
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
