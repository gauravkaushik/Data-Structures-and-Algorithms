package leetcode.easy.reversestring;

public class Solution {

	// using array
	public String reverseString(String s) {
		if (s == null || s.length() <= 1)
			return s;

		char[] c = s.toCharArray();

		char temp;
		for (int i = 0; i < s.length() / 2; i++) {
			temp = c[i];
			c[i] = c[s.length() - i - 1];
			c[s.length() - i - 1] = temp;
		}

		return new String(c);

	}

	public String reverseStringUsingStringBuilder(String s) {
		if (s == null || s.length() <= 1)
			return s;

		StringBuilder result = new StringBuilder(s.length());

		for (int i = s.length() - 1; i >= 0; i--)
			result.append(s.charAt(i));

		return result.toString();

	}
}