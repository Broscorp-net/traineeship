package net.broscorp.equals.hashcode;

import java.util.Objects;

public class MyObject {

  private String name;
  private int id;
  private int number;

  /**{ @summary This is summary.}
   * @param name string.
   * @param id int.
   */
  public MyObject(String name, int id) {
    this.name = name;
    this.id = id;
    number = rnd();
  }

  /**{ @summary This is summary.}
   * @param name string.
   * @param id int.
   * @param number int.
   */
  public MyObject(String name, int id, int number) {
    this.name = name;
    this.id = id;
    this.number = number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setId(int id) {
    this.id = id;
  }

  private static int rnd() {
    return (int) (Math.random() * 100);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyObject myObject = (MyObject) o;
    return id == myObject.id && number == myObject.number && Objects.equals(name,
        myObject.name);
  }

  @Override
  public int hashCode() {
    return number;
  }

  @Override
  public String toString() {
    return getClass().getName() + name + '@' + hashCode();
  }
}
