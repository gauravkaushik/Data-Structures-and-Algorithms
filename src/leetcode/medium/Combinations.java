package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/combinations/
========================================================================

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
        if(k<0 || k>n)
            return res;
		List<Integer> comb = new ArrayList<>();

		dfs(0, 0, n, k, comb, res);

		return res;
	}

	void dfs(int level, int start, int n, int k, List<Integer> comb, List<List<Integer>> res) {

		if (start > 0)
			comb.add(start);
		if (level < k) {
			for (int i = start + 1; i <= n; i++) {
				dfs(level + 1, i, n, k, comb, res);
			}
		} else if (level == k) {
			res.add(new ArrayList<>(comb));
			//print(comb);
		}

		if (start > 0)
			comb.remove(comb.size() - 1);
	}
	
}