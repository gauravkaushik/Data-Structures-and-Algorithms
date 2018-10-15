package leetcode.easy.movezeroes;

public class Solution {
	public void moveZeroes(int[] nums) {

		int j = 0;
		for (int i = 0; i < nums.length;) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				i++;
				j++;
			} else {
				i++;
			}
		}

		for (; j < nums.length; j++)
			nums[j] = 0;

		// return nums;

	}
}