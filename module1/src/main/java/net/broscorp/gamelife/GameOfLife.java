package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameOfLife {
  // Two grids represent two states: before and after iteration.
  private char[][] startGrid;
  private char[][] nextGrid;
  // Parameters.
  private int hSize;
  private int vSize;
  private int numberOfIteration;

  // Rules param.
  private static final int MIN_NUMBER_OF_NEIGHBORS_FOR_ALIVE = 2;
  private static final int MAX_NUMBER_OF_NEIGHBORS_FOR_ALIVE = 3;
  private static final int NUM_NEIGHBORS_FOR_RESURRECTION = 3;
  // X -> alive cell.
  // O -> dead cell.
  private static final char X = 'X';
  private static final char O = 'O';
  // Util constants.
  private static final String SPACE = " ";
  private static final String EMPTY = "";
  private static final String COMA = ",";
  private static final String SEPARATOR = "\n";
  private static final String RELATIVE_PATH = "src\\test\\resources\\";

  /**
   * @param fileNameInput -> file with configuration.
   * @param fileNameOutput -> file result file.
   * */
  public void game(String fileNameInput, String fileNameOutput) {
    try {
      readGameData(fileNameInput);
      for (int i = 0; i < numberOfIteration; i++) {
        doIteration();
        startGrid = nextGrid;
      }
      writeResult(fileNameOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void parseParam(String param) {
    String[] conf = param.split(COMA);
    hSize = Integer.parseInt(conf[0]);
    vSize = Integer.parseInt(conf[1]);
    numberOfIteration = Integer.parseInt(conf[2]);
  }

  private void readGameData(String fileNameInput) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader
        (RELATIVE_PATH + fileNameInput))) {
      parseParam(reader.readLine());

      startGrid = new char[hSize][vSize];
      int numberOfLine = 0;
      while(reader.ready()) {

        // Parse row. Replace the " " with a "".
        startGrid[numberOfLine] = reader.readLine().
            replaceAll(SPACE, EMPTY).toCharArray();
        numberOfLine++;
      }
    }
  }

  private void writeResult(String fileNameOutput) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter
        (RELATIVE_PATH + fileNameOutput))) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < hSize; i++) {
        for (int j = 0; j < vSize; j++) {
          builder.append(nextGrid[i][j]);

          // Do not write the last character (" ").
          if (j != vSize - 1) {
            builder.append(SPACE);
          }
        }
        // Do not write the last separator.
        if (i != hSize - 1) {
          builder.append(SEPARATOR);
        }
      }
      writer.write(builder.toString());
      writer.flush();
    }
  }

  /**
   * @param i -> number of row.
   * @param j -> number of column.
   * @return -> number of alive neighbors.
   * */
  private int findNumberOfNeighbors(int i, int j) {
    int numberOfNeighbors = 0;
    for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {
      int checkedRow = (i + rowDelta + hSize) % hSize;
      for (int colDelta = -1; colDelta <= 1; colDelta++) {
        int checkedCol = (j + colDelta + vSize) % vSize;
        if (!(rowDelta == 0 && colDelta == 0) &&
            startGrid[checkedRow][checkedCol] == X) {
          numberOfNeighbors++;
        }
      }
    }
    return numberOfNeighbors;
  }

  private void doIteration() {
    nextGrid = new char[hSize][vSize];
    for (int i = 0; i < hSize; i++) {
      for (int j = 0; j < vSize; j++) {
        char c = startGrid[i][j];
        int numberOfNeighbors = findNumberOfNeighbors(i, j);
        if (c == X) {
          // If "true" then the cell dies.
          if (numberOfNeighbors < MIN_NUMBER_OF_NEIGHBORS_FOR_ALIVE ||
              numberOfNeighbors > MAX_NUMBER_OF_NEIGHBORS_FOR_ALIVE) {
            c = O;
          }
        } else {
          // If "true" then th cell comes to life.
          if (numberOfNeighbors == NUM_NEIGHBORS_FOR_RESURRECTION) {
            c = X;
          }
        }
        nextGrid[i][j] = c;
      }
    }
  }

}
