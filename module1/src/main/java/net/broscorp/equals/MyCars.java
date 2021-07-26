package net.broscorp.equals;

import java.util.Objects;

public class MyCars {

  private String name;
  private String color;
  private static int count = 0;

  MyCars(String name, String[] colorArr) {
    this.name = name + '_' + ++count;
    this.color = colorArr[(count - 1) % 4];
  }

  MyCars(String name, String color, int num) {
    this.name = name + '_' + num;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyCars myCars = (MyCars) o;
    return Objects.equals(name, myCars.name)
        && Objects.equals(color, myCars.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color);
  }

  @Override
  public String toString() {
    return "MyCars{"
        + "name='" + name + '\''
        + ", color='" + color + '\''
        + '}';
  }
}
