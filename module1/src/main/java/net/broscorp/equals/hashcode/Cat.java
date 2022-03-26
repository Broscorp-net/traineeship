package net.broscorp.equals.hashcode;

public class Cat {

  private String name;
  private String breed;
  private int age;
  private int weight;

  public Cat() {
  }

  /**
   *  Cat Constructor method.
   * @param name name of the cat
   * @param breed breed of the cat for example - British Shorthaired
   * @param age age of the cat in years
   * @param weight weight of the cat in kilos
   */
  public Cat(String name, String breed, int age, int weight) {
    this.name = name;
    this.breed = breed;
    this.age = age;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
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
  public String toString() {
    return "Cat{"
        +
        "name='" + name + '\''
        +
        ", breed='" + breed + '\''
        +
        ", age=" + age
        +
        ", weight=" + weight
        +
        '}';
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

    if (age != cat.age) {
      return false;
    }
    if (weight != cat.weight) {
      return false;
    }
    if (name != null ? !name.equals(cat.name) : cat.name != null) {
      return false;
    }
    return breed != null ? breed.equals(cat.breed) : cat.breed == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (breed != null ? breed.hashCode() : 0);
    result = 31 * result + age;
    result = 31 * result + weight;
    return result;
  }

}
