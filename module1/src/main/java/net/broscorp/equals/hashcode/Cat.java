package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Cat {
  private String name;
  private int age;
  private int weight;


  public Cat() {
  }

  /**
   * Constructor with parameters name, age, weight.
   * @param name cat's name
   * @param age cat's age
   * @param weight cat's wieght
   */
  public Cat(String name, int age, int weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cat)) {
      return false;
    }
    Cat cat = (Cat) o;
    return age == cat.age && weight == cat.weight && Objects.equals(name, cat.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, weight);
  }

  @Override
  public String toString() {
    return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
  }
}
