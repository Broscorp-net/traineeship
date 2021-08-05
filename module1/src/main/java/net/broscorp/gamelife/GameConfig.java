package net.broscorp.gamelife;

public class GameConfig {

  CellState resurrect = CellState.RESURRECT;
  CellState dying = CellState.DYING;
  CellState alive = CellState.ALIVE;
  CellState dead = CellState.DEAD;

  public void mainProcess(CellState[][] states) {

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

  private int countLive(int i, int j, CellState[][] states) {
    int count = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];

      if(x == -1){
        x = states.length + x;
      }else if(x == states.length){
        x = 0;
      }else if(y == -1){
        y = states.length + y;
      }else if(y == states.length){
        y = 0;
      }

      if (x < states.length && y < states[0].length) {

        if (states[x][y] == alive || states[x][y] == dying) count++;
      }
    }

    return count;
  }
}
