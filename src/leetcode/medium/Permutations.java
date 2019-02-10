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
https://leetcode.com/problems/permutations/
========================================================================

Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        boolean[] visited = new boolean[nums.length];
        
        List<Integer> temp = new ArrayList<>();
        
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
        
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                temp.add(nums[i]);
                
                dfs(nums, visited, temp, res);
                
                temp.remove(temp.size()-1);
                visited[i] = false;    
            }
            
        }
    }
}

/* Alternative Approach : witout using extra space from : https://www.programcreek.com/2013/02/leetcode-permutations-java/ 
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(0, nums, result);
    return result;
}
 
private void helper(int start, int[] nums, List<List<Integer>> result){
    if(start==nums.length-1){
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        result.add(list);
        return;
    }
 
    for(int i=start; i<nums.length; i++){
        swap(nums, i, start);
        helper(start+1, nums, result);
        swap(nums, i, start);
    }
}
 
private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

*/