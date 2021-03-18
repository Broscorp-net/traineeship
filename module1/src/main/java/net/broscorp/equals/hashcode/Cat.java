package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Cat {
  private String name;
  private int age;
  private int weight;

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
