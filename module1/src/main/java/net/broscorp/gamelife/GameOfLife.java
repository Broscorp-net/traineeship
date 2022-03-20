package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  private int inputI;
  private int inputJ;

  /**
   *  {@inheritDoc}
   *  */
  public void game(String fileNameInput, String fileNameOutput) {
    Stream<String> gameStreamInput = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput))).lines();
    List<String> gameInputList = gameStreamInput.collect(Collectors.toList());
    String[] dataGame = gameInputList.get(0).split(",");
    inputI = Integer.parseInt(dataGame[0]);
    inputJ = Integer.parseInt(dataGame[1]);
    int lifeIteration = Integer.parseInt(dataGame[2]);
    gameInputList.remove(0);

    for (int i = 0; i < lifeIteration; i++) {
      gameInputList = cellAutomat(gameInputList);
    }

    String path = "target/test-classes/" + fileNameOutput;

    try {
      BufferedWriter bf = new BufferedWriter(new FileWriter(path));
      for (int i = 0; i < gameInputList.size(); i++) {
        if (i != gameInputList.size() - 1) {
          bf.write(gameInputList.get(i) + "\n");
        } else {
          bf.write(gameInputList.get(i));
        }
      }
      bf.flush();
      bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private  List<String> cellAutomat(List<String> inputList) {
    //change list to array int
    int[][] in = new int[inputI][inputJ];
    for (int i = 0; i < inputList.size(); i++) {
      char[] chRow = inputList.get(i).replace(" ","").toCharArray();
      for (int j = 0; j < chRow.length; j++) {
        in[i][j] = chRow[j] == 'X' ? 1 : 0;
      }
    }
    // scanner cell
    char[][] rez = new char[inputI][inputJ];
    for (int i = 0; i < inputI; i++) {
      for (int j = 0; j < inputJ; j++) {
        int sum = 0;
        for (int ii = -1; ii < 2; ii++) {
          for (int jj = -1; jj < 2; jj++) {
            if ((ii == 0) && (jj == 0)) {
              continue;
            }
            int iii = (i + ii) < 0 ? inputI - 1 : i + ii;
            int jjj = (j + jj) < 0 ? inputJ - 1 : j + jj;
            if (iii > inputI - 1) {
              iii = 0;
            }
            if (jjj > inputJ - 1) {
              jjj = 0;
            }
            sum += in[iii][jjj];
          }
        }
        if ((in[i][j] == 0) && (sum == 3)) {
          rez[i][j] = 'X';
        } else if ((in[i][j] == 1) && ((sum == 2) || (sum == 3))) {
          rez[i][j] = 'X';
        } else {
          rez[i][j] = 'O';
        }

      }
    }
    // return List
    List<String> rezList = new ArrayList<>();
    for (int i = 0; i < inputI; i++) {
      String row = "";
      for (int j = 0; j < inputJ; j++) {
        if (j != inputJ - 1) {
          row += rez[i][j] + " ";
        } else {
          row += rez[i][j];
        }
      }
      rezList.add(row);
    }
    return rezList;
  }
}
