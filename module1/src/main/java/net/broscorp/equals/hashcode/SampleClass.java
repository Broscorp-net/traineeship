package net.broscorp.equals.hashcode;

import java.util.Objects;

public class SampleClass {

  private int intProperty;

  private String strProperty;

  /**
   * Constuctor method.
   * @param intProp - some integer value
   * @param strProp - some String value
   */
  public SampleClass(int intProp, String strProp) {
    this.intProperty = intProp;
    if (strProp != null) {
      this.strProperty = strProp;
    } else {
      throw new IllegalArgumentException("strProp can not be null.");
    }
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

  @Override
  public int hashCode() {
    // TBD: in real case scenario - add check that strProperty is not null.
    // Currently handled by constructor which do not accept null arguments
    return this.strProperty.hashCode() + this.intProperty;
  }
}
