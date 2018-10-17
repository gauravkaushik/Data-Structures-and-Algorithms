package leetcode.medium.houserobberII;

public class Solution {
	public int rob(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int result = 0;

		// rob house 0 to n-2
		int[] dp = new int[nums.length];

		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		if (nums.length == 2)
			return dp[1];

		for (int i = 2; i < nums.length - 1; i++)
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

		result = dp[nums.length - 2];

		// rob house 1 to n-1
		dp[1] = nums[1];
		dp[2] = Math.max(nums[1], nums[2]);

		for (int i = 3; i < nums.length; i++)
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

		result = Math.max(result, dp[nums.length - 1]);

		return result;

	}

}
