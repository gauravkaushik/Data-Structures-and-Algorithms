package leetcode.easy.reverseinteger;

public class Solution {

	// optimal solution sample taken from leetcode
	public int reverse2(int x) {
		long res = 0;
		for (int temp = x; temp != 0; temp /= 10) {
			res = res * 10 + temp % 10;
		}
		if ((res > Integer.MAX_VALUE) || (res < Integer.MIN_VALUE))
			return 0;
		return (int) res;
	}

	// my solution
	public int reverse(int x) {

		boolean negative = false;
		if (x < 0) {
			negative = true;
			x = -x;
		}

		int[] digit = new int[10]; // max 10 digits possible in java int

		int y = x;
		int i = 0;
		for (; i < 10; i++) {
			digit[i] = y % 10;
			y = y / 10;
			if (y == 0)
				break;
		}

		int count = i; // number of digits
		int j = count;
		int result = 0;
		for (i = 0; i <= count; i++) {

			try {
				result = add(result, multiply(power(10, j), digit[i]));
			} catch (Exception e) {				
				return 0;
			}

			j--;
		}

		if (negative)
			result = -result;
		return result;

	}

	private int add(int a, int b) throws Exception {
		if (a > Integer.MAX_VALUE - b)
			throw new Exception();
		else
			return a + b;
	}

	private int multiply(int a, int b) throws Exception {
		int result = 0;
		for (int i = 1; i <= b; i++) {
			result = add(result, a);
		}
		return result;
	}

	private int power(int i, int j) {
		// TODO Auto-generated method stub
		return (int) Math.pow(i, j);
	}

	public static void main(String[] args) {
		int i = 2147483647;
		int j = i / 10 + 7;

	}
}
