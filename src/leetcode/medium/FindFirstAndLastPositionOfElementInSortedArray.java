package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
========================================================================

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

public class FindFirstAndLastPositionOfElementInSortedArray {
    
    public int[] searchRange(int[] nums, int target) {
        
        int lb = lowerBound( nums, target );
        int ub = upperBound( nums, target );
        
        return new int[] {lb, ub};
    }
    
    private int lowerBound(int[] nums, int target)
    {
        int low = 0, high = nums.length-1;
        int mid;
        while( low < high )
        {
            mid = ( low + high ) / 2;
            if( target <= nums[mid] )
                high = mid;
            else
                low = mid + 1;            
        }
        if(low==high && nums[low]==target)
            return low;
        else
            return -1;
    }
    
    int upperBound(int[] nums, int target)
    {
        int low = 0, high = nums.length-1;
        int mid;
        
        while( low < high )
        {
            mid = ( low + high + 1 ) / 2;
            
            if( target >= nums[mid] )
                low = mid;            
            else
                high = mid - 1;
        }
        
        if( low==high && nums[low]==target )
            return low;
        
        return -1;
    }
}