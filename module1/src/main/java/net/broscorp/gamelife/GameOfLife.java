package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  public void game(String fileNameInput, String fileNameOutput){



  }

  public boolean[][] areaOfLife(int n, int m) {
    boolean[][] randomAreaOfLife = new boolean[n][m];
    Random random = new Random();
    for(int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        randomAreaOfLife[i][j] = random.nextBoolean();
      }
    return randomAreaOfLife;
  }

  public boolean[][] nextStepLifeCycle(boolean[][] previousLifeCycle) {
    boolean[][] nextLifeCycle = new boolean[previousLifeCycle.length][previousLifeCycle[0].length];

    for (int i = 0; i < previousLifeCycle.length; i++)
      for (int j = 0; j < previousLifeCycle[0].length; j++) {
        if (!previousLifeCycle[i][j]) {
          if (numberOfLivingNeighbors(previousLifeCycle, i, j) == 3) {
            nextLifeCycle[i][j] = true;
          }
        }

        if (previousLifeCycle[i][j]) {
          if ((numberOfLivingNeighbors(previousLifeCycle, i, j) == 2) || (numberOfLivingNeighbors(previousLifeCycle, i, j) == 3)) {
            nextLifeCycle[i][j] = true;
          }
        }
      }
    return nextLifeCycle;

  }
    public int numberOfLivingNeighbors(boolean[][] currentAreaOfLife, int currentPositionX, int currentPositionY) {
      int livingNeighbors = 0;
      for (int i = -1; i < 2; i++)
        for (int j = -1; j < 2; j++){
          if ((i == 0) && (j == 0)) {
            continue;
          }
          if (currentAreaOfLife[getNeighborPosition(currentAreaOfLife.length, currentPositionX, i)][getNeighborPosition(currentAreaOfLife[0].length, currentPositionY, j)]) {
            livingNeighbors++;
          }
        }
      return livingNeighbors;
    }

    public int getNeighborPosition(int maxValue, int currentPosition, int step) {
      if ((currentPosition + step) < 0) {
        return maxValue - 1;
      }
      if ((currentPosition + step) > (maxValue - 1)) {
        return 0;
      }
      return currentPosition + step;

    }


    public void writeToFile(String fileNameOutput, String str) {
      try {
        URI uri = ClassLoader.getSystemResource(fileNameOutput).toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path) ) {
            bufferedWriter.write(str);
        }

      }
      catch (URISyntaxException | IOException ex) {
        ex.getStackTrace();
      }

    }


      public void readFromFile(String fileNameInput){
        int n = 0;
        int m = 0;
        int cycle = 0;
        boolean[][] areaOfLife = new boolean[n][m];
/*
        ClassLoader classLoader = GameOfLife.class.getClassLoader();
        Stream<String> gameStreamInput = new BufferedReader(
            new InputStreamReader(classLoader.getSystemResourceAsStream(fileNameInput))).lines();
        List<String> gameListStarted = gameStreamInput.collect(Collectors.toList());
        for (String str: gameListStarted) {
          System.out.println(str);
        }
*/
        ClassLoader classLoader = GameOfLife.class.getClassLoader();
        try(BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(classLoader.getSystemResourceAsStream(fileNameInput)))) {
          int cf;
          while ((cf = bufferedReader.read()) != 0) {
            n =
          }

        }
        catch (IOException ex) {

        }

    }

}
