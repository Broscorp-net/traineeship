package net.broscorp.equals.hashcode;

public class Cat {
  
  private int age;
  private int id;
  private String name;
  
  /**
   * Some text here.
   */
  public Cat(int id, String name, int age) {
    this.age = age;
    this.id = id;
    this.name = name;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Cat age=" + age + ", id=" + id + ", name=" + name;
  }

  @Override
  public int hashCode() {
    return id * 4;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Cat other = (Cat) obj;
    if (age != other.age) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }
  
  
  
  
}
