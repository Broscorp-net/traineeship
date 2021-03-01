package net.broscorp.oop.solid.srp;

import java.util.List;

/**
 * ! REMOVE ME !
 *
 * Solution:
 * 1. Don NOT extract anything.
 * 2. Class renaming is possible. But then additional comments is required about the rename decision.
 *
 * Explanation:
 * The name of interface just distracts from the main responsibility.
 * The most of methods are for storage and only one looks like about formatting.
 * And that only method is too few for extracting it into separated class.
 * So some attention have to be paid for the mixed responsibility.
 * And if name is changed regarding the responsibility then this have to be provided
 * to reviewer via javadoc or any other method.
 */
public interface PatternStoreAndValidator {

  void add(String name);

  List<String> find(String pattern);

  boolean isNameLike(String name, String pattern);

  boolean exists(String name);

  void remove(String name);

  void replaceOldWithNew(String oldName, String newName);

}
