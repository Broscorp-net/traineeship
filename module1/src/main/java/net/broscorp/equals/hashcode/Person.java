package net.broscorp.equals.hashcode;

public class Person implements Cloneable {
  private String name;
  private int age;
  private String inn;

  /**
   * Creates a person with the specified characteristics.
   * @param name a String containing the name of the person
   * @param age a int specifying the current person age
   * @param inn a String containing the id number of the person
   */

  public Person(String name, int age, String inn) {
    this.name = name;
    this.age = age;
    this.inn = inn;
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

  public String getInn() {
    return inn;
  }

  public void setInn(String inn) {
    this.inn = inn;
  }

  @Override
  public String toString() {
    return "Person name: " + this.name + ", age: " + this.age + ", inn: "
        + this.inn;
  }

  @Override
  public boolean equals(Object person) {
    if (person == this) {
      return true;
    }

    if (person == null) {
      return false;
    }

    if (person.getClass().equals(Person.class)) {
      Person currentPerson = (Person) person;
      return this.name.equals(currentPerson.name)
          && this.age == currentPerson.age
          && this.inn.equals(currentPerson.inn);
    }

    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + age;
    result = 31 * result + (inn == null ? 0 : inn.hashCode());
    return result;
  }
}
