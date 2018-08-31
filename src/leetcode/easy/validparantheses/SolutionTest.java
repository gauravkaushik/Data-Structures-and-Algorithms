package leetcode.easy.validparantheses;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testWithAnEmptyString() {
		String input = "";
		assertTrue(new Solution().isValid(input));
	}

	@Test
	public void testWithAValidString() {
		String input = "()[]";
		assertTrue(new Solution().isValid(input));
	}

	@Test
	public void testWithInvalidString1() {
		String input = "()[](";
		assertFalse(new Solution().isValid(input));
	}
	
	@Test
	public void testWithInvalidString2() {
		String input = "(]";
		assertFalse(new Solution().isValid(input));
	}
	
	@Test
	public void testWithInvalidString3() {
		String input = "{[]}";
		assertTrue(new Solution().isValid(input));
	}

}
