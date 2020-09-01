package net.broscorp.gc;

import java.io.FileWriter;
import java.io.IOException;

public class GcTest {

  private String name;
  private GcTest gc;
  private static int countOfObject = 0;
  private int numberOfObject;

  public GcTest() {
  }

  public GcTest(String name) {
    this.name = name;
    this.numberOfObject = countOfObject++;
  }

  /**
   * Создаем большое количество объектов и сразу теряем ссылку.
   */
  public void largeNumberOfObjects() {
    for (int i = 0; i < 1_000_000; i++) {
      GcTest gcTest = new GcTest("Object");
    }
  }

  /**
   * Пары объектов, которые ссылаются друг на друга.
   */
  public void twoLinksToOneObject() {
    for (int i = 0; i < 1_000_000; i++) {
      GcTest gcTest1 = new GcTest("First object");
      GcTest gcTest2 = new GcTest("Second object");
      gcTest1.setGc(gcTest2);
      gcTest2.setGc(gcTest1);
      gcTest1 = null;
      gcTest2 = null;
    }
  }

  public void setGc(GcTest gcTest) {
    this.gc = gcTest;
  }

  //  @Override
  //  protected void finalize() {
  //    try(FileWriter writer = new FileWriter("secondLog.txt", true)){
  //      String massage = this.name + " - " + this.numberOfObject + " was delete.";
  //      writer.append(massage).append("\n");
  //      writer.flush();
  //    } catch (IOException ex) {
  //      System.out.println(ex.getMessage());
  //    }
  //  }

  @Override
  public String toString() {
    return "NumberOfObject = " + numberOfObject;
  }
}
