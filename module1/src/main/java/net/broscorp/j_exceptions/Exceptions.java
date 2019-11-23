package net.broscorp.j_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {
  public void exceptionsHierarchy(String file_Tap) {
    try (BufferedReader br =
        new BufferedReader(new FileReader(file_Tap))) {
      throw new IOException();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception b) {
      b.printStackTrace();
    } catch (Throwable c) {
      c.printStackTrace();
    } finally {
      System.out.println("Goodbay!!");
    }
  }

}
