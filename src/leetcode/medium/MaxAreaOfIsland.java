package leetcode.medium;

import java.util.Arrays;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        
        //do dfs from top left node of each island
        //count the number of nodes visited on this island
        //return the max count considering all islands 
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[rows][cols];
        boolean[][] visited_temp = new boolean[rows][cols];        
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                {                    
                    maxArea = Math.max(maxArea, findArea(i, j, rows, cols, grid, visited, visited_temp));
                    visited[i][j] = true;
                }
            }
        }
        
        return maxArea==Integer.MIN_VALUE?0:maxArea;        
    }
    
    int findArea(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited, boolean[][] visited_temp)
    {       
        for(boolean[] row : visited_temp)
            Arrays.fill(row, false);
        
        dfs(i,j,rows,cols,grid,visited,visited_temp);
        
        int area = 0;
        for(int x=0; x<rows; x++)
        {
            for(int y=0; y<cols; y++)
            {
                if(visited_temp[x][y])
                    area++;
            }
        }
        return area;
    }
    
    void dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited, boolean[][] visited_temp)
    {
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0 || visited_temp[i][j])
            return;
        visited[i][j] = true;
        visited_temp[i][j] = true;
        dfs(i-1,j,rows,cols,grid,visited,visited_temp);
        dfs(i+1,j,rows,cols,grid,visited,visited_temp);
        dfs(i,j-1,rows,cols,grid,visited,visited_temp);
        dfs(i,j+1,rows,cols,grid,visited,visited_temp);
    }
}