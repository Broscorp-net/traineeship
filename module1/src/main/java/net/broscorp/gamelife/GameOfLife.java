package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameOfLife {

  private int[][] gameField;
  private int height;
  private int width;
  /**
   * Leaving this task for the better times.
   *
   * @param fileNameInput - input file.
   * @param fileNameOutput - output file.
   */
  public void game(String fileNameInput, String fileNameOutput) {
    try (BufferedReader reader =
            new BufferedReader(new FileReader("src/test/resources/" + fileNameInput));
        PrintWriter writer =
            new PrintWriter(new FileWriter("src/test/resources/" + fileNameOutput)); ) {

      String[] splitter = reader.readLine().split(",");
      if (splitter.length != 3) {
        throw new IOException("Too many or not enough params for the game");
      }

      height = Integer.parseInt(splitter[0]);
      width = Integer.parseInt(splitter[1]);

      gameField = new int[height][width];

      for (int i = 0; i < gameField.length; i++) {
        String line = reader.readLine();

        if (!line.contains("X") && !line.contains("O")) {
          throw new IOException("Line does not contain \"X\" or \"O\"");
        }
        String[] innerSplitter = line.split(" ");
        for (int j = 0; j < gameField[i].length; j++) {
          if (innerSplitter[j].equals("X")) {
            gameField[i][j] = 1;
          } else {
            gameField[i][j] = 0;
          }
        }
      }

      int iterNum = Integer.parseInt(splitter[2]);

      for (int i = 0; i < iterNum; i++) {
        int[][] tempBoard = new int[height][width];
        for (int j = 0; j < height; j++) {
          for (int k = 0; k < width; k++) {
            if (getState(j, k) == 1) {
              if (getAliveNeighboursCount(j, k) < 2) {
                tempBoard[j][k] = 0;
              } else if (getAliveNeighboursCount(j, k) == 2 || getAliveNeighboursCount(j, k) == 3) {
                tempBoard[j][k] = 1;
              } else if (getAliveNeighboursCount(j, k) > 3) {
                tempBoard[j][k] = 0;
              }
            } else {
              if (getAliveNeighboursCount(j, k) == 3) {
                tempBoard[j][k] = 1;
              }
            }
          }
        }
        this.gameField = tempBoard;
      }

      for (int i = 0; i < gameField.length; i++) {
        for (int j = 0; j < gameField[i].length; j++) {
          if (j != gameField[i].length - 1) {
            if (getState(i, j) == 1) {
              writer.print("X ");
            } else {
              writer.print("O ");
            }
          } else {
            if (getState(i, j) == 1) {
              writer.print("X");
            } else {
              writer.print("O");
            }
          }
        }
        if (i != gameField.length - 1) {
          writer.println();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getAliveNeighboursCount(int x, int y) {
    int count = 0;

    if (x == 0 && y == 0) {
      count += getState(height - 1, width - 1);
      count += getState(x, width - 1);
      count += getState(x + 1, width - 1);

      count += getState(height - 1, y);
      count += getState(x + 1, y);

      count += getState(height - 1, y + 1);
      count += getState(x, y + 1);
      count += getState(x + 1, y + 1);
    } else if (x == 0 && y == width - 1) {
      count += getState(height - 1, 0);
      count += getState(x, 0);
      count += getState(x + 1, 0);

      count += getState(height - 1, y);
      count += getState(x + 1, y);

      count += getState(height - 1, y - 1);
      count += getState(x, y - 1);
      count += getState(x + 1, y - 1);
    } else if (x == height - 1 && y == 0) {
      count += getState(0, width - 1);
      count += getState(x - 1, width - 1);
      count += getState(x, width - 1);

      count += getState(x - 1, y);
      count += getState(0, y);

      count += getState(0, y + 1);
      count += getState(x - 1, y + 1);
      count += getState(x, y + 1);
    } else if (x == height - 1 && y == width - 1) {
      count += getState(0, 0);
      count += getState(x - 1, 0);
      count += getState(x, 0);

      count += getState(x - 1, y);
      count += getState(0, y);

      count += getState(0, y - 1);
      count += getState(x - 1, y - 1);
      count += getState(x, y - 1);
    } else if (x == 0 && y > 0 && y < width - 1) {
      count += getState(height - 1, y - 1);
      count += getState(x, y - 1);
      count += getState(x + 1, y - 1);

      count += getState(height - 1, y);
      count += getState(x + 1, y);

      count += getState(height - 1, y + 1);
      count += getState(x, y + 1);
      count += getState(x + 1, y + 1);
    } else if (x == height - 1 && y > 0 && y < width - 1) {
      count += getState(x - 1, y - 1);
      count += getState(x, y - 1);
      count += getState(0, y - 1);

      count += getState(x - 1, y);
      count += getState(0, y);

      count += getState(x - 1, y + 1);
      count += getState(x, y + 1);
      count += getState(0, y + 1);
    } else if (x > 0 && x < height - 1 && y == 0) {
      count += getState(x - 1, width - 1);
      count += getState(x, width - 1);
      count += getState(x + 1, width - 1);

      count += getState(x - 1, y);
      count += getState(x + 1, y);

      count += getState(x - 1, y + 1);
      count += getState(x, y + 1);
      count += getState(x + 1, y + 1);
    } else if (x > 0 && x < height - 1 && y == width - 1) {
      count += getState(x - 1, 0);
      count += getState(x, 0);
      count += getState(x + 1, 0);

      count += getState(x - 1, y);
      count += getState(x + 1, y);

      count += getState(x - 1, y - 1);
      count += getState(x, y - 1);
      count += getState(x + 1, y - 1);
    } else {
      count += getState(x - 1, y - 1);
      count += getState(x, y - 1);
      count += getState(x + 1, y - 1);

      count += getState(x - 1, y);
      count += getState(x + 1, y);

      count += getState(x - 1, y + 1);
      count += getState(x, y + 1);
      count += getState(x + 1, y + 1);
    }
    return count;
  }

  private int getState(int x, int y) {
    return this.gameField[x][y];
  }
}
