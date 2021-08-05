package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    CellState[][] arr = null;
    try (BufferedReader br = new BufferedReader(new FileReader(fileNameInput))) {
      int rows = Integer.parseInt(br.readLine());
      int cols = Integer.parseInt(br.readLine());
      int countOfIteration = Integer.parseInt(br.readLine());
      arr = new CellState[cols][rows];
      for (int i = 0; i < 3; i++) {
        String[] strArr = br.readLine().trim().split(" ");
        for (int j = 0; j < 3; j++) {
          arr[i][j] = CellState.from(strArr[j]);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
