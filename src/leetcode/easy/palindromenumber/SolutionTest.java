package leetcode.easy.palindromenumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void testWithPalindrome() {
		int input = 121;
		assertTrue(new Solution().isPalindrome(input));
	}

	@Test
	public void testWithNonPalindrome() {
		int input = 123;
		assertFalse(new Solution().isPalindrome(input));

	}

	@Test
	public void testWithNegativeNumber() {
		int input = -123;
		assertFalse(new Solution().isPalindrome(input));
	}

	@Test
	public void testWithSingleDigitNumber() {
		int input = 5;
		assertTrue(new Solution().isPalindrome(input));
	}

}
