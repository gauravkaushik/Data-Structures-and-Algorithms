package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
========================================================================

In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:
Input: [1,2,3,3]
Output: 3

Example 2:
Input: [2,1,2,5,3,2]
Output: 2

Example 3:
Input: [5,1,5,2,5,3,5,4]
Output: 5
 
Note:
4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even
*/

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        
        //3 cases
        //case 1 : duplicate element is at even positions only
        //case 2 : duplicate element is at odd positions only
        //case 3 : atleast two duplicate elements will be consecutive
        
        
        for(int i=0,j=0,k=1; i<A.length-1; i++, j=j+2, k=k+2)
        {
            if(A[i]==A[i+1])
                return A[i];
            if(j+2<A.length && A[j]==A[j+2])
                return A[j];
            if(k+2<A.length && A[k]==A[k+2])
                return A[k];             
        }        
       
        return A[0]==A[A.length-1] ? A[0] : -1;    
    }
}