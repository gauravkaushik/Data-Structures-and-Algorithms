package leetcode.easy;

import java.util.Arrays;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/largest-perimeter-triangle/
========================================================================

Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.

If it is impossible to form any triangle of non-zero area, return 0.

Example 1:
Input: [2,1,2]
Output: 5

Example 2:
Input: [1,2,1]
Output: 0

Example 3:
Input: [3,2,3,4]
Output: 10

Example 4:
Input: [3,6,2,3]
Output: 8
 

Note:
3 <= A.length <= 10000
1 <= A[i] <= 10^6

*/

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
		Arrays.sort(A);
        
		for(int i=A.length-1, j=i-1, k=i-2; i>=2 && j>=1 && k>=0 ; i--,j--,k--)
		{
			if(A[j] + A[k] > A[i]) //triangle property			
				return A[i] + A[j] + A[k];		
		}
        
		return 0;        
    }
}