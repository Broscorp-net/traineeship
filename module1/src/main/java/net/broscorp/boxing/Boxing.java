package net.broscorp.boxing;

public class Boxing {
  private Integer numberOne;
  private Integer numberTwo;
  private Integer numberThree;
  private Integer numberFour;
  private Integer nulls;

  /**
  * Some javadoc. // OK
  */
  public Boxing(Integer number) {
    this.numberOne = number;
    this.numberTwo = number;
    this.numberThree = new Integer(number);
    this.numberFour = new Integer(number);
  }

  public Integer getNumberOne() {
    return numberOne;
  }

  public Integer getNumberTwo() {
    return numberTwo;
  }

  public Integer getNumberThree() {
    return numberThree;
  }

  public Integer getNumberFour() {
    return numberFour;
  }

  public Integer getNulls() {
    return nulls;
  }
}
