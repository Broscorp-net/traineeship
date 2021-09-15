package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  /** The method for calculating the Game of Life.
   *
   * @param fileNameInput contains initial data of the game.
   * @param fileNameOutput contains the result of the calculation.
   */
  public void game(String fileNameInput, String fileNameOutput) {
    Configuration config = parse(readFromFile(fileNameInput));

    int iterations = config.getIterations();
    int rows = config.getRows();
    int columns = config.getColumns();
    byte[][] currentGeneration = config.getInitialFigure();

    while (iterations > 0) {
      currentGeneration = calculateNewGeneration(currentGeneration, rows, columns);
      iterations--;
    }

    writeToFile(fileNameOutput, convertToString(currentGeneration));
  }

  private byte[][] calculateNewGeneration(byte[][] previousGeneration, int rows, int columns) {
    byte[][] nextGeneration = new byte[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {

        int sum =
              previousGeneration[mod(i - 1, rows)][mod(j - 1, columns)]
            + previousGeneration[mod(i - 1, rows)][mod(j, columns)]
            + previousGeneration[mod(i - 1, rows)][mod(j + 1, columns)]

            + previousGeneration[mod(i, rows)][mod(j - 1, columns)]
            + previousGeneration[mod(i, rows)][mod(j, columns)]
            + previousGeneration[mod(i, rows)][mod(j + 1, columns)]

            + previousGeneration[mod(i + 1, rows)][mod(j - 1, columns)]
            + previousGeneration[mod(i + 1, rows)][mod(j, columns)]
            + previousGeneration[mod(i + 1, rows)][mod(j + 1, columns)];

        nextGeneration[i][j] = (sum == 4) ? previousGeneration[i][j] : (sum == 3 ? (byte) 1 : 0);

      }
    }
    return nextGeneration;
  }

  private int mod(int index, int divisor) {
    return (index + divisor) % divisor;
  }

  private Configuration parse(List<String> inputData) {
    // parse the first line into args
    String[] args = inputData.remove(0).split(",");
    int rows = Integer.parseInt(args[0]);
    int columns = Integer.parseInt(args[1]);
    int iterations = Integer.parseInt(args[2]);

    byte[][] inputFigure = convertToMatrix(inputData, rows, columns);

    return new Configuration(rows, columns, iterations, inputFigure);
  }

  private String convertToString(byte[][] matrix) {
    StringBuilder figureBuilder = new StringBuilder();
    int columns = matrix[0].length;

    for (byte[] bytes : matrix) {
      for (int j = 0; j < columns; j++) {
        char character = (bytes[j] == 1) ? 'X' : 'O';
        figureBuilder.append(character).append(' ');
      }
      figureBuilder.deleteCharAt(figureBuilder.length() - 1).append('\n');
    }
    return figureBuilder.deleteCharAt(figureBuilder.length() - 1).toString();
  }

  private byte[][] convertToMatrix(List<String> figure, int rows, int columns) {
    String[] figureValues = String.join(" ", figure).split(" ");

    if (figureValues.length != (rows * columns)) {
      throw new RuntimeException("Invalid input data");
    }

    byte[][] matrix = new byte[rows][columns];
    int offset = 0;

    for (int i = 0; i < rows; i++, offset += columns) {
      for (int j = 0; j < columns; j++) {
        byte value = figureValues[j + offset].equals("X") ? (byte) 1 : 0;
        matrix[i][j] = value;
      }
    }

    return matrix;
  }

  private List<String> readFromFile(String inputFileName) {
    try {
      Stream<String> inputStream = new BufferedReader(new FileReader(getFilePath(inputFileName)))
          .lines();
      return inputStream.collect(Collectors.toList());
    } catch (FileNotFoundException e) {
      throw new RuntimeException("File " + inputFileName + " not found", e);
    }
  }

  private void writeToFile(String outputFileName, String resultFigure) {
    File file = new File(getFilePath(outputFileName));
    try (PrintWriter out = new PrintWriter(new FileWriter(file, false))) {
      out.println(resultFigure);
    } catch (IOException e) {
      throw new RuntimeException("File " + outputFileName + " not found", e);
    }
  }

  private String getFilePath(String fileName) {
    return Objects.requireNonNull(getClass().getClassLoader().getResource("."))
      .getFile() + fileName;
  }

  private class Configuration {

    private final int rows;
    private final int columns;
    private final int iterations;
    private final byte[][] initialFigure;

    public Configuration(int rows, int columns, int iterations, byte[][] initialFigure) {
      this.rows = rows;
      this.columns = columns;
      this.iterations = iterations;
      this.initialFigure = initialFigure;
    }

    public int getRows() {
      return rows;
    }

    public int getColumns() {
      return columns;
    }

    public int getIterations() {
      return iterations;
    }

    public byte[][] getInitialFigure() {
      return initialFigure;
    }
  }

}
