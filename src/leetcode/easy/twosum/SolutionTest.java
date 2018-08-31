package leetcode.easy.twosum;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testNegativeTargetValue() {
		int[] input = { -5, 2, -1, -5 };
		int target = -10;
		int[] expecteds = { 0, 3 };
		int[] actuals = new Solution().twoSum(input, target);
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testPositiveTargetValue() {
		int[] input = { 2, 7, 11, 15 };
		int target = 22;
		int[] expecteds = { 1, 3 };
		int[] actuals = new Solution().twoSum(input, target);
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testEmptyInput() {
		int[] input = {  };
		int target = 100;
		int[] expecteds = null;
		int[] actuals = new Solution().twoSum(input, target);
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testNullInput() {
		int[] input = null;
		int target = 100;
		int[] expecteds = null;
		int[] actuals = new Solution().twoSum(input, target);
		assertArrayEquals(expecteds, actuals);
	}

}
