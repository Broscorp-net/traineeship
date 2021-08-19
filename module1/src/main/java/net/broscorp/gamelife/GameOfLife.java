package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GameOfLife {

  private int iter;
  private int arrRow;
  private int arrColumn;

  void game(String fileNameInput, String fileNameOutput) {

    Stream<String> gameStreamInput = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput))).lines();
    List<String> gameList = gameStreamInput.collect(Collectors.toList());
    int[][] gameFieldCurr = initGameField(gameList);
    int[][] gameFieldNext = new int[arrRow][arrColumn];
    while (iter > 0) {
      for (int i = 0; i < arrRow; i++) {
        for (int j = 0; j < arrColumn; j++) {
          int prevRow = (i == 0) ? arrRow - 1 : i - 1;
          int nextRow = (i == arrRow - 1) ? 0 : i + 1;
          int prevColumn = (j == 0) ? arrColumn - 1 : j - 1;
          int nextColumn = (j == arrColumn - 1) ? 0 : j + 1;
          int sum = gameFieldCurr[prevRow][prevColumn]
              + gameFieldCurr[prevRow][j]
              + gameFieldCurr[prevRow][nextColumn]
              + gameFieldCurr[i][prevColumn]
              + gameFieldCurr[i][nextColumn]
              + gameFieldCurr[nextRow][prevColumn]
              + gameFieldCurr[nextRow][j]
              + gameFieldCurr[nextRow][nextColumn];
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
      int[][] tmpArr = gameFieldCurr;
      gameFieldCurr = gameFieldNext;
      gameFieldNext = tmpArr;
      iter--;
    }
    saveGameFieldToFile(gameFieldCurr, fileNameOutput);
  }

  private int[][] initGameField(List<String> gameList) {
    String[] arrInit = gameList.get(0).split(",");
    arrRow = Integer.parseInt(arrInit[0]);
    arrColumn = Integer.parseInt(arrInit[1]);
    iter = Integer.parseInt(arrInit[2]);
    int[][] arrField = new int[arrRow][arrColumn];
    for (int i = 0; i < arrRow; i++) {
      String[] row = gameList.get(i + 1).split(" ");
      for (int j = 0; j < arrColumn; j++) {
        arrField[i][j] = row[j].equals("O") ? 0 : 1;
      }
    }
    return arrField;
  }

  private void saveGameFieldToFile(int[][] gameField, String fileNameOutput) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < arrRow; i++) {
      for (int j = 0; j < arrColumn; j++) {
        String splitter = j < arrColumn - 1 ? " " : "\n";
        builder.append(gameField[i][j] == 0 ? "O" + splitter : "X" + splitter);
      }
    }
    builder.deleteCharAt(builder.toString().length() - 1);
    File file = new File("resources/" + fileNameOutput);
    try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
      osw.write(builder.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
