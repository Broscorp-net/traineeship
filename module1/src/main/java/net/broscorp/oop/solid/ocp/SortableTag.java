package net.broscorp.oop.solid.ocp;

import java.util.Arrays;

public abstract class SortableTag implements Comparable<SortableTag> {

  private final String word;

  String getWord() {
    return word;
  }

  SortableTag(String word) {
    this.word = word;
  }

  @Override
  public int compareTo(SortableTag anotherTag) {
    if (this.getClass() != anotherTag.getClass()) {
      throw new IllegalStateException(String.format("These classes are uncomparable: %s and %s",
          this.getClass(), anotherTag.getClass()));
    }

    if (this.word.equals(anotherTag.word)) {
      return 0;
    }

    String[] tags = null;
    if (anotherTag instanceof ColorTag) {
      tags = ColorTag.colors;
    }
    if (anotherTag instanceof DigitTag) {
      tags = DigitTag.digits;
    }

    if (tags != null) {
      int thisIndex = Arrays.binarySearch(tags, this.word);
      int anotherIndex = Arrays.binarySearch(tags, anotherTag.word);
      return Integer.compare(thisIndex, anotherIndex);
    }

    boolean thisBoolean = BooleanTag.TRUE_TAG.getWord().equals(this.word);
    boolean anotherBoolean = BooleanTag.TRUE_TAG.getWord().equals(anotherTag.word);
    return Boolean.compare(thisBoolean, anotherBoolean);
  }

}
