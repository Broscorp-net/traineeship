package net.broscorp.gc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Format;
import java.util.logging.Logger;

public class SimpleObject {

  private String message;

  public SimpleObject() {
  }

  public SimpleObject(String message) {
    this.message = message;
  }

  @Override
  protected void finalize() throws FileNotFoundException {
    System.out.printf("The finalize() № %s started \n",message);
    System.out.printf("SimpleObject with HashCode %d available after finalize() \n", this.hashCode());

  }

}
