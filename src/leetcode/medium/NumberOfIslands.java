package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
========================================================================
https://leetcode.com/problems/number-of-islands/
=========================================================================
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

class Solution {
    
    //DFS
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
            
        int result = 0;
            
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    result++;
                    markUsingDFS(grid,i,j);
                }
            }
        }
        
        return result;
    }
    
    void markUsingDFS(char[][] grid, int i, int j)
    {
    	if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0')
    		return;    	
        
        grid[i][j] = '0';
        markUsingDFS(grid,i-1,j);
        markUsingDFS(grid,i+1,j);
        markUsingDFS(grid,i,j-1);
        markUsingDFS(grid,i,j+1);            
             
        
    }

	 public int numIslandsBFS(char[][] grid) {
	     //numIslands = 0        
	     //iterate through grid from left to right,top to bottom manner
	     //find next unvisited 1
	     //increment numIslands by 1
	     //do bfs from it and mark all adjacent nodes as visited
	     if(grid==null || grid.length==0)
	         return 0;
	     boolean[][] visited = new boolean[grid.length][grid[0].length];
	     int result = 0;
	     for(int i=0;i<grid.length;i++)
	     {
	         for(int j=0;j<grid[0].length;j++)
	         {
	             if(!visited[i][j] && grid[i][j]=='1')
	             {
	                 result++;
	                 bfs(i,j,visited, grid);
	             }
	         }
	     }
	     
	     return result;
	 }
	 
	 void bfs(int i, int j, boolean[][] visited, char[][] grid)
	 {
	     Queue<Node> q = new LinkedList<>();
	     q.add(new Node(i,j));
	     
	     while(!q.isEmpty())
	     {
	         Node node = q.remove();
	         if(visited[node.i][node.j]==true)
	             continue;
	         visited[node.i][node.j] = true;
	         
	         for(Node neighbor : getAdjacentOnes(node.i, node.j, grid.length, grid[0].length, grid, visited))
	         {
	             q.add(neighbor);
	         }
	     }        
	 }
	 
	 List<Node> getAdjacentOnes(int i, int j, int limitX, int limitY, char[][] grid, boolean[][] visited)
	 {
	     List<Node> adjacentOnes = new ArrayList<>();
	     add(adjacentOnes,i-1,j,limitX,limitY,grid,visited);
	     add(adjacentOnes,i+1,j,limitX,limitY,grid,visited);
	     add(adjacentOnes,i,j-1,limitX,limitY,grid,visited);
	     add(adjacentOnes,i,j+1,limitX,limitY,grid,visited);
	     return adjacentOnes;
	 }
	 
	 //Add to list if the (x,y) is within range(0,limit-1) and grid[x][y] is 1
	 void add(List<Node> adjacentOnes, int x, int y, int limitX, int limitY, char[][] grid, boolean[][] visited)
	 {
	     if(x>=0 && x<limitX && y>=0 && y<limitY && grid[x][y]=='1' && !visited[x][y])
	         adjacentOnes.add(new Node(x,y));
	 }
	}
	
	class Node
	{
	 int i, j;
	 Node(int i, int j)
	 {
	     this.i = i;
	     this.j = j;
	 }
}