package leetcode.easy.twosum;

import java.util.HashMap;

public class Solution {

	// start time :  23:20
	// end time  : 23:33
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return null;

		int[] result = new int[2];
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(target - nums[i])) {
				result[0] = table.get(target - nums[i]);
				result[1] = i;
				break;
			} else {
				table.put(nums[i], i);
			}
		}

		return result;

	}

}
