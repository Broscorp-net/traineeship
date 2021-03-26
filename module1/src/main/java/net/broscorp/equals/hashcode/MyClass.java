package net.broscorp.equals.hashcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MyClass {

  private int intField;
  private String stringField;
  private Date dateField;

  public MyClass() {
  }

  /**
   * Constructor with parameters intField, stringField.
   *
   * @param intField    instance's intField
   * @param stringField instance's stringField
   */
  public MyClass(int intField, String stringField) {
    this.intField = intField;
    this.stringField = stringField;
    dateField = new Date();
  }

  /**
   * Constructor with parameters intField, stringField, dateField.
   *
   * @param intField    instance's intField
   * @param stringField instance's stringField
   * @param dateField   instance's dateField
   */
  public MyClass(int intField, String stringField, Date dateField) {
    this.intField = intField;
    this.stringField = stringField;
    this.dateField = dateField;
  }

  @Override
  public String toString() {
    String pattern = "dd-MM-yyyy HH-mm-ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    return "MyClass{intField= "
        + intField
        + ", stringField= '"
        + stringField
        + '\''
        + ", dateField= "
        + simpleDateFormat.format(dateField)
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MyClass)) {
      return false;
    }
    MyClass myClass = (MyClass) o;
    return intField == myClass.intField
        && Objects.equals(stringField, myClass.stringField)
        && Objects.equals(dateField, myClass.dateField);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intField, stringField, dateField) % 3;
  }
}
