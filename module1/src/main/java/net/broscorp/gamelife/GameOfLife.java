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

    String[][] gameField = createGameFiledFromFile("inputStable1.txt");
    System.out.println("createGameFiledFromFile " + Arrays.deepToString(gameField));
    saveResultToFile(gameField, "expectedTest.txt");
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

  public void game(String fileNameInput, String fileNameOutput) {

    String[][] gameField = createGameFiledFromFile(fileNameInput);
    int iteration = Integer.parseInt(getParametersFromFile(fileNameInput).get(0).split(",")[2]);

    saveResultToFile(gameField, fileNameOutput);

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
