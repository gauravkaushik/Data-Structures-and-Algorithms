package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/sliding-window-maximum/
========================================================================

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 <= k <= input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

public class SlidingWindowMaximum {
    
    //Using a Deque -> O(N)
    //reference : https://www.youtube.com/watch?v=J6o_Wz-UGvc
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return new int[0];
        
        Deque<Integer> dq = new LinkedList<Integer>();
        
        int[] result = new int[nums.length-k+1];
        
        for(int i=0; i<nums.length; i++)
        {            
            while(!dq.isEmpty())
            {
                //keep removing from back of queue till new element is bigger
                if(nums[i]>=nums[dq.getLast()])
                    dq.removeLast();
                else
                    break;
            }         
            
            //add new element to back of queue
            dq.addLast(i);            
            
            if(i >= k-1)
            {
                int j = dq.getFirst();
                result[i-k+1] = nums[j];
                if(j== (i-k+1))
                    dq.removeFirst();                
            } 
        }
        
        return result;
        
    }
    
    //Using a self balancing BST ==> O( (N-K) * logK )
    public int[] maxSlidingWindowUsingBST(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return new int[0];
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i=0; i<k; i++)
            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);            
        
        int[] result = new int[nums.length-k+1];
        Integer maxKey = mp.lastKey();
        result[0] = maxKey;       
             
        for(int i=1; i<result.length; i++)
        {
            mp.put(nums[i-1], mp.get(nums[i-1]) - 1);
            if(mp.get(nums[i-1]) == 0)
                mp.remove(nums[i-1]); 
            
            mp.put(nums[i+k-1], mp.getOrDefault(nums[i+k-1],0)+1);           
            
            result[i] = mp.lastKey();
        }
        return result;       
    }
}