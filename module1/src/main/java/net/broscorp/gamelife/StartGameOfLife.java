package net.broscorp.gamelife;


/**
 * @author Hryhorii Perets
 */
public class StartGameOfLife {
  public static void main(String[] args) {
    GameOfLife gameOfLife = new GameOfLife();

    gameOfLife.game("inputFile.txt", "outputFile.txt");

  }
}
