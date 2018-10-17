package leetcode.medium.maximumsumcircularsubarray;

public class Solution {
	public int maxSubarraySumCircular(int[] A) {

		boolean onePositive = false;
		int maxNumber = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				onePositive = true;
				break;
			}
			maxNumber = Math.max(A[i], maxNumber);
		}
		if (!onePositive)
			return maxNumber;

		int notRotatedSum = maxSubArray(A);

		int totalSum = 0;

		for (int i = 0; i < A.length; i++) {

			totalSum += A[i];
			A[i] = -A[i];
		}

		int rotatedMaxSum = maxSubArray(A);

		totalSum = totalSum + rotatedMaxSum;

		return Math.max(totalSum, notRotatedSum);

	}

	public int maxSubArray(int[] nums) {

		int[] dp = new int[nums.length];

		dp[0] = nums[0];
		int maxSum = nums[0];
		int totalSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
			maxSum = Math.max(maxSum, dp[i]);

			totalSum += nums[i];
		}

		maxSum = Math.max(maxSum, totalSum);

		return maxSum;

	}
}