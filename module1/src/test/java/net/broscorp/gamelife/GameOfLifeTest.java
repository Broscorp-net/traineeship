package net.broscorp.gamelife;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {

  GameOfLife game = new GameOfLife();

  public boolean equalsFile(String expected, String result) {
    Stream<String> gameStreamInput = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream(expected))).lines();
    List<String> gameListExpected = gameStreamInput.collect(Collectors.toList());
    ClassLoader classLoader = GameOfLife.class.getClassLoader();
    Stream<String> gameStreamResult = new BufferedReader(
        new InputStreamReader(classLoader.getSystemResourceAsStream(result))).lines();
    List<String> gameListResult = gameStreamResult.collect(Collectors.toList());
    return gameListExpected.equals(gameListResult);
  }

  @Test
  public void stableFigure() {
    game.game("inputStable1.txt", "outputStable1.txt");
    assertTrue(equalsFile("expectedStable1.txt", "outputStable1.txt"));
  }

  @Test
  public void stableFigure2() {
    game.game("inputStable2.txt", "outputStable2.txt");
    assertTrue(equalsFile("expectedStable2.txt", "outputStable2.txt"));
  }

  @Test
  public void oscillatorFigure() {
    game.game("inputOscillator.txt", "outputOscillator.txt");
    assertTrue(equalsFile("expectedOscillator.txt", "outputOscillator.txt"));
  }

  @Test
  public void oscillatorFigure2() {
    game.game("inputOscillator2.txt", "outputOscillator2.txt");
    assertTrue(equalsFile("expectedOscillator2.txt", "outputOscillator2.txt"));
  }

  @Test
  public void gliderFigureEasy() {
    game.game("inputGliderEasy.txt", "outputGliderEasy.txt");
    assertTrue(equalsFile("expectedGliderEasy.txt", "outputGliderEasy.txt"));
  }

  @Test
  public void gliderFigure() {
    game.game("inputGlider.txt", "outputGlider.txt");
    assertTrue(equalsFile("expectedGlider.txt", "outputGlider.txt"));
  }
}