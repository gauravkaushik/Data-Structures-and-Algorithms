package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/search-in-rotated-sorted-array/
========================================================================

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4


Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        if(nums.length==1 && nums[0]!=target)
            return -1;
        
        //find the point at which nums is rotated
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int rotationPoint=0;
        
        l1:
        while(low <= high)
        {
            if(low == high)
            {
                rotationPoint = low;
                break l1;
            }
            else if( ( (high-low) == 1 ) &&  nums[low]>nums[high])
            {
                rotationPoint = high;
                break l1;
            }
            mid = (low+high)/2;
            if(nums[low]<nums[mid] && nums[mid]<nums[high])
            {
                rotationPoint = 0;
                break l1;
            }
            else if(nums[low]<nums[mid])
                low = mid; //rotation point lies in second half
            else
                high = mid; //rotation point lies in first half                
        }
        
        int ans = search(nums, 0, rotationPoint-1, target);
        if(ans == -1)
            ans = search(nums, rotationPoint, nums.length-1, target);
        return ans;
    }
    
    int search(int[] nums, int low, int high, int target)
    {
        if(low > high)
            return -1;
        
        int mid;
        while(low <= high)
        {
            mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(target < nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    
}