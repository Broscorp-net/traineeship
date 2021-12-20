package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  public static void main(String[] args) {

    String[][] gameField = createGameFiledFromFile("inputGliderEasy.txt");
    int iteration = Integer.parseInt(getParametersFromFile("inputGliderEasy.txt").get(0).split(",")[2]);
    int[][] directionField = createDirectionField();
    String[][] nextGameField = new String[gameField.length][gameField[0].length];
    while (iteration>0){
      gameIteration(gameField, directionField, nextGameField);
      iteration--;
    }
    saveResultToFile(gameField, "expectedTest.txt");
  }

  public void game(String fileNameInput, String fileNameOutput) {

    String[][] gameField = createGameFiledFromFile(fileNameInput);
    int iteration = Integer.parseInt(getParametersFromFile(fileNameInput).get(0).split(",")[2]);
    int[][] directionField = createDirectionField();
    String[][] nextGameField = new String[gameField.length][gameField[0].length];
    while (iteration>0){
      gameIteration(gameField, directionField, nextGameField);
      iteration--;
    }
    saveResultToFile(gameField, fileNameOutput);

  }

  private static void gameIteration(String[][] gameField, int[][] directionField,
      String[][] nextGameField) {
    int high2DArray = gameField.length;
    int width2DArray = gameField[0].length;
    for(int rowIndex = 0; rowIndex < high2DArray; rowIndex++){
      for(int columnIndex = 0; columnIndex < width2DArray; columnIndex++){
        int liveCellCount = calculateLiveCell(gameField, directionField, rowIndex, columnIndex);
//        refactor logic operation
        switch (liveCellCount) {
          case 2:
            nextGameField[rowIndex][columnIndex] = gameField[rowIndex][columnIndex];
            break;
          case 3:
            nextGameField[rowIndex][columnIndex] = "X";
            break;
          default:
            nextGameField[rowIndex][columnIndex] = "O";
        }

      }
    }
    for(int rowIndex = 0; rowIndex < gameField.length; rowIndex++){
      for(int columnIndex = 0; columnIndex < gameField[0].length; columnIndex++){
        gameField[rowIndex][columnIndex] = nextGameField[rowIndex][columnIndex];
      }
    }
  }

  private static int calculateLiveCell(String[][] gameField, int[][] directionField, int rowIndex, int columnIndex) {
    int liveCellCount = 0;
    for(int[] direction : directionField){
      int x = direction[0] + rowIndex;
      int y = direction[1] + columnIndex;
      boolean isCellHasNeighbor = (x >= 0 && x < gameField.length) && (y >= 0 && y < gameField[0].length);
      if(isCellHasNeighbor && gameField[x][y] != null && gameField[x][y].equals("X")) {
        liveCellCount++;
      }
    }
    return liveCellCount;
  }

  private static int[][] createDirectionField() {
    return new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
  }

  private static void saveResultToFile(String[][] gameField, String fileNameOutput) {
    String filePath = "src/test/resources/" + fileNameOutput;
    File file = new File(filePath);

    try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
      osw.write(convertArrayToString(gameField));
    } catch (IOException exception) {
      System.out.println("File not found " + exception);
    }
  }

  private static String convertArrayToString(String[][] gameField) {
    String gameFiledToStr = "";
    for (int row = 0; row < gameField.length; row++) {
      for (int col = 0; col < gameField[row].length; col++) {
        gameFiledToStr += gameField[row][col] + " ";
      }
      gameFiledToStr += "\n";
    }
    return gameFiledToStr;
  }


  private static String[][] createGameFiledFromFile(String fileNameInput) {
    List<String> lines = getParametersFromFile(fileNameInput);

    String[] parametersFor2DArray = lines.get(0).split(",");
    int high2DArray = Integer.parseInt(parametersFor2DArray[0]);
    int width2DArray = Integer.parseInt(parametersFor2DArray[1]);

    lines.remove(0);

    List<String> stringsForBuildGameField = lines;
    String[][] field = new String[high2DArray][width2DArray];

    for (int rowIndex = 0; rowIndex < high2DArray; rowIndex++) {
      for (int columnIndex = 0;
          columnIndex < stringsForBuildGameField.get(rowIndex).split(" ").length; columnIndex++) {
        field[rowIndex][columnIndex] = stringsForBuildGameField.get(rowIndex)
            .split(" ")[columnIndex];
      }
    }

    return field;
  }

  private static List<String> getParametersFromFile(String fileNameInput) {
    String filePath = "src/test/resources/" + fileNameInput;
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(filePath),
          StandardCharsets.UTF_8);
    } catch (IOException exception) {
      System.out.println("IOException! File don't found " + exception);
    }
    return lines;
  }

}
