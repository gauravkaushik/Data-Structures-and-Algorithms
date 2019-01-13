package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/maximum-product-subarray/
========================================================================

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

/*
Credits : https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
*/

public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        
        int res = A[0];
        
        int imax=A[0], imin = A[0];
        
        for(int i=1; i<A.length; i++)
        {
            if(A[i] < 0)
            {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            
            imax = Math.max(imax*A[i], A[i]);
            imin = Math.min(imin*A[i], A[i]);
            
            res = Math.max(res, imax);
        }        
        return res;        
    }  
}