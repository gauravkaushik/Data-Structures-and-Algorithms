package leetcode.easy.sumoftwointegers;

/*
 Ref: https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
 */
public class Solution {
	public int getSum(int a, int b) {

		while (b != 0) {
			int carry = a & b;

			a = a ^ b;

			b = carry << 1;
		}

		return a;

	}
}