package net.broscorp.oop.solid.srp;

import java.util.List;

/**
 * ! REMOVE ME !
 *
 * Solution:
 * replace this interface with next couple:
 * interface NameStore
 *     add()
 *     find()
 *     remove()
 *
 * interface NameFormatter
 *     format()
 *     isNameLike()
 *     isPatternValid()
 *
 * Explanation:
 * We have proportional number of methods for storage and formatter.
 * Also, the name of interface is a hint about mixed responsibility.
 */
public interface NameStoreAndFormatter {

  void add(String name);

  List<String> find(String pattern);

  String format(String name, String pattern);

  void remove(String name);

  boolean isNameLike(String name, String pattern);

  boolean isPatternValid(String pattern);

}
