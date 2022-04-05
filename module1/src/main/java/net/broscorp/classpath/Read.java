package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String arg = reader.readLine();
    Write write = new Write();
    write.print(arg);
  }
}
