package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Creature {

  private String type;
  private String color;
  private int legsCount;
  private String sound;
  private boolean fur;

  /**
   * Constructor for Creature.
   * @param type type of Creature
   * @param color Creature color
   * @param legsCount Creature legs count
   * @param sound Creature sound
   * @param fur Creature fur, has or hasn't
   */
  public Creature(String type, String color, int legsCount, String sound, boolean fur) {
    this.type = type;
    this.color = color;
    this.legsCount = legsCount;
    this.sound = sound;
    this.fur = fur;
  }

  @Override
  public String toString() {
    return "Animal is " + type
        + ", its color " + color
        + ", it has " + legsCount + " legs"
        + ", it makes a sound as " + sound
        + ", and it " + (fur ? "has fur" : "hasn't fur") + "<br>";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Creature animal = (Creature) o;
    return legsCount == animal.legsCount && fur == animal.fur && Objects.equals(type,
        animal.type) && Objects.equals(color, animal.color) && Objects.equals(
        sound, animal.sound);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, color, legsCount, sound, fur);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getLegsCount() {
    return legsCount;
  }

  public void setLegsCount(int legsCount) {
    this.legsCount = legsCount;
  }

  public String getSound() {
    return sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  public boolean isFur() {
    return fur;
  }

  public void setFur(boolean fur) {
    this.fur = fur;
  }
}
