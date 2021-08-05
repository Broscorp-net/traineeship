package net.broscorp.gamelife;

import java.io.*;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    CellState[][] states = null;
    int countOfIteration;
    try (BufferedReader br = new BufferedReader(new FileReader(fileNameInput))) {
      int rows = Integer.parseInt(br.readLine());
      int cols = Integer.parseInt(br.readLine());
      countOfIteration = Integer.parseInt(br.readLine());
      states = new CellState[cols][rows];
      for (int i = 0; i < 3; i++) {
        String[] strArr = br.readLine().trim().split(" ");
        for (int j = 0; j < 3; j++) {
          states[i][j] = CellState.from(strArr[j]);
        }
      }

      GameConfig gameConfig = new GameConfig();
      for (int i = 0; i < countOfIteration; i++) {
        gameConfig.mainProcess(states);
      }

    } catch (IOException e) {
      System.out.println(e.getMessage() + " - Reader");
    }

    if (states != null) {

      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileNameOutput));
        bw.write(String.valueOf(states.length));
        bw.newLine();
        bw.write(String.valueOf(states[0].length));
        bw.newLine();
        for (int i = 0; i < states.length; i++) {
          for (int j = 0; j < states[0].length; j++) {
            bw.write(states[i][j].getValue());
          }
          bw.newLine();
        }
        bw.flush();
        bw.close();
      } catch (IOException e) {
        System.out.println(e.getMessage() + " - Writer");
      }
    } else {
      System.out.println("have little bug in a code");
    }
  }
}
