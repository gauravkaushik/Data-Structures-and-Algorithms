package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/combination-sum-ii/
========================================================================

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
           
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<candidates.length; i++)
        {
            mp.put( candidates[i],  mp.getOrDefault( candidates[i], 0 ) + 1);
        }
        
        Set<Integer> set = mp.keySet();
        int[] uniqueNums = new int[set.size()];
        int i=0;
        for(int x : set)
            uniqueNums[i++] = x;
        
        List<Integer> temp = new ArrayList<>();
                
        dfs(uniqueNums, target, 0, 0, temp, res, mp);
        
        return res;
        
    }
    
    private void dfs(int[] uniqueNums, int target, int start, int prevSum, List<Integer> temp, List<List<Integer>> res, Map<Integer,Integer> mp)
    {        
        if (prevSum > target)
            return;       
        
        if(prevSum == target)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=start; i<uniqueNums.length; i++)
        {
            int j = uniqueNums[i];
            if( mp.get(j) == 0 )
                continue;
            
            temp.add(j);
            prevSum += j;
            mp.put(j, mp.get(j) - 1);            
            
            dfs(uniqueNums, target, i, prevSum, temp, res, mp);
            
            mp.put(j, mp.get(j) + 1);
            prevSum -= j;
            temp.remove(temp.size()-1);
            
        }
    }
}

/* An alternative approach that builds up on the previous problem CombinationSum from : https://www.programcreek.com/2014/04/leetcode-combination-sum-ii-java/

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> curr = new ArrayList<Integer>();
    Arrays.sort(candidates);
    helper(result, curr, 0, target, candidates);
    return result;
}
 
public void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
    if(target==0){
        result.add(new ArrayList<Integer>(curr));
        return;
    }
    if(target<0){
        return;
    }
 
    int prev=-1;
    for(int i=start; i<candidates.length; i++){
        if(prev!=candidates[i]){ // each time start from different element
            curr.add(candidates[i]);
            helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
            curr.remove(curr.size()-1);
            prev=candidates[i];
        }
    }
}

*/