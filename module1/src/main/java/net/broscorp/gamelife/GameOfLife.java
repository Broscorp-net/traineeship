package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameOfLife {

  //X O
  public void game(String fileNameInput, String fileNameOutput) {
    BufferedReader fileReader;
    BufferedWriter fileWriter;

    try {
      fileReader = new BufferedReader(new FileReader(fileNameInput));
      fileWriter = new BufferedWriter(new FileWriter(fileNameOutput));

      String[] args = fileReader.readLine().split(",");
      int xSize = Integer.parseInt(args[0]);
      int ySize = Integer.parseInt(args[1]);
      Integer iterations = Integer.valueOf(args[2]);

      Field field = new Field(xSize, ySize);

      String[] line;

      for (int i = 0; i < ySize; i++) {
        line = fileReader.readLine().split(" ");

        for (int j = 0; j < xSize; j++) {
          if (line[j].charAt(0) == 'X') {
            field.createCell(j, i);
          }
        }
      }

      field.printField(System.out);

    } catch (FileNotFoundException exception) {
      System.out.println("Could not load file provided");
    } catch (IOException e) {
      System.out.println("Unexpected IO exception");
    }
  }

  public static void main(String[] args) {
    GameOfLife gameOfLife = new GameOfLife();
    gameOfLife.game(
        "D:\\java\\broscorp\\traineeship\\module1\\src\\test\\resources\\inputGlider.txt",
        "D:\\expectedGlider.txt");
  }

}
