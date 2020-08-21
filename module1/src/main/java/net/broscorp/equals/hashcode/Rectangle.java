package net.broscorp.equals.hashcode;


public class Rectangle {

  int height;
  int width;

  public Rectangle(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public String toString() {
    return "Rectangle{"
        + "height="
        + height
        + ", width="
        + width
        + '}';
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
    return (height == rectangle.height && width == rectangle.width)
        || (height == rectangle.width && width == rectangle.height);
  }

  @Override
  public int hashCode() {
    return height * width;
  }
}