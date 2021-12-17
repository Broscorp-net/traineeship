package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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

  }

  public void game(String fileNameInput, String fileNameOutput){

    String[][] gameField = createGameFiledFromFile("inputGliderEasy.txt");
  }

  private static String[][] createGameFiledFromFile(String fileNameInput) {
    String fileName = "src/test/resources/" + fileNameInput;
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(fileName),
          StandardCharsets.UTF_8);
      System.out.println(lines);
    } catch (IOException exception) {
      System.out.println("IOException! File don't found " + exception);
    }
    String[] parametersFor2DArray = lines.get(0).split(",");
    int width2DArray = Integer.parseInt(parametersFor2DArray[0]);
    int high2DArray = Integer.parseInt(parametersFor2DArray[1]);
    int amountIteration = Integer.parseInt(parametersFor2DArray[2]);
    System.out.println(width2DArray + high2DArray + amountIteration);

    lines.remove(0);
    List<String> stringsForBuildGameField = lines;
    String[][] field = new String[width2DArray][high2DArray];

    for(int row = 0; row < width2DArray; row++){
      for(int column = 0; column < high2DArray; column++){
        field[row][column] = stringsForBuildGameField.get(column).split(" ")[column];
      }
    }
    return field;
  }

}
