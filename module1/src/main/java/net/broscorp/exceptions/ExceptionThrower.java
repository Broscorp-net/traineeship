package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionThrower {

  /**
   * Method throws IOException, catches it and returns message from finally block.
   * @return message from finally block
   */
  public String throwIoException() {
    String message = null;

    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
      String data = reader.readLine();
      // do something
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      message = "Oops... Goodbye from finally block!";
    }

    return message;
  }

  /**
   * Method throws FileNotFound and returns message from the first catch block.
   * The second catch block should be ignored.
   * @return message from the first catch block
   */
  public String throwFileNotFoundException() {
    String message = null;

    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
      String data = reader.readLine();
      // do something
    } catch (FileNotFoundException ex) {
      message = "Hello from first catch block!";
    } catch (IOException ex) {
      message = "Wrong catch block";
    }

    return message;
  }

}
