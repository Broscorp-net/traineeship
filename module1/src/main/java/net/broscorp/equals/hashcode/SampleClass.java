package net.broscorp.equals.hashcode;

import java.util.Objects;

public class SampleClass {

  private int intProperty;

  private String strProperty;

  public SampleClass(int intProp, String strProp) {
    this.intProperty = intProp;
    this.strProperty = strProp;
  }

  @Override
  public String toString() {
    String toString = String.format("Class: %s, Integer property: %d, String property: %s",
        this.getClass().getName(), this.intProperty, this.strProperty);
    return toString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleClass that = (SampleClass) o;
    return intProperty == that.intProperty && Objects.equals(strProperty, that.strProperty);
  }

  public int hashCode() {
    return this.strProperty.hashCode() + this.intProperty;
  }
}
