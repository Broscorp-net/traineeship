package net.broscorp.gamelife;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {

  private GameOfLife game = new GameOfLife();

  boolean equalsFile(String expected, String result) {
    Stream<String> gameStreamInput = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(expected)))).lines();
    List<String> gameListExpected = gameStreamInput.collect(Collectors.toList());
    ClassLoader classLoader = GameOfLife.class.getClassLoader();
    Stream<String> gameStreamResult = new BufferedReader(
        new InputStreamReader(Objects.requireNonNull(
            classLoader.getSystemResourceAsStream(result)))).lines();
    List<String> gameListResult = gameStreamResult.collect(Collectors.toList());
    return gameListExpected.equals(gameListResult);
  }

  @Test
  void stableFigure() {
    game.game("inputStable1.txt", "outputStable1.txt");
    assertTrue(equalsFile("expectedStable1.txt", "outputStable1.txt"));
  }

  @Test
  void stableFigure2() {
    game.game("inputStable2.txt", "outputStable2.txt");
    assertTrue(equalsFile("expectedStable2.txt", "outputStable2.txt"));
  }

  @Test
  void oscillatorFigure() {
    game.game("inputOscillator.txt", "outputOscillator.txt");
    assertTrue(equalsFile("expectedOscillator.txt", "outputOscillator.txt"));
  }

  @Test
  void oscillatorFigure2() {
    game.game("inputOscillator2.txt", "outputOscillator2.txt");
    assertTrue(equalsFile("expectedOscillator2.txt", "outputOscillator2.txt"));
  }

  @Test
  void gliderFigureEasy() {
    game.game("inputGliderEasy.txt", "outputGliderEasy.txt");
    assertTrue(equalsFile("expectedGliderEasy.txt", "outputGliderEasy.txt"));
  }

  @Test
  void gliderFigure() {
    game.game("inputGlider.txt", "outputGlider.txt");
    assertTrue(equalsFile("expectedGlider.txt", "outputGlider.txt"));
  }
}