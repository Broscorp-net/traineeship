package net.broscorp.oop.solid.srp;

/**
 * ! REMOVE ME !
 *
 * <p>Solution:
 * Rename the class.
 *
 * <p>Explanation:
 * This class contains a set of methods with well-understandable responsibility.
 * And the only thing - that responsibility is not represented in the name of the class.
 * Also, the name is ugly. So the only requirement is to prettify the name.
 */
public interface AdderAndSubtractor {

  long add(long x, long y);

  long add(long x, long y, long z);

  long add(long... values);

  long subtract(long x, long y);

  long multiply(long x, long y);

  long multiply(long x, long y, long z);

  long multiply(long... values);

  long power(long x, long y);

}
