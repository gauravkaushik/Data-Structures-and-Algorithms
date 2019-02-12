package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/permutations-ii/
========================================================================

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();        
        
        boolean[] visited = new boolean[nums.length];
        
        List<Integer> temp = new ArrayList<>();
        
        Arrays.sort(nums);
        dfs(nums, visited, temp, res);
        
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res)
    {
        if(temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        long prev = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            if(prev!=nums[i] && visited[i] == false)
            {
                visited[i] = true;
                temp.add(nums[i]);
                
                dfs(nums, visited, temp, res);
                
                temp.remove(temp.size()-1);
                visited[i] = false;
                prev = (long)nums[i];
            }
            
        }
    }
}