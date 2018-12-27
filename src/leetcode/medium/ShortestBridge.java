package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/shortest-bridge/
=========================================================================
In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: [[0,1],[1,0]]
Output: 1
Example 2:

Input: [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Note:

1 <= A.length = A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
 */

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        
        //add all coordinates of island 1 into a queue; mark them as visited and assign a value 0 to each
        //do bfs from each of above coordinate to find closest coordinate of island 2 (i.e. a value of 1)        
        
        if(A == null || A.length==0)
            return 0;        
        
        int rows = A.length;
        int cols = A[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Coordinate> q = new LinkedList<>();
        boolean found = false;
        
        l1:
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(found)
                    break l1;
                if(!visited[i][j] && A[i][j]==1)
                {                    
                    findCoordinatesOfIsland(i,j,A,visited,rows,cols,q);                                       found = true;
                }
            }
        }
        
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int count=0;count<size;count++)
            {
                Coordinate coordinate = q.poll();
                
                //add neighbors of coordinate to queue
                int i = coordinate.i;
                int j = coordinate.j;
                
                if(A[i][j]==1)
                    return level-1;
                if(i-1>=0 && !visited[i-1][j])
                {
                    visited[i-1][j] = true;
                    q.offer(new Coordinate(i-1,j));
                }
                if(i+1<rows && !visited[i+1][j])
                {
                    visited[i+1][j] = true;
                    q.offer(new Coordinate(i+1,j));
                }
                if(j-1>=0 && !visited[i][j-1])
                {
                    visited[i][j-1] = true;
                    q.offer(new Coordinate(i,j-1));
                }
                if(j+1<cols && !visited[i][j+1])
                {
                    visited[i][j+1] = true;
                    q.offer(new Coordinate(i,j+1));
                }                
            }
            level++;
        }            
        
        return -1;      
        
    }
    
    void findCoordinatesOfIsland(int i, int j, int[][] A, boolean[][] visited, int rows, int cols, Queue<Coordinate> q)
    {
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || A[i][j]==0)
            return;
        
        visited[i][j] = true;       
        A[i][j] = 0;
        q.offer(new Coordinate(i,j));
        findCoordinatesOfIsland(i-1,j,A,visited,rows,cols,q);
        findCoordinatesOfIsland(i+1,j,A,visited,rows,cols,q);
        findCoordinatesOfIsland(i,j-1,A,visited,rows,cols,q);
        findCoordinatesOfIsland(i,j+1,A,visited,rows,cols,q);
    }
    
    
}
class Coordinate
{
    int i,j;
    Coordinate(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}