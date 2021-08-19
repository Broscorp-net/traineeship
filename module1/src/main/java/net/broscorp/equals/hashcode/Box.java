package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Box {

  private int height;
  private int width;

  public Box(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Box box = (Box) o;

    if (height != box.height) {
      return false;
    }
    return width == box.width;
  }

  @Override
  public int hashCode() {
    int result = height;
    result = 31 * result + width;
    return result;
  }

  @Override
  public String toString() {
    return "Box{" + "height=" + height + ", width=" + width + '}';
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Method returns list of boxes with hashcode collision.
   *
   * @return List
   */
  public static List<Box> getBoxesHashcodeCollision() {
    List<Box> listBoxes = new ArrayList<>();
    List<Box> listBoxesCollisionHash = new ArrayList<>();
    for (int i = 0; i < 40; i++) {
      for (int j = 0; j < 40; j++) {
        listBoxes.add(new Box(i, j));
      }
    }

    for (Box box : listBoxes) {
      for (Box box1 : listBoxes) {
        if (!box.equals(box1) && box.hashCode() == box1.hashCode()) {
          listBoxesCollisionHash.add(box);
        }
      }
    }

    listBoxesCollisionHash.sort(Comparator.comparingInt(Box::hashCode));
    return listBoxesCollisionHash;
  }
}
