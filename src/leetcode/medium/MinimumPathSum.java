package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/minimum-path-sum/
========================================================================

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1 -> 3 -> 1 -> 1 -> 1 minimizes the sum.

*/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if( grid==null || grid.length==0 ||  grid[0].length==0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        //System.out.println("m,n : " +m+", "+n);
        
        int[] dp = new int[n];
        
        int sum=0;
        //first row, fill running sum from left to right
        for(int col=0; col<n; col++)
        {
            //System.out.println("col : "+col);
            sum += grid[0][col];
            dp[col] = sum;
        }
        
        //for other rows : 
        //take value from top for first column
        //take minimum of left and top for other columns
        for(int i=1; i<m; i++)
        {
            int[] row = grid[i];
            for(int j=0; j<n; j++)
            {
                if(j==0)
                    dp[j] += row[j];
                else
                {
                    dp[j] = row[j] + Math.min(dp[j],dp[j-1]);
                }
            }
        }
        
        return dp[n-1];
        
    }
}