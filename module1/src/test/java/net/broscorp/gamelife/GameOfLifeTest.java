package net.broscorp.gamelife;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {

  GameOfLife game = new GameOfLife();

  public boolean equalsFile(String expected, String result) {
    ClassLoader classLoader = GameOfLife.class.getClassLoader();
    List<String> gameListExpected = null;
    List<String> gameListResult = null;
    try (FileInputStream fis = new FileInputStream(expected)) {
      Stream<String> gameStreamInput = new BufferedReader(
          new InputStreamReader(fis)).lines();
      gameListExpected = gameStreamInput.collect(Collectors.toList());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    try (FileInputStream fis = new FileInputStream(result)) {
      Stream<String> gameStreamResult = new BufferedReader(
          new InputStreamReader(fis)).lines();
      gameListResult = gameStreamResult.collect(Collectors.toList());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    assert gameListExpected != null;
    return gameListExpected.equals(gameListResult);
  }

  @Test
  public void stableFigure() {
    game.game("./target/test-classes/inputStable1.txt", "./target/test-classes/outputStable1.txt");
    assertTrue(equalsFile("./target/test-classes/expectedStable1.txt",
        "./target/test-classes/outputStable1.txt"));
  }

  @Test
  public void stableFigure2() {
    game.game("./target/test-classes/inputStable2.txt", "./target/test-classes/outputStable2.txt");
    assertTrue(equalsFile("./target/test-classes/expectedStable2.txt",
        "./target/test-classes/outputStable2.txt"));
  }

  @Test
  public void oscillatorFigure() {
    game.game("./target/test-classes/inputOscillator.txt",
        "./target/test-classes/outputOscillator.txt");
    assertTrue(equalsFile("./target/test-classes/expectedOscillator.txt",
        "./target/test-classes/outputOscillator.txt"));
  }

  @Test
  public void oscillatorFigure2() {
    game.game("./target/test-classes/inputOscillator2.txt",
        "./target/test-classes/outputOscillator2.txt");
    assertTrue(equalsFile("./target/test-classes/expectedOscillator2.txt",
        "./target/test-classes/outputOscillator2.txt"));
  }

  @Test
  public void gliderFigureEasy() {
    game.game("./target/test-classes/inputGliderEasy.txt",
        "./target/test-classes/outputGliderEasy.txt");
    assertTrue(equalsFile("./target/test-classes/expectedGliderEasy.txt",
        "./target/test-classes/outputGliderEasy.txt"));
  }

  @Test
  public void gliderFigure() {
    game.game("./target/test-classes/inputGlider.txt", "./target/test-classes/outputGlider.txt");
    assertTrue(equalsFile("./target/test-classes/expectedGlider.txt",
        "./target/test-classes/outputGlider.txt"));
  }
}