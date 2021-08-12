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

  public void game(String fileNameInput, String fileNameOutput) {

    GameData data = parse(readFromFile(fileNameInput));

    int iterations = data.getIterations();
    int rows = data.getRows();
    int columns = data.getColumns();
    byte[][] currentGeneration = data.getInitFigure();

    while (iterations > 0) {
      byte[][] nextGeneration = new byte[rows][columns];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {

          int sum =
            currentGeneration[mod(i - 1, rows)][mod(j - 1, columns)]
              + currentGeneration[mod(i - 1, rows)][mod(j, columns)]
              + currentGeneration[mod(i - 1, rows)][mod(j + 1, columns)]

              + currentGeneration[mod(i, rows)][mod(j - 1, columns)]
              + currentGeneration[mod(i, rows)][mod(j, columns)]
              + currentGeneration[mod(i, rows)][mod(j + 1, columns)]

              + currentGeneration[mod(i + 1, rows)][mod(j - 1, columns)]
              + currentGeneration[mod(i + 1, rows)][mod(j, columns)]
              + currentGeneration[mod(i + 1, rows)][mod(j + 1, columns)];

          nextGeneration[i][j] = (sum == 4) ? currentGeneration[i][j] : (sum == 3 ? (byte) 1 : 0);

        }
      }
      currentGeneration = nextGeneration;
      iterations--;
    }
    writeToFile(fileNameOutput, toString(currentGeneration));
  }

  private int mod(int index, int divisor) {
    int remainder = index % divisor;
    return remainder < 0 ? remainder + divisor : remainder;
  }

  private List<String> readFromFile(String fileName) {
    try {
      Stream<String> inputStream = new BufferedReader(new FileReader(getFilePath(fileName)))
        .lines();
      return inputStream.collect(Collectors.toList());
    } catch (FileNotFoundException e) {
      throw new RuntimeException("File " + fileName + " not found", e);
    }
  }

  private GameData parse(List<String> inputData) {
    String argsLine = inputData.remove(0);
    String[] args = argsLine.split(",");

    int rows = Integer.parseInt(args[0]);
    int columns = Integer.parseInt(args[1]);
    int iterations = Integer.parseInt(args[2]);

    Byte[] oneDimensionalFigure =
      Arrays.stream(String.join(" ", inputData).split(" "))
        .map(s -> s.equals("X") ? (byte) 1 : 0)
        .toArray(Byte[]::new);

    byte[][] inputFigure = convertToMatrix(oneDimensionalFigure, rows, columns);
    return new GameData(rows, columns, iterations, inputFigure);
  }

  private void writeToFile(String fileName, String resultFigure) {
    File file = new File(getFilePath(fileName));
    try (PrintWriter out = new PrintWriter(new FileWriter(file, false))) {
      out.println(resultFigure);
    } catch (IOException e) {
      throw new RuntimeException("File " + fileName + " not found", e);
    }
  }

  private String toString(byte[][] figure) {
    StringBuilder figureBuilder = new StringBuilder();
    int rows = figure.length;
    int columns = figure[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        char character = (figure[i][j] == 1) ? 'X' : 'O';
        figureBuilder.append(character).append(' ');
      }
      figureBuilder.deleteCharAt(figureBuilder.length() - 1).append('\n');
    }
    return figureBuilder.deleteCharAt(figureBuilder.length() - 1).toString();
  }

  private byte[][] convertToMatrix(Byte[] array, int rows, int columns) {
    byte[][] result = new byte[rows][columns];
    int offset = 0;

    for (int i = 0; i < rows; i++, offset += columns) {
      for (int j = 0; j < columns; j++) {
        result[i][j] = array[j + offset];
      }
    }

    return result;
  }

  private String getFilePath(String fileName) {
    return Objects.requireNonNull(getClass().getClassLoader().getResource("."))
      .getFile() + fileName;
  }

  private class GameData {

    private final int rows;
    private final int columns;
    private final int iterations;
    private final byte[][] initFigure;

    public GameData(int rows, int columns, int iterations, byte[][] initFigure) {
      this.rows = rows;
      this.columns = columns;
      this.iterations = iterations;
      this.initFigure = initFigure;
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

    public byte[][] getInitFigure() {
      return initFigure;
    }
  }

}
