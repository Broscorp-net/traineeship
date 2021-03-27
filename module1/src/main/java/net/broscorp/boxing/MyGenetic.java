package net.broscorp.boxing.tests;

public class MyGenetic<T> {

  private T input;
  private int wraps;


  public T getInput() {
    return input;
  }

  public void setInput(T input) {
    this.input = input;
  }

  public int getWraps() {
    return wraps;
  }

  //| Short| Integer,Long, Float, Double,  Boolean, Character
  public String getValue() {
    return this.getInput().toString();
  }

  public MyGenetic(T input) throws Exception {
    this.input = input;

    if (input.getClass().equals(Byte.class)) {
      this.wraps = 0;
    } else if (input.getClass().equals(Short.class)) {
      this.wraps = 1;
    } else if (input.getClass().equals(Integer.class)) {
      this.wraps = 2;
    } else if (input.getClass().equals(Long.class)) {
      this.wraps = 3;
    } else if (input.getClass().equals(Float.class)) {
      this.wraps = 4;
    } else if (input.getClass().equals(Double.class)) {
      this.wraps = 5;
    } else if (input.getClass().equals(Boolean.class)) {
      this.wraps = 6;
    } else if (input.getClass().equals(Character.class)) {
      this.wraps = 7;
    } else {

      throw new Exception();
    }

//| Short| Integer,Long, Float, Double,  Boolean, Character

  }



    /*public boolean isEqual(T first, T second)
    {

        return first.
    }*/

  public boolean isEqualTrue(MyGenetic<?> first, MyGenetic<?> second) {
    if (first.getWraps() == second.getWraps() && first.getValue().equals(second.getValue())) {
      return true;
    } else {
      return false;
    }

  }

  public boolean isEqualFalse(MyGenetic<?> first, MyGenetic<?> second) {
    if (first.getWraps() == second.getWraps() && first.getValue().equals(second.getValue())) {
      return false;
    } else {
      return true;
    }

  }

}
