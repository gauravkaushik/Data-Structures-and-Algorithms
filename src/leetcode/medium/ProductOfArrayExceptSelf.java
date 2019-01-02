package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/product-of-array-except-self/
========================================================================

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        //null and empty checks
        if(nums == null || nums.length==0)
            return nums;
        
        int N = nums.length;
        int[] result = new int[N];
        int prod = 1;
        
        for(int i=N-1; i>=0; i--)
        {
            result[i] = prod;
            prod *= nums[i];
        }
        //System.out.println(Arrays.toString(result));
        
        prod = 1;
        for(int i=0; i<N; i++)
        {
            result[i] = prod * result[i];
            prod = prod * nums[i];
        }
        
        return result;
        
    }
}