package net.broscorp.equals.hashcode;


public class Player {

  private int id;
  private String nickname;
  private String rank;

  /**.
   * Test Object
   */
  public Player(int id, String nickname, String rank) {
    this.id = id;
    this.nickname = nickname;
    this.rank = rank;
  }

  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return id == player.id;
  }

  @Override
    public int hashCode() {
    return id % 10;
  }

  @Override
    public String toString() {
    return "Player{"
            + "id=" + id
            + ", nickname='" + nickname + '\''
            + ", rank='" + rank + '\''
            + '}';
  }
}
