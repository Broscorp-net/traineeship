package net.broscorp.equals;

public class MyCars {

  private String name;
  private String color;
  private int number;
  private static int count = 0;

  public MyCars(String name, String[] colorArr) {
    this.name = name + '_' + ++count;
    this.color = colorArr[0];
    this.number = count;
  }
}
