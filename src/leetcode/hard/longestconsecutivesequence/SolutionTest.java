package leetcode.hard.longestconsecutivesequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int expected = 4;
		int actual = new Solution().longestConsecutive(nums);
		assertEquals(expected, actual);
	}

	@Test
	public void testDescendingOrder() {
		int[] nums = { 4, 3, 2 };
		int expected = 3;
		int actual = new Solution().longestConsecutive(nums);
		assertEquals(expected, actual);
	}

	@Test
	public void testAscendingOrder() {
		int[] nums = { 1, 2, 3 };
		int expected = 3;
		int actual = new Solution().longestConsecutive(nums);
		assertEquals(expected, actual);
	}

}
