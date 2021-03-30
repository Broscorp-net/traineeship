package net.broscorp.oop.solid.ocp;

public class BooleanTag extends SortableTag {

  static final BooleanTag TRUE_TAG = new BooleanTag("true");
  static final BooleanTag FALSE_TAG = new BooleanTag("false");

  private BooleanTag(String word) {
    super(word);
  }

}
