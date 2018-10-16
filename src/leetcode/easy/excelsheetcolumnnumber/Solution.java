package leetcode.easy.excelsheetcolumnnumber;

public class Solution {
	public int titleToNumber(String s) {

		if (s == null || s.length() == 0)
			return -1;

		int n = s.length();

		int[] powersOf26 = new int[n];

		powersOf26[0] = 1;

		for (int i = 1; i < n; i++) {
			powersOf26[i] = powersOf26[i - 1] * 26;
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result += powersOf26[i] * (s.charAt(n - i - 1) - 'A' + 1);
		}

		return result;

	}
}