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
https://leetcode.com/problems/01-matrix/
========================================================================

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1: 
Input:
0 0 0
0 1 0
0 0 0

Output:
0 0 0
0 1 0
0 0 0

Example 2: 
Input:
0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1


Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.


*/

public class _01Matrix {    
    
    //Old Approach : launch a new BFS from each cell with 0 value : took ~2000ms
    //New Approach : enqueue all cells with 0 value into the queue at once and launch BFS : took ~40ms
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return matrix;
        
        int M = matrix.length;
        int N = matrix[0].length; //assuming M*N matrix
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                    q.offer( i*N + j );
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int cell, x, y;
        while(!q.isEmpty())
        {
            cell = q.poll();
            x = cell / N;
            y = cell % N;
            
            //enqueue non zero neighbors of current cell
            if(x>0 && matrix[x-1][y] > matrix[x][y]+1)
            {
                matrix[x-1][y] = matrix[x][y] + 1;
                q.offer( (x-1)*N + y );                
            }
            if(x<M-1 && matrix[x+1][y] > matrix[x][y]+1)
            {                
                matrix[x+1][y] = matrix[x][y] + 1;
                q.offer( (x+1)*N + y );
            }                    
            if(y>0 && matrix[x][y-1] > matrix[x][y]+1){                
                matrix[x][y-1] = matrix[x][y] + 1;
                q.offer( x*N + y-1 );
            }                    
            if(y<N-1 && matrix[x][y+1] > matrix[x][y]+1){                
                matrix[x][y+1] = matrix[x][y] + 1;
                q.offer( x*N + y+1 );
            } 
            
        }
        
        return matrix;
    }
    
}