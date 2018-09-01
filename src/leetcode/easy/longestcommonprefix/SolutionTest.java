package leetcode.easy.longestcommonprefix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testWithNonEmptyLCPAndFirstStringBiggest() {
		String[] strs = { "flower", "flow", "flight" };
		String expecteds = "fl";
		String actuals = new Solution().longestCommonPrefix(strs);
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testWithNonEmptyLCPAndFirstStringSmallest() {
		String[] strs = { "flow", "flight", "flower" };
		String expecteds = "fl";
		String actuals = new Solution().longestCommonPrefix(strs);
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testWithEmptyLCP() {
		String[] strs = { "dog", "racecar", "car" };
		String expecteds = "";
		String actuals = new Solution().longestCommonPrefix(strs);
		assertEquals(expecteds, actuals);
	}

}
