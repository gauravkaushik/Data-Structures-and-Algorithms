package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        
        //color all islands with different color; also compute size of each color
        //find next zero; create a set of its neighboring colors and add all sizes and update max area 
        //continue until no zero left 
        //return max area
        if(grid==null || grid.length==0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;    
        boolean hasZero = false;
        int maxArea = 1;
        int area = 0;
        int color = 2;
        
        boolean[][] visited = new boolean[rows][cols];
        Map<Integer,Integer> sizes = new HashMap<>();
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(!visited[i][j] && grid[i][j]==1)
                {         
                    int islandSize = dfs(grid,i,j,visited,rows,cols,color);
                    sizes.put(color, islandSize);
                    color++;
                }
            }
        }
            
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j]==0)
                {
                    hasZero = true;
                    Set<Integer> neighboringColors = new HashSet<>();
                    if(i-1 >= 0) neighboringColors.add(grid[i-1][j]);
                    if(i+1 < rows) neighboringColors.add(grid[i+1][j]);
                    if(j-1 >= 0) neighboringColors.add(grid[i][j-1]);
                    if(j+1 < cols) neighboringColors.add(grid[i][j+1]);
                    
                    if(neighboringColors.isEmpty())
                        continue;
                    
                    //find total area
                    area = 0;
                    for(int neighboringColor : neighboringColors)
                        area += sizes.getOrDefault(neighboringColor,0);
                    
                    maxArea = Math.max(maxArea,1+area);
                }
            }
        }    
        
        return hasZero?maxArea:rows*cols;
        
    }
    
    
    
    int dfs(int[][] grid, int i, int j, boolean[][] visited, int rows, int cols, int color)
    {
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || grid[i][j]==0)
            return 0;
        visited[i][j]=true;
        grid[i][j] = color;
                
        return 1 + dfs(grid,i-1,j,visited,rows,cols,color)+ dfs(grid,i+1,j,visited,rows,cols,color) + dfs(grid,i,j-1,visited,rows,cols,color) + dfs(grid,i,j+1,visited,rows,cols,color);
    }
}