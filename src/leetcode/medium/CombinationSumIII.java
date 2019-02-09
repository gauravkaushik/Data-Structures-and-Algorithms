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
https://leetcode.com/problems/combination-sum-iii/
========================================================================

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(k > n || k < 1)
            return result;
        
        List<Integer> temp = new ArrayList<>();
        dfs(1,9,k,0,n,temp,result);
        
        return result;        
    }
    
    void dfs(int start, int N, int K, int prevSum, int target, List<Integer> temp, List<List<Integer>> res)
    {
        if(K == temp.size())
        {
            if(prevSum == target)
            {
                res.add(new ArrayList<>(temp));
            }
            else
                return;
        }
        
        for(int i=start; i<=N; i++)
        {
            temp.add(i);
            dfs(i+1, N, K, prevSum+i, target, temp, res);
            temp.remove(temp.size()-1);
        }
        
    }
    
    
}