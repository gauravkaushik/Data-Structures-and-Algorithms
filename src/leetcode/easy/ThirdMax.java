package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/third-maximum-number/
========================================================================

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

public class ThirdMax {
    public int thirdMax(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++)
            hs.add( nums[i] );
        
        //there are less than 3 unique elements in input array
        if( hs.size() < 3 )
        {
            int max = Integer.MIN_VALUE;
            for( Integer i : hs )
                max = Math.max( max , i );
            return max;
        }
            
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);
        
        for( Integer i : hs )
        {
            minHeap.offer( i );
            if( minHeap.size() > 3 )
                minHeap.poll();
        }
        
        return minHeap.peek();
    }
}