package net.broscorp.equals.hashcode;

import java.util.Objects;

/**
 * class Cat.
 * @author Nikita
 *
 * @version 1.0
 */
public class Cat {
  private int id;
  private int age;
  private String name;

  /**
   * Constructor parameters.
   * @param id - cat's id
   * @param age - cat's age
   * @param name - cat's name
   */
  public Cat(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * overridden method Object.toString().
   *
   * @return string with data
   */
  @Override
  public String toString() {
    return "Cat{"
            + "id=" + id
            + ", age=" + age
            + ", name='" + name + '\''
            + '}';
  }

  /**
   * overridden method Object.equals().
   *
   * @param o - class instance.
   * @return true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cat cat = (Cat) o;
    return id == cat.id
            && age == cat.age
            && Objects.equals(name, cat.name);
  }

  /**
   * overridden method Object.hashCode().
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, age, name);
  }
}
