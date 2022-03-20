package net.broscorp.equals.hashcode;

public class EqualsHashCode {
  private int anInt;
  private String string;
  private Integer integer;

  public EqualsHashCode() {}

  /**
   * Some custom class for testing equals and hashCode methods.
   * @param anInt - some int param.
   * @param string - some string param.
   * @param integer - some wrapper param.
   */
  public EqualsHashCode(int anInt, String string, Integer integer) {
    this.anInt = anInt;
    this.string = string;
    this.integer = integer;
  }

  public int getAnInt() {
    return anInt;
  }

  public String getString() {
    return string;
  }

  public Integer getInteger() {
    return integer;
  }

  public void setAnInt(int anInt) {
    this.anInt = anInt;
  }

  public void setString(String string) {
    this.string = string;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EqualsHashCode that = (EqualsHashCode) o;
    return anInt == that.anInt && string.equals(that.string) && integer.equals(that.integer);
  }

  @Override
  public int hashCode() {
    int hash = 17;

    hash = 31 * hash + anInt;
    hash = 31 * hash + string.hashCode();
    hash = 31 * hash + integer.hashCode();

    return hash;
  }

  @Override
  public String toString() {
    return "i = "
        + anInt
        + "\n"
        + "string = "
        + string
        + "\n"
        + "wrapper = "
        + integer.toString()
        + "\n";
  }
}
