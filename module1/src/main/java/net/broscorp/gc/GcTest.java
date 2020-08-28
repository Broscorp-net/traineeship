package net.broscorp.gc;

public class GcTest {

  private String name;
  private GcTest gc;
  private static int countOfObject = 0;
  private int numberOfObject;

  public GcTest(String name) {
    this.name = name;
    this.numberOfObject = countOfObject++;
  }

  /**
   * Создаем большое количество объектов и сразу теряем ссылку.
   */
  public void largeNumberOfObjects() {
    for (int i = 0; i < 1_000_000; i++) {
      GcTest gcTest = new GcTest("test1");
    }
  }

  /**
   * Пары объектов, которые ссылаются друг на друга.
   */
  public void twoLinksToOneObject() {
    for (int i = 0; i < 1_000_000; i++) {
      GcTest gcTest1 = new GcTest("test1");
      GcTest gcTest2 = new GcTest("test2");
      gcTest1.setGc(gcTest2);
      gcTest2.setGc(gcTest1);
      gcTest1 = null;
      gcTest2 = null;
    }
  }

  public void setGc(GcTest gcTest) {
    this.gc = gcTest;
  }

  //@Override
  //protected void finalize() {
  //  System.out.println("Упс но я удалил " + this.name + " - " + this.numberOfObject + " объект.");
  //}

  @Override
  public String toString() {
    return "NumberOfObject = " + numberOfObject;
  }
}
