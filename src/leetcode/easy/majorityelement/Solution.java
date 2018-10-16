package leetcode.easy.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	// divide and conquer
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;

		return majority(nums, 0, n - 1);

	}

	Integer majority(int[] A, int low, int high) {

		// System.out.println("low : "+low +" , high : "+high);

		if (low >= A.length || high >= A.length || low > high)
			return null;

		if (low == high)
			return A[low];

		Integer mid = (low + high) / 2;
		Integer leftM = majority(A, low, mid);
		// System.out.println("leftM : " + leftM);

		Integer rightM = majority(A, mid + 1, high);
		// System.out.println("rightM : " + rightM);

		if (leftM == null && rightM == null)
			return null;

		if (leftM == rightM)
			return leftM;

		Integer leftMCount = 0, rightMCount = 0;

		for (Integer i = low; i <= high; i++) {
			if (leftM != null && A[i] == leftM)
				leftMCount++;
			else if (rightM != null && A[i] == rightM)
				rightMCount++;
		}

		Integer n = (high - low + 1);
		Integer result = null;
		if (leftMCount > n / 2)
			result = leftM;
		else if (rightMCount > n / 2)
			result = rightM;

		// System.out.println("totalM : " + result);

		return result;

	}

	// iterative + using O(N) extra space
	public int majorityElementIterative(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;

		Map<Integer, Integer> mp = new HashMap<>();

		for (int i = 0; i < n; i++) {
			mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
		}

		for (Integer key : mp.keySet()) {
			if (mp.get(key) > n / 2)
				return key;
		}

		return 0;

	}
}