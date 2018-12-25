package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/island-perimeter/
=========================================================================
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
 */
 
 
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
    
        if(grid==null || grid.length==0)
            return 0;
            
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int i,j;
        
        
        for(i=0; i<rows; i++)
        {
            for(j=0; j<cols; j++)
            {
                //for each cell with value 1, check its 4 boundaries and increment perimeter if that boundary
                //is surrounded by water or is the grid boundary
                if(grid[i][j] == 1)
                {                    
                    if(i-1<0 || grid[i-1][j]==0)
                        result++;
                    if(i+1>=rows || grid[i+1][j]==0)
                        result++;
                    if(j-1<0 || grid[i][j-1]==0)
                        result++;
                    if(j+1>=cols || grid[i][j+1]==0)
                        result++;                    
                }
            }
        }
        
        return result;        
    }
}
