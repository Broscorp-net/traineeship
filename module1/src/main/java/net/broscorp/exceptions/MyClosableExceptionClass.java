package net.broscorp.exceptions;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class MyClosableExceptionClass extends IOException implements Closeable {


  public MyClosableExceptionClass() {
    super();

  }

  void throwsMyException() throws MyClosableExceptionClass {
    throw new MyClosableExceptionClass();
  }

  @Override
  public void close() throws IOException{
    System.out.println("MyClosableExceptionClass was closed");
  }
}
