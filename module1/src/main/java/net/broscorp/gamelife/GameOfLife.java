package net.broscorp.gamelife;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  private final static String testName = "C:\\Users\\BogdanDAN\\Desktop\\Broscorp\\traineeship\\module1\\src\\test\\resources\\inputGlider.txt";

  private static String[][] startTwoArray;
  private static int[][] generateTwoArray;
  private int iter;
  private int mRows;
  private int nColumns;

  public static void main(String[] args) {
    GameOfLife gameOfLife = new GameOfLife();
    List<String> list = gameOfLife.readFile(testName);
    if (list != null) {
      gameOfLife.createTwoArrays(list);
      System.out.println("iter" + gameOfLife.iter);
      for (int i = 0; i < gameOfLife.iter; i++) {
        gameOfLife.nextGeneration();
      }
      System.out.println("Next Generation");
      for (int l = 0; l < gameOfLife.mRows; l++) {
        for (int m = 0; m < gameOfLife.nColumns; m++) {
          if (generateTwoArray[l][m] == 0) {
            System.out.print(" O");
          } else {
            System.out.print(" X");
          }
        }
        System.out.println();
      }
    } else {
      System.out.println("list == null");
    }
  }

  public void game(String fileNameInput, String fileNameOutput) {

  }

  private List<String> readFile(String fileName) {
    try {
      Stream<String> gameStreamResult = Files.lines(Paths.get(fileName));
      return gameStreamResult.collect(Collectors.toList());
    } catch (IOException ex) {
      System.err.println(ex);
      return null;
    }
  }

  private void generateSizes(String s) {
    String[] arr = s.split(",");
    int[] sizes = new int[3];
    for (int i = 0; i < sizes.length; i++) {
      sizes[i] = Integer.parseInt(arr[i]);
    }
    mRows = sizes[0];
    nColumns = sizes[1];
    iter = sizes[2];
  }

  private void createTwoArrays(List<String> stringList) {
    generateSizes(stringList.get(0));
    startTwoArray = new String[mRows][nColumns];
    generateTwoArray = new int[mRows][nColumns];
    for (int i = 0; i < mRows; i++) {
      String[] arr = stringList.get(i + 1).split(" ");
      for (int j = 0; j < nColumns; j++) {
        startTwoArray[i][j] = arr[j];
        if (arr[j].equals("O")) {
          generateTwoArray[i][j] = 0;
        } else {
          generateTwoArray[i][j] = 1;
        }
      }
    }
  }

  private void nextGeneration() {
    int[][] future = new int[mRows][nColumns];

    int it = 0;

    for (int l = 0; l < mRows; l++) {
      for (int m = 0; m < nColumns; m++) {

        int aliveNeighbours = liveNeighbors(generateTwoArray, mRows, nColumns, l, m);
        ;
////        for (int i = 0; i <= 1; i++) {
////          for (int j = 0; j <= 3; j++) {
////            aliveNeighbours += generateTwoArray[i][j] & 1;
////          }
////        }
//        for (int i = Math.max(l - 1, 0); i <= Math.min(i + 1, mRows - 1); i++) {
//          for (int j = Math.max(m - 1, 0); j <= Math.min(j + 1, nColumns - 1); j++) {
//            aliveNeighbours += generateTwoArray[i][j] & 1;
//          }
//        }
////        lives -= board[i][j] & 1;
//
//        aliveNeighbours -= generateTwoArray[l][m];
        it++;
        System.out.println(generateTwoArray[l][m] + " aliveNeighbours " + aliveNeighbours);
        if ((generateTwoArray[l][m] == 1) && (aliveNeighbours < 2)) {
          future[l][m] = 0;
        } else if ((generateTwoArray[l][m] == 1) && (aliveNeighbours > 3)) {
          future[l][m] = 0;
        } else if ((generateTwoArray[l][m] == 0) && (aliveNeighbours == 3)) {
          future[l][m] = 1;
        } else {
          future[l][m] = generateTwoArray[l][m];
        }
      }
    }
    System.out.println("////" + it);
    generateTwoArray = future;
  }

  public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int lives = 0;
    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        lives += board[(i + x + m) % m][(j + y + n) % n];
      }
    }
    lives -= board[i][j];
    return lives;
  }

  private void writeFile(String fileName) {

  }


}
