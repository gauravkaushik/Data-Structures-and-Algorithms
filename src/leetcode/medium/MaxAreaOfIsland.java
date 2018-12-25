package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/max-area-of-island/
=========================================================================
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 */

public class MaxAreaOfIsland {
    
    int area = 0;
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        //do dfs from top left node of each island
        //count the number of nodes visited on this island
        //return the max count considering all islands 
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                {
                    area = 0;
                    dfs(i, j, rows, cols, grid, visited);
                }
            }
        }
        
        return maxArea;        
    }
    
    void dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited)
    {
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0 || visited[i][j])
            return;
        visited[i][j] = true;
        area = area + 1;
        maxArea = Math.max(area,maxArea);
        
        dfs(i-1,j,rows,cols,grid,visited);
        dfs(i+1,j,rows,cols,grid,visited);
        dfs(i,j-1,rows,cols,grid,visited);
        dfs(i,j+1,rows,cols,grid,visited);
    }
}