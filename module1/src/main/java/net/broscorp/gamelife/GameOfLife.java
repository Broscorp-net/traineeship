package net.broscorp.gamelife;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

  public static void main(String[] args) {
    String fileName = "src/test/resources/inputGliderEasy.txt";
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(fileName),
          StandardCharsets.UTF_8);
      System.out.println(lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String string = lines.get(3);
    System.out.println(string);
    lines.remove(0);
    lines.remove(1);
    lines.remove(2);
    System.out.println(lines);

//    String fileNameInput = "inputExample.txt";
//    ClassLoader classLoader = GameOfLife.class.getClassLoader();
//    Stream<String> gameStreamInput = new BufferedReader(
//        new InputStreamReader(classLoader.getSystemResourceAsStream(fileNameInput))).lines();
//    List<String> gameListExpected = gameStreamInput.collect(Collectors.toList());
  }

  public void game(String fileNameInput, String fileNameOutput){


  }

}
