package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfLife {

  protected int iterations;
  protected int rows;
  protected int columns;
  protected char[][] fields;

  public void game(String fileNameInput, String fileNameOutput) {

    try {
      readFile(fileNameInput);

      mainFlow();

      writeToFile(fileNameOutput);

    } catch (IOException e) {
      System.err.println(e);
    }
  }

  private void rebaseField(char[][] newField, int y, int x) {
    int neighbors = checkNeighbors(y, x);
    if (checkForFieldX(y, x)) {
      newField[y][x] = neighbors > 1 && neighbors < 4 ? 'X' : 'O';
    } else {
      newField[y][x] = neighbors == 3 ? 'X' : 'O';
    }
  }

  private boolean checkForFieldX(int y, int x) {
    return (fields[(y + columns) % columns][(x + rows) % rows] == 'X');
  }

  private boolean checkForFieldO(int y, int x) {
    return (fields[(y + columns) % columns][(x + rows) % rows] == 'O');
  }

  private int checkNeighbors(int y, int x) {
    int counter = 0;

    if (checkForFieldX(y - 1, x - 1)) {
      counter += 1;
    }

    if (checkForFieldX(y - 1, x)) {
      counter += 1;
    }

    if (checkForFieldX(y - 1, x + 1)) {
      counter += 1;
    }

    if (checkForFieldX(y, x - 1)) {
      counter += 1;
    }

    if (checkForFieldX(y, x + 1)) {
      counter += 1;
    }

    if (checkForFieldX(y + 1, x - 1)) {
      counter += 1;
    }

    if (checkForFieldX(y + 1, x)) {
      counter += 1;
    }

    if (checkForFieldX(y + 1, x + 1)) {
      counter += 1;
    }

    return counter;
  }

  private void mainFlow() {
    for (int i = 0; i < iterations; i++) {
      char[][] newFields = new char[columns][rows];
      for (int j = 0; j < columns; j++) {
        for (int k = 0; k < rows; k++) {
          rebaseField(newFields, j, k);
        }
      }
      fields = newFields;
    }
  }

  private void readFile(String fileNameInput) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput)));

    String input = bufferedReader.readLine();
    String[] settingsReader = input.split(",");

    iterations = Integer.parseInt(settingsReader[2]);
    columns = Integer.parseInt(settingsReader[0]);
    rows = Integer.parseInt(settingsReader[1]);
    fields = new char[columns][rows];

    for (int y = 0; y < columns; y++) {
      input = bufferedReader.readLine();
      input = input.replaceAll(" ", "");
      for (int x = 0; x < rows; x++) {
        fields[y][x] = input.charAt(x);
      }
    }
    bufferedReader.close();

  }

  private void writeToFile(String fileNameOutput) throws IOException {

    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("./src/test/resources/" + fileNameOutput));

    String output = "";

    for (int y = 0; y < columns; y++) {
      for (int x = 0; x < rows; x++) {
        output += fields[y][x] + " ";
      }
      output = output.substring(0, output.length() - 1) + "\n";
    }

    output = output.substring(0, output.length() - 1);
    bufferedWriter.write(output);
    bufferedWriter.close();

  }
}
