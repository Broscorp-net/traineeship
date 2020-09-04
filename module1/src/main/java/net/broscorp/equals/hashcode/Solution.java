package net.broscorp.equals.hashcode;

public class Solution {
  private int firstValue;
  private int secondValue;

  public Solution() {

  }

  public Solution(int firstValue, int secondValue) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
  }

  public int getFirstValue() {
    return firstValue;
  }

  public void setFirstValue(int firstValue) {
    this.firstValue = firstValue;
  }

  public int getSecondValue() {
    return secondValue;
  }

  public void setSecondValue(int secondValue) {
    this.secondValue = secondValue;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    return prime * firstValue + prime * secondValue;
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
    Solution other = (Solution) obj;

    return firstValue == other.firstValue && secondValue == other.secondValue;
  }

  @Override
  public String toString() {
    return "Solution [firstValue=" + firstValue + ", secondValue=" + secondValue + "]";
  }
}
