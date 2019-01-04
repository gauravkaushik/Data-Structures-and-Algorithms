package leetcode.easy;

import java.util.PriorityQueue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/kth-largest-element-in-a-stream/
========================================================================

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length >= k-1 and k <= 1.


*/

public class KthLargest {

    PriorityQueue<Integer> pq = null;
    int K;
    
    public KthLargest(int k, int[] nums) {        
        
        pq = new PriorityQueue<>(k);
        K = k;
        
        //construct a min heap of k size
        for(int i=0; i<nums.length; i++)
            add( nums[i] );     
        
    }
    
    public int add(int val) {
        //compare val and top of min heap
        //if val > top; remove top and insert val
        //else do nothing
        //return top
        
        if( pq.size() < K)
            pq.offer( val );
        else if( val > pq.peek() )
        {
            pq.poll();
            pq.offer( val );
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */