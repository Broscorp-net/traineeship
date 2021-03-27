package net.broscorp.boxing.tests;


/** Summary.
 * @param <T> generalized param
 * @Depricated 9.0 a
 * @version 1.0 asd
 *  @author Roman
 */
public class MyGenetic<T> {
  private T input;
  private int wraps;

  /** Summary.
   * @param input there should be only wrapper classes
   * @throws Exception if a user used not wrapper class
   */
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

  }

  /** Summary.
   * @return just a regular getter/setter
   */
  public T getInput() {
    return input;
  }

  /** Summary.
   * @param input just a regular getter/setter
   */
  public void setInput(T input) {
    this.input = input;
  }

  /** Summary.
   * @return just a regular getter/setter
   */
  public int getWraps() {
    return wraps;
  }


  /** Summary.
   * @return just a regular getter/setter
   */
  public String getValue() {
    return this.getInput().toString();
  }


  /** Summary.
   * @param first param
   * @param second param
   * @return boolean true/false
   */
  public boolean isEqualTrue(MyGenetic<?> first, MyGenetic<?> second) {
    if (first.getWraps() == second.getWraps() && first.getValue().equals(second.getValue())) {
      return true;
    } else {
      return false;
    }

  }

  /** method isEqual returns false if params are equal.
   * @param first param
   * @param second param
   * @return boolean false/true
   */
  public boolean isEqualFalse(MyGenetic<?> first, MyGenetic<?> second) {
    if (first.getWraps() == second.getWraps() && first.getValue().equals(second.getValue())) {
      return false;
    } else {
      return true;
    }

  }

}
