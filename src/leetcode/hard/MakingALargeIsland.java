package leetcode.hard;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/making-a-large-island/
=========================================================================
In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: [[1, 1], [1, 1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Notes:

1 <= grid.length = grid[0].length <= 50.
0 <= grid[i][j] <= 1.
 */

public class MakingALargeIsland {
    
    public int largestIsland(int[][] grid) {
        
        //MAX : max area among all islands
        //find next 0 which is surrounded by 1 on atleast one of its 4 directions (Up,Down,Left,Right)
        //flip it to 1 and find max area among all islands
        //continue until no such 0 left 
        //return max area        
        // if(grid==null || grid.length==0)
        //     return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;    
        boolean hasZero = false;
        int maxArea = 0;
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j]==0)
                {         
                    hasZero = true;
                    grid[i][j] = 1;
                    maxArea = Math.max(maxArea, dfs(grid,i,j,new boolean[rows][cols],rows,cols));                    
                    if(maxArea==rows*cols)
                        return maxArea;
                    grid[i][j] = 0;
                    
                }
            }
        }       
        
        return hasZero?maxArea:rows*cols;
        
    }
    
    
    
    int dfs(int[][] grid, int i, int j, boolean[][] visited, int rows, int cols)
    {
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || grid[i][j]==0)
            return 0;
        visited[i][j]=true;
                
        return 1 + dfs(grid,i-1,j,visited,rows,cols)+ dfs(grid,i+1,j,visited,rows,cols) + dfs(grid,i,j-1,visited,rows,cols) + dfs(grid,i,j+1,visited,rows,cols);
    }
}