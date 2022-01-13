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

  // Following properties determines the game parameters and current status

  // number of rows in the field
  int rowsNum;

  // number of columns in the field
  int colsNum;

  // Current field status: true for live cell
  boolean[][] field;

  // Number of game iterations left
  int iterations;

  // Following constants represent the game rules

  static final int LIVE_UNDERPOPULATION_THRESHOLD = 2;
  static final int LIVE_OVERPOPULATION_THRESHOLD = 3;
  static final int DEAD_REPRODUCTION_MATCH = 3;

  // Following constants represent the output coding of field values

  static final char ALIVE = 'X';
  static final char DEAD = 'O';
  static final char DELIMITER = ' ';

  void parseGameParameters(String firstLine) {

    String[] params = firstLine.split(",");

    rowsNum = Integer.parseInt(params[0]);
    colsNum = Integer.parseInt(params[1]);
    iterations = Integer.parseInt(params[2]);
  }

  boolean parseValue(String fieldVal) {
    return fieldVal.charAt(0) == ALIVE;
  }

  void parseGameField(List<String> gameListInput) {

    field = new boolean[rowsNum][colsNum];

    for (int row = 0; row <= rowsNum - 1; row++) {

      String[] rowValues = gameListInput.get(row).split(" ");

      for (int col = 0; col <= colsNum - 1; col++) {
        field[row][col] = parseValue(rowValues[col]);
      }
    }
  }

  void loadGame(String fileNameInput) {

    Stream<String> gameStreamInput = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput))).lines();
    List<String> gameListInput = gameStreamInput.collect(Collectors.toList());

    parseGameParameters(gameListInput.remove(0));

    parseGameField(gameListInput);
  }

  boolean isAlive(int col, int row) {
    return field[row][col];
  }

  int calculateLiveNeighbours(int col, int row) {
    int liveNeighboursCount = 0;

    for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {
      int checkedRow = (row + rowDelta + rowsNum) % rowsNum;

      for (int colDelta = -1; colDelta <= 1; colDelta++) {
        int checkedCol = (col + colDelta + colsNum) % colsNum;

        // check all entries in 3x3 array except for itself
        if (!(rowDelta == 0 && colDelta == 0)) {
          liveNeighboursCount += isAlive(checkedCol, checkedRow) ? 1 : 0;
        }
      }
    }

    return liveNeighboursCount;
  }

  boolean determineNextState(int col, int row) {

    int liveNeighbours = calculateLiveNeighbours(col, row);

    if (isAlive(col, row)) {
      return liveNeighbours >= LIVE_UNDERPOPULATION_THRESHOLD
          && liveNeighbours <= LIVE_OVERPOPULATION_THRESHOLD;
    } else {
      return liveNeighbours == DEAD_REPRODUCTION_MATCH;
    }

  }

  void calculateIteration() {

    boolean[][] nextIterField = new boolean[rowsNum][colsNum];

    for (int row = 0; row <= rowsNum - 1; row++) {
      for (int col = 0; col <= colsNum - 1; col++) {
        nextIterField[row][col] = determineNextState(col, row);
      }
    }

    field = nextIterField;
  }

  void saveGame(String fileNameOutput) {

    StringBuilder output = new StringBuilder();

    for (int row = 0; row <= rowsNum - 1; row++) {

      if (row > 0) {
        output.append(System.lineSeparator());
      }

      for (int col = 0; col <= colsNum - 1; col++) {

        if (col > 0) {
          output.append(DELIMITER);
        }

        char charAtField = field[row][col] ? ALIVE : DEAD;
        output.append(charAtField);

      }
    }

    String path = GameOfLife.class.getClassLoader().getResource(".").getFile() + fileNameOutput;

    // This is a temporary fix for a backslash encoded by "%5C" (issue occurs on local PC)
    // Cause needs to be investigated to identify a robust solution
    // This a temporary quick fix for submitting of a task purpose
    // Thank you for your understanding!
    path = path.replaceAll("%5C","/");

    File file = new File(path);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(output.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Implementation of a GameOfLife calculation.
   * @param fileNameInput - name of file with input configuration
   * @param fileNameOutput - name of the output file
   */
  public void game(String fileNameInput, String fileNameOutput) {

    loadGame(fileNameInput);

    while (iterations-- > 0) {
      calculateIteration();
    }

    saveGame(fileNameOutput);
  }

}
