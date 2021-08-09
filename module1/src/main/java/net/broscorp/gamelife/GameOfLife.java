package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameOfLife {

  /**
   * This algorithm involves toroidal array use.
   */
  public void game(String fileNameInput, String fileNameOutput) {
    String inputValue = readFile(fileNameInput);
    int rows = getValue(inputValue, 0);
    int columns = getValue(inputValue, 1);
    int cycles = getValue(inputValue, 2);
    String[][] board = extractTwoDimensionalArray(inputValue, rows, columns);
    String[][] result = doGame(board, cycles);
    writeResultToFile(result, fileNameOutput);
  }

  private int getValue(String inputValue, int index) {
    String[] arr = inputValue.split(",");
    return Integer.parseInt(arr[index].replaceAll("[^0-9]", ""));
  }

  private String[][] doGame(String[][] board, int cycles) {
    int r = board.length;
    int c = board[0].length;
    int cyclesCount = 0;
    String[][] result = new String[r][c];
    int[][] initialCoord = {
        {r - 1, c - 1},
        {r - 1, 0},
        {r - 1, 1},
        {0, 1},
        {1, 1},
        {1, 0},
        {1, c - 1},
        {0, c - 1}
    };

    while (cyclesCount < cycles) {
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          int liveCells = 0;
          for (int[] coord : initialCoord) {
            int x = verifyIndex(coord[0] + i, r);
            int y = verifyIndex(coord[1] + j, c);
            if (board[x][y].equalsIgnoreCase("x")) {
              liveCells++;
            }
          }
          if (board[i][j].equalsIgnoreCase("X")) {
            if (liveCells == 2 || liveCells == 3) {
              result[i][j] = "X";
            } else {
              result[i][j] = "O";
            }
          } else if (board[i][j].equalsIgnoreCase("O")) {
            if (liveCells == 3) {
              result[i][j] = "X";
            } else {
              result[i][j] = "O";
            }
          }
        }
      }
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          board[i][j] = result[i][j];
        }
      }
      cyclesCount++;
    }
    return board;
  }

  private void writeResultToFile(String[][] result, String fileNameOutput) {
    StringBuilder outputBoard = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        outputBoard.append(result[i][j]);
        if (j < result[i].length - 1) {
          outputBoard.append(" ");
        }
      }
      if (i < result.length - 1) {
        outputBoard.append("\n");
      }
    }
    try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileNameOutput))) {
      bf.write(outputBoard.toString());
    } catch (IOException e) {
      e.getMessage();
    }
  }

  private int verifyIndex(int coord, int length) {
    int newCoord = coord;
    if (coord > length - 1) {
      newCoord = (coord % length);
    }
    return newCoord;
  }

  private String[][] extractTwoDimensionalArray(String inputValue, int rows, int columns) {
    String[][] input = new String[rows][columns];
    String board = removeFirstLine(inputValue);
    String[] boardArray = board.split("\\R");
    for (int i = 0; i < boardArray.length; i++) {
      input[i] = boardArray[i].split(" ");
    }
    return input;
  }

  private String removeFirstLine(String inputValue) {
    String text = inputValue.replaceAll("[0-9,]", "");
    return text.substring(1);
  }

  private String readFile(String fileNameInput) {
    String line;
    StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(fileNameInput))) {
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
    } catch (IOException e) {
      e.getMessage();
    }
    return sb.toString();
  }
}