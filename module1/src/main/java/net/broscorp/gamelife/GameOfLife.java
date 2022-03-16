package net.broscorp.gamelife;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfLife {

  String settings = "";
  int iterations;
  int xsize;
  int ysize;
  char[][] gameField;

  /** Game runtime.
   * @param fileNameInput accepts Input file name.
   * @param fileNameOutput accepts Output file name.
   */
  public void game(String fileNameInput, String fileNameOutput) {
    readInput(fileNameInput);

    for (int i = 0; i < iterations; i++) {
      runLifeCycle();
    }
    //showField();
    writeToFile(fileNameOutput);
  }

  /** File reader.
   * @param fileNameInput accepts file name.
   */
  public void readInput(String fileNameInput) {
    try {
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput)));

      String currentLine = reader.readLine();
      String[] settingsReader = currentLine.split(",");

      iterations = Integer.parseInt(settingsReader[2]);
      ysize = Integer.parseInt(settingsReader[0]);
      xsize = Integer.parseInt(settingsReader[1]);
      gameField = new char[ysize][xsize];

      for (int y = 0; y < ysize; y++) {
        currentLine = reader.readLine();
        currentLine = currentLine.replaceAll(" ", "");
        for (int x = 0; x < xsize; x++) {
          gameField[y][x] = currentLine.charAt(x);
        }
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("IO Exception!");
      e.printStackTrace();
    }
  }

  /** File writer.
   * @param fileNameOutput accepts file name.
   */
  public void writeToFile(String fileNameOutput) {
    try {
      BufferedWriter writer = new BufferedWriter(
          new FileWriter("./src/test/resources/" + fileNameOutput));
      String output = "";
      for (int y = 0; y < ysize; y++) {
        for (int x = 0; x < xsize; x++) {
          output += gameField[y][x] + " ";
        }
        output = output.substring(0, output.length() - 1);
        output += "\n";
      }
      output = output.substring(0, output.length() - 1);
      writer.write(output);
      writer.close();
    } catch (IOException e) {
      System.out.println("IOException during file writing!");
      e.printStackTrace();
    }
  }

  /** Method shows console output of the current state of matrix.
   */
  public void showField() {
    String output = "Test case:\n";
    for (int y = 0; y < ysize; y++) {
      for (int x = 0; x < xsize; x++) {
        output += gameField[y][x] + " ";
      }
      output += "\n";
    }
    System.out.println(output);
  }

  /** Checks if cell is alive.
   * @param y represents y coordinate.
   * @param x represents x coordinate.
   * @return true if cell is alive, false if it is dead.
   */
  public boolean checkState(int y, int x) {
    //If x = -1 and xSize = 10, then: (-1 + 10) = 9; 9 % 10 = 9
    //if x = 10 and xSize = 10, then: (10 + 10) = 100; 100 % 10 = 0
    y = (y + ysize) % ysize;
    x = (x + xsize) % xsize;
    boolean survival = (gameField[y][x] == 'X');
    return survival;
  }

  /** Counts living neighbours.
   * @param y for y coordinate.
   * @param x for x coordinate.
   * @return cellCounter amount of living neighbours.
   */
  public int checkNeighbors(int y, int x) {
    int cellCounter = 0;

    //Upper row
    cellCounter += checkState(y - 1, x - 1) ? 1 : 0;
    cellCounter += checkState(y - 1, x) ? 1 : 0;
    cellCounter += checkState(y - 1, x + 1) ? 1 : 0;
    //Middle row
    cellCounter += checkState(y, x - 1) ? 1 : 0;
    //cellCounter += checkState(y, x) ? 1 : 0;
    cellCounter += checkState(y, x + 1) ? 1 : 0;
    //Lower row
    cellCounter += checkState(y + 1, x - 1) ? 1 : 0;
    cellCounter += checkState(y + 1, x) ? 1 : 0;
    cellCounter += checkState(y + 1, x + 1) ? 1 : 0;

    return cellCounter;
  }

  /** Changes the cell state according the game rules.
   * @param newField is a new matrix.
   * @param y is y coordinate.
   * @param x is x coordinate.
   */
  public void changeState(char[][] newField, int y, int x) {
    int neighbors = checkNeighbors(y, x);
    if (checkState(y, x)) {
      newField[y][x] = neighbors > 1 && neighbors < 4 ? 'X' : 'O';
    } else {
      newField[y][x] = neighbors == 3 ? 'X' : 'O';
    }
  }

  /** Runs one game iteration.
   */
  public void runLifeCycle() {
    char[][] newField = new char[ysize][xsize];
    for (int i = 0; i < ysize; i++) {
      for (int a = 0; a < xsize; a++) {
        changeState(newField, i, a);
      }
    }
    gameField = newField;
    //showField();
  }
}
