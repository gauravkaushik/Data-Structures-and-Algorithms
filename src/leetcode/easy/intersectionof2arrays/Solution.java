package leetcode.easy.intersectionof2arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {

		if (nums1 == null && nums2 == null)
			return null;

		Set<Integer> set = new HashSet<>();
		Set<Integer> result = new HashSet<>();

		if (nums1 != null) {
			for (int i = 0; i < nums1.length; i++)
				set.add(nums1[i]);
		}

		if (nums2 != null) {
			for (int i = 0; i < nums2.length; i++) {
				if (set.contains(nums2[i]) && !result.contains(nums2[i]))
					result.add(nums2[i]);
			}
		}

		int resultAry[] = new int[result.size()];
		int i = 0;
		for (int x : result)
			resultAry[i++] = x;
		return resultAry;

	}

	public int[] intersectionUsingHashMap(int[] nums1, int[] nums2) {
		if (nums1 == null && nums2 == null)
			return null;
		HashMap<Integer, Integer> mp = new HashMap<>();
		// HashMap<Integer,Integer> mp2 = new HashMap<>();

		if (nums1 != null) {
			for (int i = 0; i < nums1.length; i++) {
				if (!mp.containsKey(nums1[i]))
					mp.put(nums1[i], 1);
			}
		}

		if (nums2 != null) {
			for (int i = 0; i < nums2.length; i++) {
				if (mp.containsKey(nums2[i]) && mp.get(nums2[i]) != 0)
					mp.put(nums2[i], 0);
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int number : mp.keySet()) {
			if (mp.get(number) == 0)
				result.add(number);
		}

		int[] intersection = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
			intersection[i] = result.get(i);

		return intersection;

	}

}