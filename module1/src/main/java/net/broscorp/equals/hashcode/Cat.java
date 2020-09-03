package net.broscorp.equals.hashcode;

public class Cat {

  String name;
  String breed;
  int age;

  /** Constructor of the Cat class.
   *
   * @param name  of the Cat (not NULL)
   * @param breed of the Cat (not NULL)
   * @param age   How many years does he live
   */
  public Cat(String name, String breed, int age) {
    this.name = name;
    this.breed = breed;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Animal{"
        + "name='" + name + '\''
        + ", breed='" + breed + '\''
        + ", age=" + age
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cat cat = (Cat) o;
    return age == cat.age
        && name.equals(cat.name)
        && breed.equals(cat.breed);
  }

  @Override
  public int hashCode() {
    char name = this.name.charAt(0);
    char breed = this.breed.charAt(0);
    return (int) name * (int) breed;
  }
}
