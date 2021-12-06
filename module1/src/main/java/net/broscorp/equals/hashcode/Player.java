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

  public static void main(String[] args){

    Player firstPlayer = new Player(101, "Hash", 23, 189);
    Player secondPlayer = new Player(101, "Hash", 23, 189);

    boolean isPlayersEquals = firstPlayer == secondPlayer;
    System.out.println("isPlayersEquals = " + isPlayersEquals);
    boolean isPlayersEqualsMethod = firstPlayer.equals(secondPlayer);
    System.out.println("isPlayersEqualsMethod = " + isPlayersEqualsMethod);
    System.out.println("hash code first player = " + firstPlayer.hashCode() + " & second player - " + secondPlayer.hashCode());
    boolean isPlayersHashCode = firstPlayer.hashCode() == secondPlayer.hashCode();
    System.out.println("isPlayersHashCode = " + isPlayersHashCode);

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
