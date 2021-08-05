package net.broscorp.gamelife;

import java.io.*;

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
      System.out.println(e.getMessage() + " - Reader");
    }
    if (arr != null) {
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileNameOutput));
        bw.write(String.valueOf(arr.length));
        bw.newLine();
        bw.write(String.valueOf(arr[0].length));
        bw.newLine();
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[0].length; j++) {
            bw.write(arr[i][j].getValue());
          }
          bw.newLine();
        }
        bw.flush();
        bw.close();
      } catch (IOException e) {
        System.out.println(e.getMessage() + " - Writer");
      }
    }else{
      System.out.println("have bug in a code");
    }
  }
}
