package net.broscorp.gamelife;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {
  GameOfLife game = new GameOfLife();

  public boolean equalsFile(String expected, String result) throws IOException {
    Stream<String> gameStreamInput =
        new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(expected)))
            .lines();
    List<String> gameListExpected = gameStreamInput.collect(Collectors.toList());

    Stream<String> gameStreamResult = Files.newBufferedReader(Paths.get(result)).lines();
    List<String> gameListResult = gameStreamResult.collect(Collectors.toList());
    return gameListExpected.equals(gameListResult);
  }

  @Test
  public void stableFigure() throws IOException {
    game.game("src/test/resources/inputStable1.txt", "outputStable1.txt");
    assertTrue(equalsFile("expectedStable1.txt", "outputStable1.txt"));
  }

  @Test
  public void stableFigure2() throws IOException {
    game.game("src/test/resources/inputStable2.txt", "outputStable2.txt");
    assertTrue(equalsFile("expectedStable2.txt", "outputStable2.txt"));
  }

  @Test
  public void oscillatorFigure() throws IOException {
    game.game("src/test/resources/inputOscillator.txt", "outputOscillator.txt");
    assertTrue(equalsFile("expectedOscillator.txt", "outputOscillator.txt"));
  }

  @Test
  public void oscillatorFigure2() throws IOException {
    game.game("src/test/resources/inputOscillator2.txt", "outputOscillator2.txt");
    assertTrue(equalsFile("expectedOscillator2.txt", "outputOscillator2.txt"));
  }

  @Test
  public void gliderFigureEasy() throws IOException {
    game.game("src/test/resources/inputGliderEasy.txt", "outputGliderEasy.txt");
    assertTrue(equalsFile("expectedGliderEasy.txt", "outputGliderEasy.txt"));
  }

  @Test
  public void gliderFigure() throws IOException {
    game.game("src/test/resources/inputGlider.txt", "outputGlider.txt");
    assertTrue(equalsFile("expectedGlider.txt", "outputGlider.txt"));
  }
}
