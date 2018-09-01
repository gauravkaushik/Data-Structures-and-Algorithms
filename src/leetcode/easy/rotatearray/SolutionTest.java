package leetcode.easy.rotatearray;

import org.junit.Assert;

import org.junit.Test;

public class SolutionTest {

	/*@Test
	public void testRotateByTwo() {
		int[] input = { 15, 20, 10, 19, 51 };
		int[] expecteds = { 19, 51, 15, 20, 10 };
		new Solution().rotate(input, 2);
		int[] actuals = input;
		Assert.assertArrayEquals(expecteds, actuals);
	}*/

	@Test
	public void testRotateByArrayLength() {
		int[] input = { 15, 20, 10, 19, 51 };
		int[] expecteds = { 15, 20, 10, 19, 51 };
		new Solution().rotate(input, 5);
		int[] actuals = input;
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testRotateByTwo() {
		int[] input = { 1,2,3,4,5,6 };
		int[] expecteds = { 5,6,1,2,3,4 };
		new Solution().rotate(input, 2);
		int[] actuals = input;
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
