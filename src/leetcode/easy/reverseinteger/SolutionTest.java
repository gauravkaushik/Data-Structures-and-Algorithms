package leetcode.easy.reverseinteger;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testARandomPositiveNumber() {
		int input = 123;
		int expected = 321;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testARandomNegativeNumber() {
		int input = -123;
		int expected = -321;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testASingleDigitPositiveNumber() {
		int input = 9;
		int expected = 9;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testASingleDigitNegativeNumber() {
		int input = -9;
		int expected = -9;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testANumberThatEndsWithZero() {
		int input = 120;
		int expected = 21;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testANumberWhoseReverseOverflows() {
		int input = 1234569999;
		int expected = 0;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testANumberWhoseReverseIsMaximumNegativeInteger() {
		int input = 1563847412;
		int expected = 0;
		int actual = new Solution().reverse(input);
		assertEquals(expected, actual);
	}
	

}
