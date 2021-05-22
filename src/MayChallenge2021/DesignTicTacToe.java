package MayChallenge2021;

// @author : Gaurav Kaushik
// Leetcode : https://leetcode.com/kaushikgaurav08/
// LinkedIn : https://www.linkedin.com/in/gvk28/
// GitHub : https://github.com/gauravkaushik
// ProblemLink : https://leetcode.com/problems/design-tic-tac-toe/
class TicTacToe {

  int[][] rowAry;
  int[][] colAry;
  int[][] diagAry;
  int n;

  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    rowAry = new int[n][2];
    colAry = new int[n][2];
    diagAry = new int[2][2];
    this.n = n;
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row The row of the board.
   * @param col The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2:
   *     Player 2 wins.
   */
  public int move(int row, int col, int player) {
    rowAry[row][player - 1]++;
    colAry[col][player - 1]++;
    if (row == col) {
      diagAry[0][player - 1]++;
    }
    if (row + col == n - 1) {
      diagAry[1][player - 1]++;
    }
    if (rowAry[row][player - 1] == n
        || colAry[col][player - 1] == n
        || diagAry[0][player - 1] == n
        || diagAry[1][player - 1] == n) {
      return player;
    }
    return 0;
  }
}

/**
 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
