package net.broscorp.gamelife;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {
  private int width;
  private int height;
  private int quantityCycle;
  private int[][] board;

  /**
   * start game method.
   *
   * @param fileNameInput  name input file
   * @param fileNameOutput name output file
   */
  public void game(String fileNameInput, String fileNameOutput) {
    List<String> listFromFile = readFile(fileNameInput);

    width = getWidthFromFile(listFromFile.get(0));
    height = getHeightFromFile(listFromFile.get(0));
    quantityCycle = getQuantityCycleFromFile(listFromFile.get(0));
    board = new int[width][height];
    createBoard(listFromFile);

    cycleSteps();
    List<String> listForWrite = listForWrite();
    writeToFile(listForWrite, fileNameOutput);
  }

  private int countAliveNeighbours(int x, int y) {
    int count = 0;

    count += getState(x - 1, y - 1);
    count += getState(x, y - 1);
    count += getState(x + 1, y - 1);

    count += getState(x - 1, y);
    count += getState(x + 1, y);

    count += getState(x - 1, y + 1);
    count += getState(x, y + 1);
    count += getState(x + 1, y + 1);

    return count;
  }

  private int getState(int x, int y) {
    if (x < 0 && y < 0) {
      return this.board[width - 1][height - 1];
    }
    if (x >= width && y >= height) {
      return this.board[0][0];
    }
    if (x >= width && y < 0) {
      return this.board[0][height - 1];
    }
    if (x < 0 && y >= height) {
      return this.board[width - 1][0];
    }
    if (x < 0) {
      return this.board[width - 1][y];
    }
    if (x >= width) {
      return this.board[0][y];
    }
    if (y < 0) {
      return this.board[x][height - 1];
    }
    if (y >= height) {
      return this.board[x][0];
    }
    return this.board[x][y];
  }

  private void cycleSteps() {
    for (int i = 0; i < quantityCycle; i++) {
      step();
    }
  }

  private void step() {
    int[][] newBoard = new int[width][height];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int aliveNeighbours = countAliveNeighbours(x, y);
        if (getState(x, y) == 0) {
          if (aliveNeighbours == 3) {
            newBoard[x][y] = 1;
          }
        }
        if (getState(x, y) == 1) {
          if (aliveNeighbours > 3) {
            newBoard[x][y] = 0;
          }
          if (aliveNeighbours < 2) {
            newBoard[x][y] = 0;
          }
          if (aliveNeighbours == 2 || aliveNeighbours == 3) {
            newBoard[x][y] = 1;
          }
        }
      }
    }
    this.board = newBoard;
  }

  private void createBoard(List<String> strings) {
    for (int i = 0; i < board.length; i++) {
      String[] row = strings.get(i + 1).split(" ");
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = row[j].charAt(0) == 'X' ? 1 : 0;
      }
    }
  }

  private List<String> listForWrite() {
    List<String> listToWrite = new ArrayList<>();
    for (int y = 0; y < width; y++) {
      StringBuilder line = new StringBuilder();
      for (int x = 0; x < height; x++) {
        if (this.board[y][x] == 0) {
          line.append("O ");
        } else {
          line.append("X ");
        }
      }
      line.append("\n");
      listToWrite.add(line.toString().trim() + "\n");
    }
    return listToWrite;
  }

  private void writeToFile(List<String> list, String fileNameOutput) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput, true))) {
      for (int i = 0; i < list.size(); i++) {
        writer.write(list.get(i));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private int getWidthFromFile(String first) {
    return Integer.parseInt(first.split(",")[0]);
  }

  private int getHeightFromFile(String first) {
    return Integer.parseInt(first.split(",")[1]);
  }

  private int getQuantityCycleFromFile(String first) {
    return Integer.parseInt(first.split(",")[2]);
  }

  private List<String> readFile(String fileName) {
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      return stream.collect(Collectors.toList());
    } catch (IOException exception) {
      throw new IllegalArgumentException(exception);
    }
  }
}