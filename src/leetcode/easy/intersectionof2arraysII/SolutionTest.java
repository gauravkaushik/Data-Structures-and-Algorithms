package leetcode.easy.intersectionof2arraysII;

import org.junit.Assert;
import org.junit.Test;

//import leetcode.easy.intersectionof2arrays.Solution;

public class SolutionTest {

	@Test
	public void test1() {

		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] expected = { 2, 2 };
		int[] actual = new Solution().intersect(nums1, nums2);
		Assert.assertArrayEquals(expected, actual);

	}
	
	

}
