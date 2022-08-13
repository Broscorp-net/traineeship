package net.broscorp.equals.hashcode;

public class Rectangle {
  private final int width;
  private final int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rectangle rectangle = (Rectangle) o;
    return width == rectangle.width && height == rectangle.height;
  }

  @Override
  public int hashCode() {
    return width * width + height;
  }

  @Override
  public String toString() {
    return "Rectangle{" + "a=" + width + ", b=" + height + '}';
  }
}
