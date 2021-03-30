package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  /**
   * This is method for run main functional.
   * @param fileNameInput file with base data
   * @param fileNameOutput result file
   */
  public void game(String fileNameInput, String fileNameOutput) {

    List<String> gameStartedList = readFromFile(fileNameInput);

    int cycles = numberLifeCycles(gameStartedList);

    boolean[][] startAreaOfLifeCycle = areaOfLife(gameStartedList);

    boolean[][] finishAreaLifeCycle = startAreaOfLifeCycle;


    for (int i = 0; i < cycles; i++) {
      finishAreaLifeCycle  = nextStepLifeCycle(finishAreaLifeCycle);
    }

    List<String> listForWriteToFile = getPreparedDataFoWrite(finishAreaLifeCycle);

    writeToFile(fileNameOutput, listForWriteToFile);

  }

  /**
   * Return random area life cycle.
   * @param n row
   * @param m column
   * @return random area
   */
  public boolean[][] areaOfLife(int n, int m) {
    boolean[][] randomAreaOfLife = new boolean[n][m];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        randomAreaOfLife[i][j] = random.nextBoolean();
      }
    }
    return randomAreaOfLife;
  }

  /**
   * Return area life from list.
   * @param gameStartedList source information
   * @return current area
   */
  public boolean[][] areaOfLife(List<String> gameStartedList) {

    String[] firstString = gameStartedList.get(0).trim().split(",");
    //n - number row
    int n = Integer.parseInt(firstString[0]);
    //m - number column
    int m = Integer.parseInt(firstString[1]);

    boolean[][]  fromFileAreaOfLife = new boolean[n][m];

    for (int i = 0; i < fromFileAreaOfLife.length; i++) {
      String[] rowAreaOfLife = gameStartedList.get(i + 1).split("\\s");
      for (int j = 0; j < fromFileAreaOfLife[0].length; j++) {
        fromFileAreaOfLife[i][j] = rowAreaOfLife[j].charAt(0) == 'X' ? true : false;

      }
    }
    return fromFileAreaOfLife;
  }

  /**
   * Return number life cycles.
   * @param gameStartedList A source information
   * @return number cycles
   */
  public int numberLifeCycles(List<String> gameStartedList) {
    int cycle = 0;
    String[] firstString = gameStartedList.get(0).trim().split(",");
    cycle = Integer.parseInt(firstString[2]);
    return cycle;
  }

  /**
   * One iteration life cycle.
   * @param previousLifeCycle previous result cycles
   * @return result current life cycle
   */
  public boolean[][] nextStepLifeCycle(boolean[][] previousLifeCycle) {
    boolean[][] nextLifeCycle = new boolean[previousLifeCycle.length][previousLifeCycle[0].length];
    int numberOfLivingNeighbors = 0;
    for (int i = 0; i < previousLifeCycle.length; i++) {
      for (int j = 0; j < previousLifeCycle[0].length; j++) {
        numberOfLivingNeighbors = numberOfLivingNeighbors(previousLifeCycle, i, j);
        if (!previousLifeCycle[i][j]) {
          if (numberOfLivingNeighbors == 3) {
            nextLifeCycle[i][j] = true;
          }
        }

        if (previousLifeCycle[i][j]) {
          if ((numberOfLivingNeighbors == 2) || (
              numberOfLivingNeighbors == 3)) {
            nextLifeCycle[i][j] = true;
          }
        }
      }
    }
    return nextLifeCycle;

  }

  /**
    * Returned number living neighbors.
    * @param currentAreaOfLife current array
    * @param currentPositionX position x
    * @param currentPositionY position y
    * @return number neighbors
   */
  public int numberOfLivingNeighbors(boolean[][] currentAreaOfLife, int currentPositionX,
      int currentPositionY) {
    int livingNeighbors = 0;
    int neighborPositionX = 0;
    int neighborPositionY = 0;
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if ((i == 0) && (j == 0)) {
          continue;
        }
        neighborPositionX = getNeighborPosition(currentAreaOfLife.length, currentPositionX, i);
        neighborPositionY = getNeighborPosition(currentAreaOfLife.length, currentPositionY, j);
        if (currentAreaOfLife[neighborPositionX][neighborPositionY]) {
          livingNeighbors++;
        }
      }
    }
    return livingNeighbors;
  }

  /**
    * Returned position for neighbor.
    * @param maxValue max value row or column
    * @param currentPosition position current's cell
    * @param step iterator value
    * @return actual position
   */
  public int getNeighborPosition(int maxValue, int currentPosition, int step) {

    int neighborPosition = (step + currentPosition + maxValue) % maxValue;

    return neighborPosition;

  }

  /**
    * Geted list strings from arrays for write to file.
    * @param finishAreaLifeCycle area life cycle to write
    * @return list strings
   */
  public List<String> getPreparedDataFoWrite(boolean[][] finishAreaLifeCycle) {
    List<String> preparedListDataForWrite = new ArrayList<>();

    for (int i = 0; i < finishAreaLifeCycle.length; i++) {
      StringBuilder stringBuilderForWriteToFile = new StringBuilder();
      for (int j = 0; j < finishAreaLifeCycle[0].length; j++) {
        stringBuilderForWriteToFile.append(finishAreaLifeCycle[i][j] ? 'X' : 'O');
        if (j == finishAreaLifeCycle[0].length - 1) {
          stringBuilderForWriteToFile.append(System.lineSeparator());
        } else {
          stringBuilderForWriteToFile.append(" ");
        }
      }
      preparedListDataForWrite.add(stringBuilderForWriteToFile.toString().trim());
    }
    return preparedListDataForWrite;
  }

  /**
    * Write to file finish data life cycle's.
    * @param fileNameOutput name output file
    * @param listPreparedToWrite list prepared data
   */
  public void writeToFile(String fileNameOutput, List<String> listPreparedToWrite) {

    ClassLoader classLoader = GameOfLife.class.getClassLoader();
    try {
      URI uri = classLoader.getSystemResource(fileNameOutput).toURI();
      Path pathToFile = Paths.get(uri);

      try (BufferedWriter bufferedWriter = Files
              .newBufferedWriter(pathToFile, StandardCharsets.UTF_8)) {
        for (String row : listPreparedToWrite) {
          bufferedWriter.write(row);
          bufferedWriter.write(System.lineSeparator());
        }
      }
    } catch (URISyntaxException | IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  /**
    * Read data from input file.
    * @param fileNameInput name input file
    * @return list data from source
   */
  public List<String>  readFromFile(String fileNameInput) {

    ClassLoader classLoader = GameOfLife.class.getClassLoader();
    Stream<String> gameStreamInput = new BufferedReader(
            new InputStreamReader(classLoader.getSystemResourceAsStream(fileNameInput))).lines();
    List<String> gameStartDataList = gameStreamInput.collect(Collectors.toList());
    return gameStartDataList;

  }

}
