package leetcode.hard.longestconsecutivesequence;

import java.util.HashMap;

public class Solution {

	// 00:13
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Boolean> processed = new HashMap<Integer, Boolean>();
		for (int i = 0; i < nums.length; i++) {
			processed.put(nums[i], false);
		}

		Result result = new Result();

		for (int i = 0; i < nums.length; i++) {
			if (processed.get(nums[i]) == false)
				process(nums[i], processed, result);
		}

		return result.count;

	}

	// 100 1 102 2 4 3
	public int process(int num, HashMap<Integer, Boolean> processed, Result result) {
		int count = 0;
		if (!processed.containsKey(num) || processed.get(num) == true)
			return 0;
		else {
			processed.put(num, true);
			count = 1 + process(num - 1, processed, result) + process(num + 1, processed, result);
			if (result.count < count)
				result.count = count;
			return count;
		}

	}

}

class Result {
	public int count;

	public Result() {

	}
}
