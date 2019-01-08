package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/unique-paths-ii/
========================================================================

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {        
        
        /*first fill the bottom row and right-most column with 1.. 
        but keep in mind that if it is blocked (1), make it -1 and then mark all remaining with -1
        */
        //now traverse matrix from bottom-up, right-left fashion and update each cell if its right and down are non-negative; mark it as blocked if both neighbors are blocked
        
        if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        //source or destination itself is blocked
        if ( obstacleGrid[0][0] == 1  || obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        obstacleGrid[m-1][n-1] = 1;
        
        boolean isBlocked = false;
        int col;
        for(col = n-2; col >=0 ; col--)
        {
            if(obstacleGrid[m-1][col] == 1)
            {
                isBlocked = true;
                break;
            }
            obstacleGrid[m-1][col] = 1;
        }
        if(isBlocked)
        {
            for(;col>=0;col--)
                obstacleGrid[m-1][col] = -1;
        }
        
        isBlocked = false;
        int row;
        for(row = m-2; row>=0; row--)
        {
            if(obstacleGrid[row][n-1] == 1)
            {
                isBlocked = true;
                break;
            }
            obstacleGrid[row][n-1] = 1;
        }
        if(isBlocked)
        {
            for(;row>=0;row--)
                obstacleGrid[row][n-1] = -1;
        }
            
        int bottom, right;
        for(row = m-2; row>=0; row--)
        {
            for(col = n-2; col>=0; col--)
            {
                if(obstacleGrid[row][col]==1)
                {
                    obstacleGrid[row][col] = -1;
                }
                else
                {
                    bottom = obstacleGrid[row+1][col];
                    right = obstacleGrid[row][col+1];

                    bottom = (bottom==-1?0:bottom);
                    right = (right==-1?0:right);

                    obstacleGrid[row][col] = bottom + right;
                    if(obstacleGrid[row][col]==0)
                        obstacleGrid[row][col] = -1;                                   
                }
                
            }
        }
        
        
        return ( obstacleGrid[0][0]==-1 ? 0 : obstacleGrid[0][0] );
            
    }
    
    /* Concise solution from leetcode discussion section :
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
    */
}