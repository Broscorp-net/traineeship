package net.broscorp.gamelife;

/**
 * This is main class for start app.
 * @author Hryhorii Perets
 * @version 1.0
 */
public class StartGameOfLife {

  /**
   * This is main method.
   * @param args this is method do not parameters
   */
  public static void main(String[] args) {
    GameOfLife gameOfLife = new GameOfLife();

    gameOfLife.game("inputFile.txt", "outputFile.txt");

  }
}
