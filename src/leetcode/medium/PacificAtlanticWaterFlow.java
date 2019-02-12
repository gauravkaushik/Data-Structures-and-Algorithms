package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/pacific-atlantic-water-flow/
========================================================================

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

*/

public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        //mark all points of pacific
        List<int[]> res = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;      
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        boolean[][] visited = new boolean[M][N];
        
        //color[i][j] = 0 : water can't flow to either pacific or atlantic
        //color[i][j] = 1 : water can flow to pacific only
        //color[i][j] = 2 : water can flow to both pacific and atlantic        
        int[][] color = new int[M][N]; 
        
        int row, col;
        row = 0;        
        
        //do dfs from each position in first row
        for(col = 0; col < N; col++)
        {
            if(!visited[row][col])
                dfs(row, col, matrix, visited, color, -1);
        }
        
        //do dfs from each position in first col
        col = 0;
        for(row = 0; row < M; row++)
        {
            if(!visited[row][col])
                dfs(row, col, matrix, visited, color, -1);
        }
            
        for(row = 0; row < M; row++)
            Arrays.fill(visited[row], false);
        
        //do dfs from each position in last row
        row = M-1;
        for(col = 0; col < N; col++)
        {
            if(!visited[row][col])
                dfs(row, col, matrix, visited, color, -1);
        }
        
        //do dfs from each position in last col
        col = N-1;
        for(row = 0; row < M; row++)
        {
            if(!visited[row][col])
                dfs(row, col, matrix, visited, color, -1);
        }
        
        //return those positions whose color is 2
        for(row = 0; row < M; row++)
        {
            for(col = 0; col < N; col++)
            {
                if(color[row][col] == 2)
                    res.add(new int[]{row, col});
            }
        }
        
        return res;
        
    }
    
    private void dfs(int row, int col, int[][] matrix, boolean[][] visited, int[][] color, int parent)
    {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col] || matrix[row][col] < parent)
            return;
        
        visited[row][col] = true;
        
        if(color[row][col] == 0)
            color[row][col] = 1;
        else if(color[row][col] == 1)
            color[row][col] = 2;
        
        dfs(row-1, col, matrix, visited, color, matrix[row][col]); //Up
        dfs(row+1, col, matrix, visited, color, matrix[row][col]); //Down
        dfs(row, col-1, matrix, visited, color, matrix[row][col]); //Left
        dfs(row, col+1, matrix, visited, color, matrix[row][col]); //Right
    }
    
    
        
}