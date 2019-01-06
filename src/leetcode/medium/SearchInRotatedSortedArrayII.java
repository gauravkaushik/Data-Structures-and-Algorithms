package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
========================================================================

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(-1 == helper(nums,target))
            return false;
        return true;
    }
    
    public int helper(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        if(nums.length==1 && nums[0]!=target)
            return -1;
        
        //find the point at which nums is rotated
        
        int rotationPoint = -1;        
        
        for(int i=1; i<nums.length; i++)
            if(nums[i] < nums[i-1])
                rotationPoint = i;
        
        rotationPoint = ( rotationPoint==-1 ? 0 : rotationPoint );            
        
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