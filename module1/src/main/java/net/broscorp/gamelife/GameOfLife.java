package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {
  // Two grids represent two states: before and after iteration.
  private char[][] startGrid;
  private char[][] nextGrid;
  // Parameters.
  private int rowSize;
  private int colSize;
  private int numberOfIteration;
  // Rules param.
  private static final int MIN_NUMBER_OF_NEIGHBORS_FOR_ALIVE = 2;
  private static final int MAX_NUMBER_OF_NEIGHBORS_FOR_ALIVE = 3;
  private static final int NUM_NEIGHBORS_FOR_RESURRECTION = 3;
  // X -> alive cell.
  // O -> dead cell.
  private static final char ALIVE = 'X';
  private static final char DEAD = 'O';
  // Util constants.
  private static final String SPACE = " ";
  private static final String EMPTY = "";
  private static final String COMA = ",";
  private static final String SEPARATOR = "\n";

  /**
   * Main method.
   * @param fileNameInput -> configuration file.
   * @param fileNameOutput -> result file.
   */
  public void game(String fileNameInput, String fileNameOutput) throws IOException {
    readGameData(fileNameInput);
    for (int i = 0; i < numberOfIteration; i++) {
      doIteration();
      startGrid = nextGrid;
    }
    writeResult(fileNameOutput);
  }

  private void parseParam(String param) {
    String[] conf = param.split(COMA);
    rowSize = Integer.parseInt(conf[0]);
    colSize = Integer.parseInt(conf[1]);
    numberOfIteration = Integer.parseInt(conf[2]);
  }

  private void readGameData(String fileNameInput) {
    Stream<String> inputStreams = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(fileNameInput)))).lines();
    List<String> listLine = inputStreams.collect(Collectors.toList());
    parseParam(listLine.get(0));
    startGrid = new char[rowSize][colSize];
    int numberOfLine = 0;
    for (int i = 1; i < listLine.size(); i++) {

      // Parse row. Replace the " " with a "".
      startGrid[numberOfLine] = listLine.get(i).replaceAll(SPACE, EMPTY).toCharArray();
      numberOfLine++;
    }
  }

  private void writeResult(String fileNameOutput) throws IOException {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        builder.append(nextGrid[i][j]);

        // Do not write the last character (" ").
        if (j != colSize - 1) {
          builder.append(SPACE);
        }
      }
      // Do not write the last separator.
      if (i != rowSize - 1) {
        builder.append(SEPARATOR);
      }
    }
    try (BufferedWriter writer = new BufferedWriter(
        new FileWriter((Objects.requireNonNull(GameOfLife.class.getClassLoader()
            .getResource(".")).getFile() + fileNameOutput)
            .replaceAll("%5C","/")))) {
      writer.write(builder.toString());
      writer.flush();
    }
  }

  /**
   * return -> number of alive neighbors.
   * @param i -> number of row.
   * @param j -> number of column.
   */
  private int findNumberOfNeighbors(int i, int j) {
    int numberOfNeighbors = 0;
    for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {
      int checkedRow = findCoorForCyclingField(i, rowDelta, rowSize);

      for (int colDelta = -1; colDelta <= 1; colDelta++) {
        int checkedCol = findCoorForCyclingField(j, colDelta, colSize);

        if (!(rowDelta == 0 && colDelta == 0)
            && startGrid[checkedRow][checkedCol] == ALIVE) {
          numberOfNeighbors++;
        }
      }
    }
    return numberOfNeighbors;
  }

  private int findCoorForCyclingField(int number, int delta, int size) {
    return (number + delta + size) % size;
  }

  private char aliveOrDead(char c, int numberOfNeighbors) {
    if (c == ALIVE) {
      // If "true" then the cell dies.
      if (numberOfNeighbors < MIN_NUMBER_OF_NEIGHBORS_FOR_ALIVE
          || numberOfNeighbors > MAX_NUMBER_OF_NEIGHBORS_FOR_ALIVE) {
        return DEAD;
      }
    } else {
      // If "true" then the cell comes to life.
      if (numberOfNeighbors == NUM_NEIGHBORS_FOR_RESURRECTION) {
        return ALIVE;
      }
    }
    return c;
  }

  private void doIteration() {
    nextGrid = new char[rowSize][colSize];
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        nextGrid[i][j] = aliveOrDead(startGrid[i][j], findNumberOfNeighbors(i, j));
      }
    }
  }
}
