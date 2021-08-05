package net.broscorp.gamelife;


enum CellState {
    ALIVE("X"),
    DEAD("O"),
    RESURRECT("R"),
    DYING("D");


    private final String value;

    CellState(String value) {
        this.value = value;
    }

    public static CellState from(String value) {
        for (CellState e : values()) {
            if (e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("CellState with given value is not exist: " + value);
    }
}
