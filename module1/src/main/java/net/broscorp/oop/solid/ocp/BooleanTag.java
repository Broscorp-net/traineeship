package net.broscorp.oop.solid.ocp;

public class BooleanTag extends SortableTag {
    public static final BooleanTag TRUE = new BooleanTag("true");
    public static final BooleanTag FALSE = new BooleanTag("false");

    private BooleanTag(String word) {
        super(word);
    }

}
