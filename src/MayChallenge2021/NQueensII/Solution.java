package MayChallenge2021.NQueensII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// @author : Gaurav Kaushik
// Leetcode : https://leetcode.com/kaushikgaurav08/
// LinkedIn : https://www.linkedin.com/in/gvk28/
// GitHub : https://github.com/gauravkaushik
// ProblemLink : https://leetcode.com/problems/n-queens-ii/

class Solution {
  public int totalNQueens(int n) {
    Set<String> solutions = new HashSet<>();
    int[] rowToQueenPosMp = new int[n];
    Arrays.fill(rowToQueenPosMp, -1);

    boolean[] visCol = new boolean[n];
    Set<Integer> diagDiff = new HashSet<>();
    Set<Integer> antiDiagSum = new HashSet<>();

    dfs(0, visCol, diagDiff, antiDiagSum, rowToQueenPosMp, solutions);

    return solutions.size();
  }

  void addSolutionToMp(int[] rowToQueenPosMp, Set<String> solutions) {
    StringBuilder sbr = new StringBuilder();
    for (int row = 0; row < rowToQueenPosMp.length; row++) {
      sbr.append(row);
      sbr.append("->");
      sbr.append(rowToQueenPosMp[row]);
      sbr.append(",");
    }
    solutions.add(sbr.toString());
  }

  void dfs(
      int row,
      boolean[] visCol,
      Set<Integer> diagDiff,
      Set<Integer> antiDiagSum,
      int[] rowToQueenPosMp,
      Set<String> solutions) {
    int N = rowToQueenPosMp.length;
    if (row == N) {
      // all queens have been placed
      addSolutionToMp(rowToQueenPosMp, solutions);
      return;
    }
    for (int col = 0; col < N; col++) {
      if (visCol[col] || diagDiff.contains(row - col) || antiDiagSum.contains(row + col)) {
        continue;
      } else {
        visCol[col] = true;
        diagDiff.add(row - col);
        antiDiagSum.add(row + col);
        rowToQueenPosMp[row] = col;
        dfs(row + 1, visCol, diagDiff, antiDiagSum, rowToQueenPosMp, solutions);
        visCol[col] = false;
        diagDiff.remove(row - col);
        antiDiagSum.remove(row + col);
        rowToQueenPosMp[row] = -1;
      }
    }
  }
}
