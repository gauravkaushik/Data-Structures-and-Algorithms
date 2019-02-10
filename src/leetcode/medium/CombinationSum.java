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
https://leetcode.com/problems/combination-sum/
========================================================================

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return res;       
        
        dfs(candidates, target, 0, 0, temp, res);
        
        return res;        
    }
    
    private void dfs(int[] candidates, int target, int start, int prevSum, List<Integer> temp, List<List<Integer>> res)
    {
        if(prevSum > target)
            return;
        if(prevSum == target)
        {
            res.add(new ArrayList<>(temp));
        }
        else
        {
            for(int i=start; i<candidates.length; i++)
            {
                temp.add(candidates[i]);
                dfs(candidates, target, i, prevSum + candidates[i], temp, res);
                temp.remove(temp.size()-1);                
            }
        }
    }
}