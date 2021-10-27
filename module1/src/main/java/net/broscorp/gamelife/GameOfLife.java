package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput) {
    BufferedReader fileReader;
    BufferedWriter fileWriter;

    try {
      fileReader = new BufferedReader(new FileReader(fileNameInput));
      fileWriter = new BufferedWriter(new FileWriter(fileNameOutput));

      String[] args = fileReader.readLine().split(",");
      int xSize = Integer.parseInt(args[0]);
      int ySize = Integer.parseInt(args[1]);
      int iterations = Integer.parseInt(args[2]);

      Field field = new Field(xSize, ySize);

      field.parse(fileReader.lines().collect(Collectors.joining("\n")));

      Game game = new Game(field);
      field = game.iterate(iterations);

      fileWriter.write(field.toString());
      fileWriter.close();

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
