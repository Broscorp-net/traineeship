package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Person {

  private String name;
  private int age;
  private String eyesColor;

  /**
   * Constructor parameters.
   * @param name - name of person
   * @param age - age of person
   * @param eyesColor - person's eyes color
   */
   
  public Person(String name, int age, String eyesColor) {
    this.name = name;
    this.age = age;
    this.eyesColor = eyesColor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    
    return age == person.age
      && Objects.equals(name, person.name)
      && Objects.equals(eyesColor, person.eyesColor);
  }

  @Override
  public int hashCode() {
    return 31 * age;
  }

  @Override
  public String toString() {
    return "Person{"
      + "name='"
      + name
      + '\''
      + ", age=" 
      + age
      + ", eyesColor='"
      + eyesColor
      + '\''
      + '}';
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

  public String getEyesColor() {
    return eyesColor;
  }

  public void setEyesColor(String eyesColor) {
    this.eyesColor = eyesColor;
  }
}
