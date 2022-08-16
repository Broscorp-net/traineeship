package net.broscorp.oop.solid.ocp;

public class ColorTag extends SortableTag {

  static final String[] colors = new String[]{
      "red",
      "orange",
      "yellow",
      "green",
      "blue",
      "violet",
  };

  private ColorTag(String color) {
    super(color);
  }

  static ColorTag red() {
    return new ColorTag("red");
  }

  static ColorTag orange() {
    return new ColorTag("orange");
  }

  static ColorTag yellow() {
    return new ColorTag("yellow");
  }

  static ColorTag green() {
    return new ColorTag("green");
  }

  static ColorTag blue() {
    return new ColorTag("blue");
  }

  static ColorTag violet() {
    return new ColorTag("violet");
  }

}
