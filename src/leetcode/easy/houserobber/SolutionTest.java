package leetcode.easy.houserobber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testOddHousesSumIsMore() {
		int[] nums = { 2,3,2 };
		int expected = 4;
		int actual = new Solution().rob(nums);
		assertEquals(expected, actual);
	}

	@Test
	public void testEvenHousesSumIsMore() {
		int[] nums = { 1, 2, 3, 1 };
		int expected = 4;
		int actual = new Solution().rob(nums);
		assertEquals(expected, actual);
	}

	@Test
	public void testRandomSelectedHousesSumIsMore() {
		int[] nums = { 2, 1, 1, 2 };
		int expected = 4;
		int actual = new Solution().rob(nums);
		assertEquals(expected, actual);
	}

	@Test
	public void testLongInput() {
		int[] nums = { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81,
				90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205,
				169, 241, 202, 144, 240 };
		int expected = 4173;
		int actual = new Solution().rob(nums);
		assertEquals(expected, actual);
	}
	
	//[8,9,9,4,10,5,6,9,7,9] : expected is 45
	

}
