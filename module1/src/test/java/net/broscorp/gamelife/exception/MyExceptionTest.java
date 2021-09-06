package net.broscorp.gamelife.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class MyExceptionTest {

  @Test
  void myIoExceptionTest() {
    File file = null;
    String url = "c://1.txt";
    try {
      Path path = Paths.get(url);
      Files.deleteIfExists(path);
      file = Files.createFile(path).toFile();
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write("Test ");
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //open file
    try (FileReader reader = new FileReader(file)) {
      int c;
      //will be thrown IOException because reader.close()
      while ((c = reader.read()) != -1) {
        System.out.println((char) c);
        reader.close();
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException e) {
      //e.printStackTrace();
      System.out.println("overcome the exception :-)");
    } finally {
      System.out.println();
      System.out.println("Bye!!!");
    }
  }
}
