package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class GameOfLife {

  /**
   * Conway's Game of Life simulation.
   *
   * @param fileNameInput  file with input data
   * @param fileNameOutput file with output data
   */
  public void game(String fileNameInput, String fileNameOutput) {

    //
    BufferedReader fileReader;
    PrintWriter fileWriter;

    try {
      fileReader = new BufferedReader(
          new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileNameInput)));
      fileWriter = new PrintWriter(
          getClass().getClassLoader().getResource(".").getFile() + fileNameOutput);

      String[] args = fileReader.readLine().split(",");
      int yaxisSize = Integer.parseInt(args[0]);
      int xaxisSize = Integer.parseInt(args[1]);
      int iterations = Integer.parseInt(args[2]);

      Field field = new Field(xaxisSize, yaxisSize);

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

}
