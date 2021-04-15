package net.broscorp.gamelife;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

  /**
   * This method runs the game.
   *
   * @param fileNameInput name of the file that contains the original data for the game (field
   *     dimensions, number of generations and the state of the first generation)
   * @param fileNameOutput name of file that contains the state of field at the end of the game
   *     (last generation)
   */
  public void game(String fileNameInput, String fileNameOutput) {
    List<ArrayList<String>> initParams = getInitParamsFromFile(fileNameInput);
    assert initParams != null;
    int numberOfRows = Integer.parseInt(initParams.get(0).get(0));
    int numberOfCols = Integer.parseInt(initParams.get(0).get(1));
    int numberOfGens = Integer.parseInt(initParams.get(0).get(2));
    List<ArrayList<String>> currentStateList = new ArrayList<>();
    for (int i = 1; i < initParams.size(); i++) {
      currentStateList.add(initParams.get(i));
    }
    int generationCounter = 1;
    while (generationCounter <= numberOfGens) {
      List<ArrayList<String>> newStateList = new ArrayList<>(numberOfRows);
      for (int i = 0; i < numberOfRows; i++) {
        ArrayList<String> newRowForNewStateList = new ArrayList<>(numberOfCols);
        for (int j = 0; j < numberOfCols; j++) {
          int numberOfAliveNeighbors = getNumberOfAliveNeighbors(currentStateList, i, j);
          if (currentStateList.get(i).get(j).equals("O")) {
            if (numberOfAliveNeighbors == 3) {
              newRowForNewStateList.add("X");
              continue;
            } else {
              newRowForNewStateList.add("O");
              continue;
            }
          }
          if (currentStateList.get(i).get(j).equals("X")) {
            if (numberOfAliveNeighbors == 2 || numberOfAliveNeighbors == 3) {
              newRowForNewStateList.add("X");
            } else {
              newRowForNewStateList.add("O");
            }
          }
        }
        newStateList.add(newRowForNewStateList);
      }
      currentStateList = newStateList;
      generationCounter++;
    }
    outputStateListToFile(currentStateList, fileNameInput, fileNameOutput);
  }

  private List<ArrayList<String>> getInitParamsFromFile(String fileNameInput) {
    try {
      List<String> fileLinesList =
          Files.lines(Paths.get(ClassLoader.getSystemResource(fileNameInput).toURI()))
              .collect(Collectors.toList());
      List<ArrayList<String>> initParamsList = new ArrayList<>();
      initParamsList.add(new ArrayList<>(Arrays.asList(fileLinesList.get(0).split(","))));
      for (int i = 1; i < fileLinesList.size(); i++) {
        ArrayList<String> newRowArrayList =
            new ArrayList<>(Arrays.asList(fileLinesList.get(i).split(" ")));
        initParamsList.add(newRowArrayList);
      }
      return initParamsList;
    } catch (IOException | URISyntaxException ex) {
      System.out.printf("The file %s is not found", fileNameInput);
      return null;
    }
  }

  private int getNumberOfAliveNeighbors(List<ArrayList<String>> stateList, int i, int j) {
    int numberOfAliveNeighbors = 0;
    for (int rowDiff = -1; rowDiff <= 1; rowDiff++) {
      int row =
          i + rowDiff < 0
              ? stateList.size() - 1
              : i + rowDiff > stateList.size() - 1 ? 0 : i + rowDiff;
      for (int colDiff = -1; colDiff <= 1; colDiff++) {
        int col =
            j + colDiff < 0
                ? stateList.get(i).size() - 1
                : j + colDiff > stateList.get(i).size() - 1 ? 0 : j + colDiff;
        if (stateList.get(row).get(col).equals("X")) {
          numberOfAliveNeighbors++;
        }
      }
    }
    return stateList.get(i).get(j).equals("X")
        ? numberOfAliveNeighbors - 1
        : numberOfAliveNeighbors;
  }

  private void outputStateListToFile(
      List<ArrayList<String>> stateList, String fileNameInput, String fileNameOutput) {
    String pathToResource =
        ClassLoader.getSystemResource(fileNameInput)
            .toString()
            .replace(fileNameInput, fileNameOutput)
            .replace("file:/", "")
            .replaceAll("/", "\\\\");
    File file = new File(pathToResource);
    try (PrintWriter out = new PrintWriter(new FileWriter(file, false))) {
      for (ArrayList<String> list : stateList) {
        out.println(list.toString().replaceAll("[\\[\\],]", ""));
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("File not found");
    }
  }
}
