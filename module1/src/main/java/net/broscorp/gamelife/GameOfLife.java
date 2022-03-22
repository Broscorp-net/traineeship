package net.broscorp.gamelife;

import java.io.*;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInput));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput));) {

      int height = 0;
      int width = 0;
      int iterNum = 0;

      String[] splitter = reader.readLine().split(",");
      if (splitter.length != 3) {
        throw new IOException("Too many or not enough params for the game");
      }

      height = Integer.parseInt(splitter[0]);
      width = Integer.parseInt(splitter[1]);
      iterNum = Integer.parseInt(splitter[2]);

      String[][] gameField = new String[height][width];

      for (String[] strings : gameField) {
        String line = reader.readLine();

        if (!line.contains("X") && !line.contains("O")) {
          throw new IOException("Line does not contain \"X\" or \"O\"");
        }

        String[] innerSplitter = line.split(" ");

        System.arraycopy(innerSplitter, 0, strings, 0, strings.length);
      }

      int counter = 0;

      while (counter < iterNum) {
        for (int i = 0; i < gameField.length; i++) {
          for (int j = 0; j < gameField[i].length; j++) {

          }
        }
        counter++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
