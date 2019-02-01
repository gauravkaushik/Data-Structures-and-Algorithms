package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/squares-of-a-sorted-array/
========================================================================

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        //make all values in array +ve
        //find minimum value in array and add its square to result        
        //keep two pointers left, right of minimum
        //add square of smaller one to result and inc/dec 
        
        for(int i=0; i<A.length; i++)
        {
            if(A[i]<0)
                A[i] *= -1;
        }
        
        int min = Integer.MAX_VALUE;
        int j=0;
        for(int i=0; i<A.length; i++)
        {
            if(A[i] < min)
            {
                j = i;
                min = A[i];
            }
        }
        
        int[] result = new int[A.length];
        int k=0;
        result[k++] = (int)Math.pow(A[j],2);
        
        int left = j-1;
        int right = j+1;
        
        while(left>=0 || right<A.length)
        {
            if(left>=0 && right<A.length)
            {
                if(A[left]<A[right])
                {
                    result[k++] = (int)Math.pow(A[left--],2);
                }
                else
                    result[k++] = (int)Math.pow(A[right++],2);
            }
            else if(left>=0)
                result[k++] = (int)Math.pow(A[left--],2);
            else
                result[k++] = (int)Math.pow(A[right++],2);                
        }
        
        return result;
    }
}