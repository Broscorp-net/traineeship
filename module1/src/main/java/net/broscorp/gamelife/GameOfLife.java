package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    CellState[][] states;
    int countOfIteration;

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileNameInput))) {

      String[] commands = reader.readLine().trim().split(",");
      int rows = Integer.parseInt(commands[0]);
      int cols = Integer.parseInt(commands[1]);
      countOfIteration = Integer.parseInt(commands[2]);
      states = new CellState[rows][cols];
      for (int i = 0; i < rows; i++) {
        String[] strArr = reader.readLine().trim().split(" ");

        for (int j = 0; j < cols; j++) {
          states[i][j] = CellState.from(strArr[j]);
        }
      }

      GameConfig gameConfig = new GameConfig();
      for (int i = 0; i < countOfIteration; i++) {
        gameConfig.mainProcess(states);
      }

    } catch (IOException e) {
      String errMsg = e.getMessage() + " - Reader";
      System.err.println(errMsg);
      throw new RuntimeException(errMsg);
    }

    try (PrintWriter writer = new PrintWriter(fileNameOutput, "UTF-8")) {
      for (int i = 0; i < states.length; i++) {
        String joiner =
            Arrays.stream(states[i]).map(CellState::getValue).collect(Collectors.joining(" "));
        if (i != states.length - 1) {
          writer.println(joiner);
        } else {
          writer.print(joiner);
        }
      }
    } catch (IOException e) {
      String errMsg = e.getMessage() + " - Writer";
      System.err.println(errMsg);
    }
  }
}
