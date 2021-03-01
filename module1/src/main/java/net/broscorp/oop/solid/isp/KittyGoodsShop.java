package net.broscorp.oop.solid.isp;

/**
 * ! REMOVE ME !
 *
 * Solution:
 * Do NOT separate interface.
 *
 * Explanation:
 * Fine-specified small interface.
 */

/**
 * Every shop for kitten owners should implement this interface.
 */
public interface KittyGoodsShop {

  /**
   * Sell a food to owner.
   */
  KittyFood sellFood();

  /**
   * Sell a toy to owner.
   */
  KittyToy sellToy();

  /**
   * Utilization of unused food is very important for saving the planet.
   */
  void returnFood(KittyFood food);

  /**
   * Utilization of used toy is very important for saving the planet.
   */
  void returnToy(KittyToy toy);

}

