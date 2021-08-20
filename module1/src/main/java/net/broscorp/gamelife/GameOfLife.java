package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GameOfLife {

  private int iter;
  private int fieldRows;
  private int fieldColumns;

  void game(String fileNameInput, String fileNameOutput) {

    Stream<String> gameStreamInput = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput))).lines();
    List<String> gameList = gameStreamInput.collect(Collectors.toList());
    int[][] gameFieldCurr = initGameField(gameList);
    int[][] gameFieldNext = new int[fieldRows][fieldColumns];
    while (iter > 0) {
      gameOneIteration(gameFieldCurr, gameFieldNext);
      int[][] tmpArr = gameFieldCurr;
      gameFieldCurr = gameFieldNext;
      gameFieldNext = tmpArr;
      iter--;
    }
    saveGameFieldToFile(gameFieldCurr, fileNameOutput);
  }

  private int[][] initGameField(List<String> gameList) {
    String[] arrInit = gameList.get(0).split(",");
    fieldRows = Integer.parseInt(arrInit[0]);
    fieldColumns = Integer.parseInt(arrInit[1]);
    iter = Integer.parseInt(arrInit[2]);
    int[][] arrField = new int[fieldRows][fieldColumns];
    for (int i = 0; i < fieldRows; i++) {
      String[] row = gameList.get(i + 1).split(" ");
      for (int j = 0; j < fieldColumns; j++) {
        arrField[i][j] = row[j].equals("O") ? 0 : 1;
      }
    }
    return arrField;
  }

  private void saveGameFieldToFile(int[][] gameField, String fileNameOutput) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < fieldRows; i++) {
      for (int j = 0; j < fieldColumns; j++) {
        String splitter = j < fieldColumns - 1 ? " " : "\n";
        builder.append(gameField[i][j] == 0 ? "O" + splitter : "X" + splitter);
      }
    }
    builder.deleteCharAt(builder.toString().length() - 1);
    String outputFilePath = Objects.requireNonNull(
        getClass().getClassLoader().getResource(".")).getPath();
    File file = new File(outputFilePath + fileNameOutput);
    try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
      osw.write(builder.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void gameOneIteration(int[][] gameFieldCurr, int[][] gameFieldNext) {
    for (int i = 0; i < fieldRows; i++) {
      for (int j = 0; j < fieldColumns; j++) {
        int sum = sumAroundCells(i, j, gameFieldCurr);
        switch (sum) {
          case 2:
            gameFieldNext[i][j] = gameFieldCurr[i][j];
            break;
          case 3:
            gameFieldNext[i][j] = 1;
            break;
          default:
            gameFieldNext[i][j] = 0;
        }
      }
    }
  }

  private int prevIndex(int index, int value) {
    return index == 0 ? value - 1 : index - 1;
  }

  private int nextIndex(int index, int value) {
    return index == value - 1 ? 0 : index + 1;
  }

  private int sumAroundCells(int indexRow, int indexColumn, int[][] gameFieldCurr) {
    int prevRow = prevIndex(indexRow, fieldRows);
    int nextRow = nextIndex(indexRow, fieldRows);
    int prevColumn = prevIndex(indexColumn, fieldColumns);
    int nextColumn = nextIndex(indexColumn, fieldColumns);
    return gameFieldCurr[prevRow][prevColumn]
        + gameFieldCurr[prevRow][indexColumn]
        + gameFieldCurr[prevRow][nextColumn]
        + gameFieldCurr[indexRow][prevColumn]
        + gameFieldCurr[indexRow][nextColumn]
        + gameFieldCurr[nextRow][prevColumn]
        + gameFieldCurr[nextRow][indexColumn]
        + gameFieldCurr[nextRow][nextColumn];
  }

}
