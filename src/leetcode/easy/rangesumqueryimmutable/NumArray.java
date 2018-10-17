package leetcode.easy.rangesumqueryimmutable;

public class NumArray {

	int[] nums;
	int[] dp;

	public NumArray(int[] nums) {

		if (nums == null || nums.length == 0)
			return;

		this.nums = nums;
		int n = nums.length;

		dp = new int[n];

		dp[0] = nums[0];

		for (int i = 1; i < n; i++)
			dp[i] = dp[i - 1] + nums[i];
	}

	public int sumRange(int i, int j) {
		return dp[j] - dp[i] + nums[i];
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
