package net.broscorp.gamelife;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GameOfLife {

  private int widthOfField;
  private int heightOfField;
  private int countOfIterations;
  private char[][] currentFields;
  private char[][] nextStepFields;

  /**
   * Start game simulation with input data from fileNameInput and write it to fileNameOutput.
   */
  public void game(String fileNameInput, String fileNameOutput) {
    fileReader(fileNameInput);
    for (int i = 0; i < countOfIterations; i++) {
      processIteration();
    }
    fileWriter(fileNameOutput);
  }

  private void fileReader(String fileNameInput) {
    try (Scanner scanner = new Scanner(new File("./target/test-classes/" + fileNameInput))) {
      String infoLine = scanner.next();
      String[] info = infoLine.split(",");
      heightOfField = Integer.parseInt(info[0]);
      widthOfField = Integer.parseInt(info[1]);
      countOfIterations = Integer.parseInt(info[2]);
      currentFields = new char[heightOfField][widthOfField];
      nextStepFields = new char[heightOfField][widthOfField];
      scanner.nextLine();
      for (int i = 0; i < heightOfField; i++) {
        String next = scanner.nextLine();
        next = next.replaceAll(" ", "");
        char[] chars = next.toCharArray();
        currentFields[i] = Arrays.copyOf(chars, widthOfField);
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
  }

  private void processIteration() {
    for (int j = 0; j < heightOfField; j++) {
      for (int k = 0; k < widthOfField; k++) {
        isAlive(j, k);
        if (j == heightOfField - 1 && k == widthOfField - 1) {
          for (int l = 0; l < heightOfField; l++) {
            currentFields[l] = Arrays.copyOf(nextStepFields[l], widthOfField);
          }
        }
      }
    }
  }

  private void isAlive(int j, int k) {
    int[] axisXCoords = {
        j - 1 < 0 ? heightOfField - 1 : j - 1,
        j,
        j + 1 == heightOfField ? 0 : j + 1
    };

    int[] axisYCoords = {
        k - 1 < 0 ? widthOfField - 1 : k - 1,
        k,
        k + 1 == widthOfField ? 0 : k + 1
    };

    nextStepFields[j][k] = willBeAlive(j, k, isNeighboursAlive(axisXCoords, axisYCoords));
  }

  private int isNeighboursAlive(int[] axisXCoords, int[] axisYCoords) {
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        if (currentFields[axisXCoords[i]][axisYCoords[j]] == 'X') {
          ++count;
        }
      }
    }
    return count;
  }

  private char willBeAlive(int j, int k, int count) {
    if ((currentFields[j][k] == 'O' && count == 3) || (currentFields[j][k] == 'X' && count > 1
        && count < 4)) {
      return 'X';
    }
    return 'O';
  }

  private void fileWriter(String fileNameOutput) {
    try (FileOutputStream fos = new FileOutputStream("./target/test-classes/" + fileNameOutput)) {
      for (int i = 0; i < heightOfField; i++) {
        fos.write(Arrays.toString(currentFields[i]).replaceAll("\\W", " ").replaceAll("\\s{2}", " ")
            .trim().getBytes());
        fos.write('\n');
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
