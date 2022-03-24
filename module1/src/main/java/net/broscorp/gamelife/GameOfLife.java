package net.broscorp.gamelife;

import java.io.*;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInput));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput)); ) {

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
            int aliveNeighbours = 0;

            if (isAlive(gameField[i][j])) {
              if (i == 0 && j == 0) {
                aliveNeighbours = isAlive(gameField[0][1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[1][0]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[1][1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[1][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][0])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
              } else if (i == gameField.length - 1 && j == 0) {
                aliveNeighbours = isAlive(gameField[0][1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[1][1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 2][0])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 2][1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField[i].length - 1][1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 2][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
              } else if (i == 0 && j == gameField[i].length - 1) {
                aliveNeighbours = isAlive(gameField[0][0]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[1][0]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][gameField[i].length - 2])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[1][gameField[i].length - 2])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[1][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][gameField[i].length - 2])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][0])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
              } else if (i == gameField.length - 1 && j == gameField[i].length - 1) {
                aliveNeighbours = isAlive(gameField[0][0]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][gameField[i].length - 2])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField[i].length - 2][gameField[i].length - 2])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField[i].length - 2][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][gameField[i].length - 2])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][gameField[i].length - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 2][0])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][0])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
              } else if (i == 0 && (j > 0 && j < gameField[i].length - 1)) {
                aliveNeighbours =
                    isAlive(gameField[i][j - 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i][j + 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i + 1][j]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i + 1][j - 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i + 1][j + 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][j])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][j - 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[gameField.length - 1][j + 1])
                        ? aliveNeighbours + 1
                        : aliveNeighbours;
              } else if (i == gameField.length - 1 && (j > 0 && j < gameField[i].length - 1)) {
                aliveNeighbours =
                    isAlive(gameField[i][j - 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i][j + 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i - 1][j]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i - 1][j - 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[i - 1][j + 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[0][j]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][j - 1]) ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours =
                    isAlive(gameField[0][j + 1]) ? aliveNeighbours + 1 : aliveNeighbours;
              } else if (j == 0 && (i > 0 && i < gameField.length - 1)) {
                aliveNeighbours = isAlive(gameField[i - 1][j])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i - 1][j + 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i][j + 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j + 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i - 1][gameField[i].length - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i][gameField[i].length - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][gameField[i].length - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
              } else if (j == gameField[i].length - 1 && (i > 0 && i < gameField.length - 1)) {
                aliveNeighbours = isAlive(gameField[i - 1][j])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i - 1][j - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i][j - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i - 1][0])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i][0])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][0])
                        ? aliveNeighbours + 1 : aliveNeighbours;
              } else {
                aliveNeighbours = isAlive(gameField[i - 1][j])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i - 1][j - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i][j - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j - 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i - 1][j + 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i][j + 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
                aliveNeighbours = isAlive(gameField[i + 1][j + 1])
                        ? aliveNeighbours + 1 : aliveNeighbours;
              }

              if (aliveNeighbours != 2 && aliveNeighbours != 3) {
                gameField[i][j] = swap(gameField[i][j]);
              }
            } else {

            }
          }
        }
        counter++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String swap(String cellToSwap) {
    if (!cellToSwap.equals("X") && !cellToSwap.equals("O")) {
      throw new IllegalArgumentException();
    }
    return cellToSwap.equals("X") ? "O" : "X";
  }

  private boolean isAlive(String cell) {
    if (!cell.equals("X") && !cell.equals("O")) {
      throw new IllegalArgumentException();
    }
    return cell.equals("X");
  }
}
