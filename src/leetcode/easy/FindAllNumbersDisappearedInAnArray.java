package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
========================================================================
Given an array of integers where 1 <= to a[i] <= n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        //null and empty checks
        if(nums==null || nums.length==0)
            return result;
        
        int index;
        for(int i=0; i<nums.length; i++)
        {
            index = Math.abs(nums[i])-1;
            
            if(nums[index]>0)
                nums[index] *= -1;
        }
        
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)
                result.add(i+1);
        }
        
        return result;
    }
}