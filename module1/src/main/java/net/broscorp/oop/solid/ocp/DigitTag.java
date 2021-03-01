package net.broscorp.oop.solid.ocp;

public class DigitTag extends SortableTag {

  static final String[] digits = new String[]{
      "zero",
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine",
      "ten",
  };

  private DigitTag(String word) {
    super(word);
  }

  static DigitTag zero() {
    return new DigitTag("zero");
  }

  static DigitTag one() {
    return new DigitTag("one");
  }

  static DigitTag two() {
    return new DigitTag("two");
  }

  static DigitTag three() {
    return new DigitTag("three");
  }

  static DigitTag four() {
    return new DigitTag("four");
  }

  static DigitTag five() {
    return new DigitTag("five");
  }

  static DigitTag six() {
    return new DigitTag("six");
  }

  static DigitTag seven() {
    return new DigitTag("seven");
  }

  static DigitTag eight() {
    return new DigitTag("eight");
  }

  static DigitTag nine() {
    return new DigitTag("nine");
  }

  static DigitTag ten() {
    return new DigitTag("ten");
  }

}
