package net.broscorp.gamelife;

public class GameConfig {

  public void mainProcess(CellState[][] states) {
    CellState resurrect = CellState.RESURRECT;
    CellState dying = CellState.DYING;
    CellState alive = CellState.ALIVE;
    CellState dead = CellState.DEAD;

    //        private int die = 2;
    //        private int live = 3;

    // we only flip the 1 to die and 0 to live
    // so when we find a die around, it must be a previous 1
    // then we can count the 1s without being affected
    int rows = states.length;
    int cols = states[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int around = countLive(i, j, states);
        if (states[i][j] == dead && around == 3) {
          states[i][j] = resurrect;
        } else if (states[i][j] == alive) {
          if (around == 2 || around == 3) {
            continue;
          }
          if (around < 2 || around > 3) {
            states[i][j] = dying;
          }
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (states[i][j] == dying) states[i][j] = dead;
        if (states[i][j] == resurrect) states[i][j] = alive;
      }
    }
  }
}
