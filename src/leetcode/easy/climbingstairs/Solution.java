package leetcode.easy.climbingstairs;

public class Solution {
	public int climbStairs(int n) {

		int[] dp = new int[n + 3];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			// System.out.println();
			// System.out.println("dp["+(i-1)+"] : "+dp[i-1]);
			// System.out.println("dp["+(i-2)+"] : "+dp[i-2]);
			dp[i] = dp[i - 1] + dp[i - 2];
			// System.out.println("dp["+i+"] : "+dp[i]);
		}

		return dp[n];

	}
}