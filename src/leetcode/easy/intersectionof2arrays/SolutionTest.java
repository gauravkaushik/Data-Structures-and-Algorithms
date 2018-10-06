package leetcode.easy.intersectionof2arrays;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] expected = { 2 };
		int[] actual = new Solution().intersection(nums1, nums2);
		Assert.assertArrayEquals(expected, actual);
		
		actual = new Solution().intersectionUsingHashMap(nums1, nums2);
		Assert.assertArrayEquals(expected, actual);
	}

}
