package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/search-a-2d-matrix/
========================================================================

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find row number by binary search
        //find element in that row by binary search
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        
        int row = findRow(matrix, 0, matrix.length-1, target);
        if(row == -1)
            return false;
        
        return findElement(matrix, row, 0, matrix[0].length-1, target);        
        
    }
    
    private boolean findElement(int[][] matrix, int row, int low, int high, int target)
    {
        if(low > high)
            return false;
        
        int mid = (int)Math.floor((low + high)/2);        
        mid = mid % matrix[0].length;
        
        if(target == matrix[row][mid])
            return true;
        else if(target < matrix[row][mid])
            return findElement(matrix, row, low, mid-1, target);
        else
            return findElement(matrix, row, mid+1, high, target);
    }
    
    int findRow(int[][] matrix, int low, int high, int target)
    {
        if(low > high)
            return -1;
        int mid = (int)Math.floor((low + high) / 2);
        mid = mid % matrix.length;        
        
        if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length-1])
            return mid;
        else if(target < matrix[mid][0])
            return findRow(matrix, low, mid-1, target);
        else 
            return findRow(matrix, mid+1, high, target);
    }
}