package leetcode.medium;

import java.util.Arrays;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/set-matrix-zeroes/
========================================================================

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]


Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return;
        
        int m = matrix.length;        
        int n = matrix[0].length;
        
        //use first row and first column as storage space        
        boolean makeFirstRowZero = false, makeFirstColumnZero = false;
        for(int col=0; col<n; col++)
        {
            if(matrix[0][col]==0)
            {
                makeFirstRowZero = true;
                break;
            }
        }
        
        for(int row=0; row<m; row++)
        {
            if(matrix[row][0]==0)
            {
                makeFirstColumnZero = true;
                break;
            }
        }
            
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if( matrix[i][j] == 0 )
                {                                    
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;                
            }
        }
        
        if(makeFirstRowZero)
            Arrays.fill(matrix[0],0);
        if(makeFirstColumnZero)
        {
            for(int row=0; row<m; row++)
                matrix[row][0] = 0;
        }
        
    }
}