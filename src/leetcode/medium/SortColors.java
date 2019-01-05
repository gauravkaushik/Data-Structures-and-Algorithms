package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/sort-colors/
========================================================================

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
*/

public class SortColors {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        
        for(int i=1; i<nums.length; i++)
        {
            //find right position for the element nums[i] in the already sorted range (0,i-1)            
            int lb = lowerBound( nums, 0, i-1, nums[i], i-1 );            
            int newVal = nums[i];
            if( lb == i)
            {
                nums[i] = newVal;
            }
            else
            {
                //shift all elements from index lb by 1 position
                //put new element at index lb
                for( int j=i-1; j>=lb; j-- )
                    nums[j+1] = nums[j];
                
                nums[lb] = newVal;
            }
            
                            
        }
    }
    
    int lowerBound( int[] nums, int low, int high, int target, int limit )
    {   
        if( low==high )
        {
            if( target <= nums[low] )
                return low;
            else
                return low+1;
        }
        while(low < high)
        {
            int mid = ( low + high ) / 2;
            if( target <= nums[mid] )
                high = mid;
            else
                low = mid + 1;
        }
        if( low == limit && nums[low] < target )
            low++;
        return low;
    }
}