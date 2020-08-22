package net.broscorp.equals.hashcode;

import java.util.Objects;

public class MyClass {
  private int number;
  private String name;
  private int value;

  /**
   * Constructor of Entity.
   * @param number number
   * @param name name
   * @param value value
   */
  public MyClass(int number, String name, int value) {
    this.number = number;
    this.name = name;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MyClass myClass = (MyClass) o;
    return number == myClass.number
        && value == myClass.value
        && Objects.equals(name, myClass.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 29 * result + number;
    result = 29 * result + value;
    return result;
  }

  @Override
  public String toString() {
    return "MyClass{"
           + "number=" + number + ", name='" + name + '\''
           + ", value=" + value + '}';
  }
}
