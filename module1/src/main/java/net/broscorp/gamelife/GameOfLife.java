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

  public static void main(String[] args) {
    GameOfLife game = new GameOfLife();
    game.game("./GameOfLifeInputFile.txt", "./GameOfLifeOutputFile.txt");
  }

  public void game(String fileNameInput, String fileNameOutput) {
    try (Scanner scanner = new Scanner(new File(fileNameInput))) {
      widthOfField = scanner.nextInt();
      heightOfField = scanner.nextInt();
      countOfIterations = scanner.nextInt();
      currentFields = new char[heightOfField][widthOfField];
      nextStepFields = new char[heightOfField][widthOfField];
      for (int i = 0; i < heightOfField; i++) {
        char[] chars = scanner.next().toCharArray();
        currentFields[i] = Arrays.copyOf(chars, widthOfField);
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    for (int i = 0; i < countOfIterations; i++) {
      for (int j = 0; j < heightOfField; j++) {
        for (int k = 0; k < widthOfField; k++) {
          isAlive(j, k);
          if (j == heightOfField - 1 && k == widthOfField - 1) {
            for (int l = 0; l < heightOfField; l++) {
              currentFields[l] = Arrays.copyOf(nextStepFields[l], widthOfField);
//              System.out.println(currentFields[l]);
            }
//            System.out.println("------");
          }
        }
      }
    }
    try (FileOutputStream fos = new FileOutputStream(fileNameOutput)) {
      for (int i = 0; i < heightOfField; i++) {
        fos.write(Arrays.toString(currentFields[i]).replaceAll("\\W", "").getBytes());
        fos.write('\n');
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void isAlive(int j, int k) {
    int count = 0;
    int highLine;
    int bottomLine;
    int leftLine;
    int rightLine;
    if (j - 1 < 0) {
      highLine = heightOfField - 1;
    } else {
      highLine = j - 1;
    }
    if (j + 1 == heightOfField) {
      bottomLine = 0;
    } else {
      bottomLine = j + 1;
    }
    if (k - 1 < 0) {
      leftLine = widthOfField - 1;
    } else {
      leftLine = k - 1;
    }
    if (k + 1 == widthOfField) {
      rightLine = 0;
    } else {
      rightLine = k + 1;
    }
    if (currentFields[highLine][leftLine] == 'O') count++;
    if (currentFields[highLine][k] == 'O') count++;
    if (currentFields[highLine][rightLine] == 'O') count++;
    if (currentFields[j][leftLine] == 'O') count++;
    if (currentFields[j][rightLine] == 'O') count++;
    if (currentFields[bottomLine][leftLine] == 'O') count++;
    if (currentFields[bottomLine][k] == 'O') count++;
    if (currentFields[bottomLine][rightLine] == 'O') count++;

    if (currentFields[j][k] == 'X' && count == 3) {
      nextStepFields[j][k] = 'O';
      return;
    } else {
      nextStepFields[j][k] = 'X';
    }

    if (currentFields[j][k] == 'O' && count > 1 && count < 4) {
      nextStepFields[j][k] = 'O';
    } else {
      nextStepFields[j][k] = 'X';
    }

//    System.out.println("Field " + j + " " + k + " was " + currentFields[j][k] + " has highline " + highLine + " bottomline " + bottomLine + " leftline " + leftLine + " rightlint " + rightLine + " and will be " + nextStepFields[j][k] + " becouse have " + count + " neighbornhoods");
  }
}
