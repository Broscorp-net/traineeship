package net.broscorp.equals.hashcode;

public class Player {

  public int id;
  public String name;
  public int age;
  public double height;

  public Player(int id, String name, int age, double height){
    this.id = id;
    this.name = name;
    this.age = age;
    this.height = height;
  }

  @Override
  public String toString() {
    return "Player{" +
        "id=" + id +
        ", name='" + name +
        ", age=" + age +
        ", height=" + height +
        '}';
  }

  @Override
  public boolean equals(Object object) {
//    is referring to the same object
    if (this == object) {
      return true;
    }

    if (!(object instanceof Player)) {
      return false;
    }

    Player player = (Player) object;
    if (id != player.id) {
      return false;
    }
    if (age != player.age) {
      return false;
    }
    if (Double.compare(player.height, height) != 0) {
      return false;
    }
    return name.equals(player.name);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = name.hashCode();
    result = 31 * result + age;
    temp = Double.doubleToLongBits(height);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + id;
//    31 simple number that need to groping range of hash value
    return result;
  }
}
