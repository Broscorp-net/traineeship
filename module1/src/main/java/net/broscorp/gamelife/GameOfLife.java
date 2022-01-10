package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  // Following properties determines the game parameters and current status

  // size of field
  int xSize, ySize;

  // Two dimensional array (can contain X or O)
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

    xSize = Integer.parseInt(params[0]);
    ySize = Integer.parseInt(params[1]);
    iterations = Integer.parseInt(params[2]);
  }

  boolean parseValue(String fieldVal) {
    return fieldVal.charAt(0) == ALIVE;
  }

  void parseGameField(List<String> gameListInput) {

    field = new boolean[ySize][xSize];

    for (int yLoc = 0; yLoc <= ySize - 1; yLoc++) {
      for (int xLoc = 0; xLoc <= xSize - 1; xLoc++) {

        String row = gameListInput.get(yLoc);
        for (String fieldVal : row.split(" ")) {
          field[yLoc][xLoc] = parseValue(fieldVal);
        }
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

  boolean isAlive(int xLoc, int yLoc) {
    return field[xLoc][yLoc];
  }

  int getLeftColNum(int xLoc) {
    if (xLoc >= 1) {
      return xLoc - 1;
    } else {
      return xSize - 1;
    }
  }

  int getRightColNum(int xLoc) {
    if (xLoc <= xSize - 2) {
      return xLoc + 1;
    } else {
      return 0;
    }
  }

  int getUpperRowNum(int yLoc) {
    if (yLoc >= 1) {
      return yLoc - 1;
    } else {
      return ySize - 1;
    }
  }

  int getLowerRowNum(int yLoc) {
    if (yLoc <= ySize - 2) {
      return yLoc + 1;
    } else {
      return 0;
    }
  }

  int calculateLiveNeighbours(int xLoc, int yLoc) {
    int liveNeighboursCount = 0;

    int leftColNum = getLeftColNum(xLoc);
    int rightColNum = getRightColNum(xLoc);
    int upperRowNum = getUpperRowNum(yLoc);
    int lowerRowNum = getLowerRowNum(yLoc);

    liveNeighboursCount += isAlive(leftColNum, upperRowNum) ? 1 : 0;
    liveNeighboursCount += isAlive(xLoc, upperRowNum) ? 1 : 0;
    liveNeighboursCount += isAlive(rightColNum, upperRowNum) ? 1 : 0;
    liveNeighboursCount += isAlive(leftColNum, yLoc) ? 1 : 0;
    liveNeighboursCount += isAlive(rightColNum, yLoc) ? 1 : 0;
    liveNeighboursCount += isAlive(leftColNum, lowerRowNum) ? 1 : 0;
    liveNeighboursCount += isAlive(xLoc, lowerRowNum) ? 1 : 0;
    liveNeighboursCount += isAlive(rightColNum, lowerRowNum) ? 1 : 0;

    return liveNeighboursCount;
  }

  boolean determineNextState(int xLoc, int yLoc) {

    int liveNeighbours = calculateLiveNeighbours(xLoc, yLoc);

    if (isAlive(xLoc, yLoc)) {
      return liveNeighbours >= LIVE_UNDERPOPULATION_THRESHOLD &&
          liveNeighbours <= LIVE_OVERPOPULATION_THRESHOLD;
    } else {
      return liveNeighbours == DEAD_REPRODUCTION_MATCH;
    }

  }

  void calculateIteration() {

    boolean[][] nextIterField = new boolean[xSize][ySize];

    for (int xLoc = 0; xLoc < xSize; xLoc++) {
      for (int yLoc = 0; yLoc < ySize; yLoc++) {
        nextIterField[xLoc][yLoc] = determineNextState(xLoc, yLoc);
      }
    }

    field = nextIterField;
  }

  void saveGame(String fileNameOutput) {

    StringBuilder output = new StringBuilder();

    for (int yLoc = 0; yLoc <= ySize - 1; yLoc++) {
      for (int xLoc = 0; xLoc <= xSize - 1; xLoc++) {

        char charAtField = field[yLoc][xLoc] ? ALIVE : DEAD;
        output.append(charAtField);
        output.append(DELIMITER);
      }

      output.append(System.lineSeparator());

    }

    // FOR DEBUG PURPOSES
    System.out.println(output.toString());

    File file = new File(GameOfLife.class.getClassLoader().getResource(".").getFile() + fileNameOutput);

    // FOR DEBUG PURPOSES
    System.out.println(file.getPath());

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(output.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public void game(String fileNameInput, String fileNameOutput){

    loadGame(fileNameInput);

    while (iterations-- > 0) {
      calculateIteration();
    }

    saveGame(fileNameOutput);
  }

}
