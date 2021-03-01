package net.broscorp.oop.solid.isp;

/**
 * ! REMOVE ME !
 *
 * Solution:
 * Separate interface into HumanActions and KittyActions.
 *
 * Explanation:
 * Hints about that are placed in the javadocs for each method.
 * Jokes are also there. We need to add as much jokes as we can. Because this is a stress test for trainee abdominals.
 */

/**
 * You and your kitty should use this interface to be together.
 */
public interface Actions {

    /**
     * Buy a food to feed the kitten later.
     */
    void buy(KittyFood food);

    /**
     * Buy a toy to give it to the kitty later.
     */
    void buy(KittyToy toy);

    /**
     * Food adds a much of pleasure and health to the kitty.
     */
    void eat(KittyFood food);

    /**
     * Every kitty could try to eat the toy.
     */
    void eat(KittyToy toy);

    /**
     * Give that food to kitty! Immediately!
     * Meow!!!
     */
    void give(KittyFood toy);

    /**
     * Give a toy to the kitty. Did you bought it or find somewhere - it doesn't matter.
     */
    void give(KittyToy toy);

    /**
     * A kitten could hide the rest of food if it is unsure whether you will or will not feed it.
     */
    void hide(KittyFood toy);

    /**
     * Fluid food is hard to bite off. Kittens often lick it.
     */
    void lick(KittyFood toy);

    /**
     * Toys were not developed to be licked by anyone. But do not say that to your kitty.
     * This is its methods, not yours.
     * Also, as you could see, we do not provide a method to say something to your kitten.
     * Public talk with cats could damage your reputation.
     */
    void lick(KittyToy toy);

    /**
     * A game is one of the main things every kitty lives for. And sleeps for it too.
     */
    void play(KittyToy toy);

    /**
     * Do you know whether the food is good? Also, does your kitty know that?
     * For now you and your kitten could use this method. You could sniff even simultaneously!
     */
    void sniff(KittyFood food);

    /**
     * This method gives no profit to you. Only kittens should use it.
     */
    void sniff(KittyToy toy);

}

