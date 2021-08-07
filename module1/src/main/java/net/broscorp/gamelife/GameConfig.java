package net.broscorp.gamelife;

public class GameConfig {

  static final int[][] AROUND_SHIFTS = {
    {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
  };

  public void mainProcess(CellState[][] states) {

    int rows = states.length;
    int cols = states[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int around = countLive(i, j, states);
        if (states[i][j] == CellState.DEAD && around == 3) {
          states[i][j] = CellState.RESURRECT;
        } else if (states[i][j] == CellState.ALIVE) {
          if (around != 2 && around != 3) {
            states[i][j] = CellState.DYING;
          }
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (states[i][j] == CellState.DYING) states[i][j] = CellState.DEAD;
        if (states[i][j] == CellState.RESURRECT) states[i][j] = CellState.ALIVE;
      }
    }
  }

  private int countLive(int i, int j, CellState[][] states) {
    int count = 0;

    for (int[] dir : AROUND_SHIFTS) {
      int x = i + dir[0];
      int y = j + dir[1];

            if (x == -1) {
              x = states.length - 1;
            } else if (x == states.length) {
              x = 0;
            } else if (y == -1) {
              y = states.length - 1;
            } else if (y == states.length) {
              y = 0;
            }

      if (x >= 0 && y >= 0 && x < states.length && y < states[0].length) {

        if (states[x][y] == CellState.ALIVE || states[x][y] == CellState.DYING) {
          count++;
        }
      }
    }

    return count;
  }
}
