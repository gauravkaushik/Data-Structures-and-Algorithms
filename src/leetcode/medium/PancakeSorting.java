package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/pancake-sorting/
========================================================================

Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 

Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
 

Note:

1 <= A.length <= 100
A[i] is a permutation of [1, 2, ..., A.length]
*/

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

	public static void main(String[] args) {
		int[] A = {4,3,2,1};
		PancakeSorting obj = new PancakeSorting();
		List<Integer> res = obj.pancakeSort(A);
		for(int i : res)
			System.out.print(i+", ");

	}

	public List<Integer> pancakeSort(int[] A) {
		List<Integer> res = new ArrayList<>();
		int N = A.length;
		int k=0;
		for(int i=N; i>1; i--)
		{
			//we will first find index of N, make a flip to bring it to first position 
			// and then make a second flip to move it to last position
			//then will find N-1 and move it to second last position
			// we repeat this for all numbers from N to 1
			
			for(k=0; k<=i-1; k++)
			{
				if(A[k]==i)
					break;
			}
			
			if(k==i-1)
			{
				continue;
			}
			
			if(k!=0) //k==0 means that the current element is already at first position
			{
				flip(A,k); 
				res.add(k+1);
			}				
			
			flip(A,i-1);			
			res.add(i);
		}
		
		return res;

	}
	
	void flip(int[] A, int k)
	{		
		//reverse first k positions
		int left = 0;
		int right = k;
		int temp;
		while(left < right)
		{
			temp = A[left];
			A[left] = A[right];
			A[right] = temp;
			left++;
			right--;
		}
	}

}
