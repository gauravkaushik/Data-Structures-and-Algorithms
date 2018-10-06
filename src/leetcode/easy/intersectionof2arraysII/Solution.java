package leetcode.easy.intersectionof2arraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null && nums2 == null)
			return null;

		Map<Integer, Integer> mp1 = new HashMap<>();
		Map<Integer, Integer> mp2 = new HashMap<>();

		if (nums1 != null) {
			for (int i = 0; i < nums1.length; i++) {
				mp1.put(nums1[i], mp1.getOrDefault(nums1[i], 0) + 1);
			}
		}

		if (nums2 != null) {
			for (int i = 0; i < nums2.length; i++) {
				mp2.put(nums2[i], mp2.getOrDefault(nums2[i], 0) + 1);
			}
		}

		int min = 0;
		List<Integer> result = new ArrayList<>();
		for (int i : mp1.keySet()) {
			min = Math.min(mp1.get(i), mp2.getOrDefault(i, 0));
			for (int j = 0; j < min; j++)
				result.add(i);
		}

		int[] resultAry = new int[result.size()];
		int i = 0;
		for (int r : result)
			resultAry[i++] = r;

		return resultAry;

	}
}