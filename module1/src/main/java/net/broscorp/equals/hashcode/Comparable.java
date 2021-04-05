package net.broscorp.equals.hashcode;

import java.time.LocalTime;
import java.util.Objects;

public class Comparable {

  private String string;
  private int integer;
  private boolean bool;
  private char character;

  public Comparable() {
  }

  /**
   * Constructor with all parameters.
   *
   * @param string    used as string value
   * @param integer   used as integer value
   * @param bool      used as boolean value
   * @param character used as character value
   */

  public Comparable(String string, int integer, boolean bool, char character) {
    this.string = string;
    this.integer = integer;
    this.bool = bool;
    this.character = character;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public int getInteger() {
    return integer;
  }

  public void setInteger(int integer) {
    this.integer = integer;
  }

  public boolean isBool() {
    return bool;
  }

  public void setBool(boolean bool) {
    this.bool = bool;
  }

  public char getCharacter() {
    return character;
  }

  public void setCharacter(char character) {
    this.character = character;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + character;
    result = prime * result + integer;
    result = prime * result + string.length();
    return result;
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
    Comparable other = (Comparable) obj;
    if (bool != other.bool) {
      return false;
    }
    if (character != other.character) {
      return false;
    }
    if (integer != other.integer) {
      return false;
    }
    if (string == null) {
      if (other.string != null) {
        return false;
      }
    } else if (!string.equals(other.string)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Comparable{"
        + "string='" + string + '\''
        + ", integer=" + integer
        + ", bool=" + bool
        + ", character=" + character
        + '}';
  }

}
