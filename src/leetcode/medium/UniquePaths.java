package leetcode.medium;

import java.util.Arrays;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/unique-paths/
========================================================================

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28


*/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        
        int[] prev = new int[n];
        int[] next = new int[n];
        
        Arrays.fill(prev,1);
        
        for(int i=1; i<m; i++)
        {
            next[n-1] = prev[n-1];
            for(int j=n-2; j>=0; j--)
            {
                next[j] = next[j+1] + prev[j];
            }
            //copy next to prev
            for(int j=0; j<n; j++)
                prev[j] = next[j];
        }
        
        return next[0];
    }
}