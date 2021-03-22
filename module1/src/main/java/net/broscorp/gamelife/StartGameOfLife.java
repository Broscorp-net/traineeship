package net.broscorp.gamelife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Hryhorii Perets
 */
public class StartGameOfLife {
  public static void main(String[] args) {
    GameOfLife gameOfLife = new GameOfLife();

    gameOfLife.game("inputFile.txt", "outputFile.txt");

    System.out.println(gameOfLife.equalsFile("ExpectedGlider.txt", "outputGlider.txt"));


  /*

    boolean[][] newAreaOfLife = gameOfLife.areaOfLife(15, 15);

/*
    for(boolean[] line: newAreaOfLife){
      for (boolean step: line){
        System.out.printf("%s ",step);
      }
      System. out.println();
    }


    for (int i = 0; i < newAreaOfLife.length; i++) {
      for (int j = 0; j < newAreaOfLife[0].length; j++) {
        System.out.printf("Статус клетки %s, количество соседей  %d\n",newAreaOfLife[i][j], gameOfLife.numberOfLivingNeighbors(newAreaOfLife, i, j));
      }
    }

    for (int i = 0; i < 5; i++ ){
      newAreaOfLife = gameOfLife.nextStepLifeCycle(newAreaOfLife);

      for(boolean[] line: newAreaOfLife){
        for (boolean step: line){
          System.out.printf("%s ",step);
        }
        System. out.println();
      }

      System.out.println();
    }
*/
    /*
    String str = "";
    for (boolean[] line : newAreaOfLife) {
      for (boolean step : line) {
        if (step) {
          str += Character.toString('X');
        } else {
          str += Character.toString('O');
        }
        str += " ";
      }
      str += "\n";
    }

    gameOfLife.writeToFile("outputFile.txt", str);

    boolean[][] testArea = gameOfLife.areaOfLife(gameOfLife.readFromFile("inputFile.txt"));

    for (boolean[] line : testArea) {
      for (boolean step : line) {
        System.out.printf("%s ",step);
      }
      System.out.println();

    }

    */
  }
}
