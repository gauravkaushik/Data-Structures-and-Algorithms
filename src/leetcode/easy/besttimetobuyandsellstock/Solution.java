package leetcode.easy.besttimetobuyandsellstock;

public class Solution {

	//referring ideal solution of leetcode
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int maxProfit = 0;
		int minPrice = prices[0];

		for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}

		return maxProfit;

	}

	// brute force way
	public int maxProfitBruteForce(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length - 1; i++) {
			int largest = prices[i];
			for (int j = i + 1; j < prices.length; j++) {
				largest = Math.max(largest, prices[j]);
			}
			int profit = largest - prices[i];
			maxProfit = Math.max(profit, maxProfit);
		}

		return maxProfit;

	}
}