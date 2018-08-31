package leetcode.easy.palindromenumber;

public class Solution {

	// 09:28 : start reading question
	// 09:37 : code done
	// 09:43 : test cases done
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int y = reverse(x); //Reverse the number
		if (x == y)
			return true;
		return false;

	}

	int reverse(int x) {
		long result = 0;
		for (int temp = x; temp != 0; temp /= 10) {
			result = result * 10 + temp % 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;

		else
			return (int) result;

	}

}
