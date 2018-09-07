package leetcode.medium.stringtointeger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testAPositiveNumber() {
		int actual = new Solution().myAtoi("123");
		int expected = 123;
		assertEquals(expected, actual);
	}

	@Test
	public void testAPositiveNumberWithSign() {
		int actual = new Solution().myAtoi("+123");
		int expected = 123;
		assertEquals(expected, actual);
	}

	@Test
	public void testAPositiveNumberWithSignAndSpace() {
		int actual = new Solution().myAtoi("  +123");
		int expected = 123;
		assertEquals(expected, actual);
	}

	@Test
	public void testAPositiveNumberWithGarbageAtLeftAndRight() {
		int actual = new Solution().myAtoi("  +123with");
		int expected = 123;
		assertEquals(expected, actual);
	}

	@Test
	public void testAPositiveNumberWithSpacesAtLeftAndRight() {
		int actual = new Solution().myAtoi("  123  ");
		int expected = 123;
		assertEquals(expected, actual);
	}

	@Test
	public void testStringWithWhiteSpacesOnly() {
		int actual = new Solution().myAtoi("  ");
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testMaxPositiveInteger() {
		int actual = new Solution().myAtoi(" +2147483647 ");
		int expected = 2147483647;
		assertEquals(expected, actual);
	}

	@Test
	public void testIntegerBiggerThanMaxPositiveIntegerWithSign() {
		int actual = new Solution().myAtoi(" +2147483648 ");
		int expected = Integer.MAX_VALUE;
		assertEquals(expected, actual);
	}

	@Test
	public void testIntegerBiggerThanMaxPositiveIntegerWithoutSign() {
		int actual = new Solution().myAtoi("2147483648");
		int expected = Integer.MAX_VALUE;
		assertEquals(expected, actual);
	}

	@Test
	public void testFirstNonSpaceCharacterIsNotNumeric() {
		int actual = new Solution().myAtoi("word and 987 ");
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testANegativeNumber() {
		int actual = new Solution().myAtoi("-123");
		int expected = -123;
		assertEquals(expected, actual);
	}

	@Test
	public void testANegativeNumberWithSignAndSpace() {
		int actual = new Solution().myAtoi("  -123");
		int expected = -123;
		assertEquals(expected, actual);
	}

	@Test
	public void testANegativeNumberWithGarbageAtLeftAndRight() {
		int actual = new Solution().myAtoi("  -123with");
		int expected = -123;
		assertEquals(expected, actual);
	}

	@Test
	public void testANegativeNumberWithSpacesAtLeftAndRight() {
		int actual = new Solution().myAtoi("  -123  ");
		int expected = -123;
		assertEquals(expected, actual);
	}

	@Test
	public void testMinNegativeInteger() {
		int actual = new Solution().myAtoi(" -2147483648 ");
		int expected = -2147483648;
		assertEquals(expected, actual);
	}

	@Test
	public void testIntegerSmallerThanMinPositiveInteger() {
		int actual = new Solution().myAtoi(" -2147483649 ");
		int expected = Integer.MIN_VALUE;
		assertEquals(expected, actual);
	}

	@Test
	public void testIntegerWithZerosInFront() {
		int actual = new Solution().myAtoi("   0000000000012345678");
		int expected = 12345678;
		assertEquals(expected, actual);
	}

	@Test
	public void testIntegerWithBothPositiveAndNegativeSign() {
		int actual = new Solution().myAtoi("   +-2 ");
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testIntegerWithBothZeroInFrontAndBack() {
		int actual = new Solution().myAtoi("   010 ");
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test
	public void testStringWithNegativeSignInBetween() {
		int actual = new Solution().myAtoi("0-1");
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringWithNegativeSignAtEnd() {
		int actual = new Solution().myAtoi("123-");
		int expected = 123;
		assertEquals(expected, actual);
	}

}
