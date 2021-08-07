package net.broscorp.gamelife;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    CellState[][] states = null;
    int countOfIteration;
    System.out.println("Ok");
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileNameInput))) {
      System.out.println("OkOk");
      String[] commands = reader.readLine().trim().split(",");
      int rows = Integer.parseInt(commands[0]);
      int cols = Integer.parseInt(commands[1]);
      countOfIteration = Integer.parseInt(commands[2]);
      states = new CellState[rows][cols];
      for (int i = 0; i < rows; i++) {
        String[] strArr = reader.readLine().trim().split(" ");
        System.out.println(Arrays.toString(strArr));
        for (int j = 0; j < cols; j++) {
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
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput));
        for (int i = 0; i < states.length; i++) {

          String joiner =
              Arrays.stream(states[i]).map(CellState::getValue).collect(Collectors.joining(" "));
          writer.write(joiner);
          if (i != states.length - 1) {
            writer.newLine();
          }
        }
        writer.flush();
        writer.close();
      } catch (IOException e) {
        System.out.println(e.getMessage() + " - Writer");
      }
    } else {
      System.out.println("have little bug in a code");
    }
  }
}
