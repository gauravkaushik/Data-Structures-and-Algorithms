package MayChallenge2021.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @author : Gaurav Kaushik
// Leetcode : https://leetcode.com/kaushikgaurav08/
// LinkedIn : https://www.linkedin.com/in/gvk28/
// GitHub : https://github.com/gauravkaushik
// ProblemLink : https://leetcode.com/problems/n-queens/

class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();

    boolean[] vis = new boolean[n];
    int[] rowToQueenPosMp = new int[n];
    Arrays.fill(rowToQueenPosMp, -1);

    dfs(0, vis, rowToQueenPosMp, result);

    return result;
  }

  List<String> transform(int[] rowToQueenPosMp) {
    List<String> result = new ArrayList<>();
    StringBuilder sbr = new StringBuilder();
    for (int row = 0; row < rowToQueenPosMp.length; row++) {
      sbr.setLength(0);
      for (int col = 0; col < rowToQueenPosMp.length; col++) {
        sbr.append(rowToQueenPosMp[row] == col ? 'Q' : '.');
      }
      result.add(sbr.toString());
    }
    return result;
  }

  boolean isColliding(int i, int j, int[] rowToQueenPosMp) {
    for (int row = 0; row < i; row++) {
      int col = rowToQueenPosMp[row];
      // same col or same diag or same anti-diag
      if (j == col || i + j == row + col || i - j == row - col) {
        return true;
      }
    }
    return false;
  }

  void dfs(int row, boolean[] vis, int[] rowToQueenPosMp, List<List<String>> result) {
    if (row == vis.length) {
      result.add(transform(rowToQueenPosMp));
      return;
    }
    for (int col = 0; col < vis.length; col++) {
      if (isColliding(row, col, rowToQueenPosMp)) {
        continue;
      } else {
        // System.out.println("Placing queen in row " + row + " and col " + col);
        vis[col] = true;
        rowToQueenPosMp[row] = col;
        dfs(row + 1, vis, rowToQueenPosMp, result);
        rowToQueenPosMp[row] = -1;
        vis[col] = false;
      }
    }
  }
}
