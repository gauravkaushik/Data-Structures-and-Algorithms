package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/jump-game/
========================================================================

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
             
*/

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length==0)
            return true;
        
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[N-1] = true;
        
        lo:
        for(int i=N-2; i>=0; i--)
        {            
            for(int k=1; k<=nums[i]; k++)
            {
                if(i+k<N && dp[i+k])
                {
                    dp[i] = true;
                    continue lo;
                }
            }
        }
        
        return dp[0];
    }
}

/**
A highly efficient greedy approach O(N) time and O(1) space : reference : https://leetcode.com/problems/jump-game/solution/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length==0)
            return true;
        
        int N = nums.length;        
        int leftMostGoodPosition = N-1;        
        
        for(int i=N-2; i>=0; i--)
        {            
            if(i + nums[i] >= leftMostGoodPosition)
            {
                leftMostGoodPosition = i;                
            }
        }
        
        return leftMostGoodPosition==0;
    }
}

*/