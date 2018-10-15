package leetcode.easy.singlenumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	// without using extra memory
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}

		return res;
	}

	// using extra memory
	public int singleNumberUsingSet(int[] nums) {
		if (nums == null)
			return 0;

		Set<Integer> set = new HashSet<>();

		// for(int j:set)
		// System.out.print(j+", ");
		// System.out.println();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
			// System.out.println();
			// for(int j:set)
			// System.out.print(j+", ");
		}

		/*
		 * int x=-1; for(int i:set) { x=i; }
		 */
		// System.out.println();
		// for(int j:set)
		// System.out.print(j+", ");

		return set.iterator().next();

	}
}