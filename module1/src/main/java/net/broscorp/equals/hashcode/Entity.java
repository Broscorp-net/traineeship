package net.broscorp.equals.hashcode;

public class Entity implements  EntityInterface {

  private String name;
  private String surname;
  private int age;

  public Entity(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  @Override
    public void setName(String name) {
    this.name = name;
  }

  @Override
    public String getName() {
    return name;
  }

  @Override
    public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
    public String getSurname() {
    return surname;
  }

  @Override
    public void setAge(int age) {
    this.age = age;
  }

  @Override
    public int getAge() {
    return age;
  }

  @Override
    public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (this == object) {
      return true;
    }
    if (object.getClass() != getClass()) {
      return false;
    }
    Entity entity = (Entity) object;
    return age == entity.age && name.equals(entity.name) && surname.equals(entity.surname);
  }

  public String toString() {
    return "Entity name = "
                + name
                + "\n"
                + "Entity surname ="
                + surname
                + "\n"
                + "Entity is ="
                + age
                + " years old."
                + "\n";

  }

  public int hashCode() {
    String localValue = name.concat(surname);
    int counter = 0;
    char [] chars = localValue.toCharArray();
    for (int i = 0; i < chars.length;i++) {
      char c=chars[i];
      counter += c;
    }
    counter += age;
    return counter;
  }
}
