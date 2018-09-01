package leetcode.easy.longestcommonprefix;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	// 11:20
	// 11:44
	
	//my solution
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		// only one string

		ArrayList<CharFreq> charList = new ArrayList<CharFreq>();

		for (int i = 0; i < strs[0].length(); i++) {
			charList.add(new CharFreq(strs[0].charAt(i), 1));
		}

		int L = charList.size();
		if (L == 0) // because if any string is empty, there is no common prefix
			return "";

		for (int i = 1; i < strs.length; i++) {
			for (int j = 0; j < strs[i].length(); j++) {
				if (j >= L) {
					break;
				} else if (strs[i].charAt(j) == charList.get(j).c) {
					charList.get(j).freq++;
				} else {
					if (j == 0) {
						return ""; // first character itself did not match in
									// one of the strings. so return an empty
									// sting
					} else {
						break; // stop processing current string. start
								// processing next string
					}
				}
			}
		}

		StringBuffer lcp = new StringBuffer();
		int N = strs.length;

		for (int i = 0; i < charList.size(); i++) {
			if (charList.get(i).freq == N) {
				lcp.append(charList.get(i).c);
			} else {
				break;
			}
		}

		return lcp.toString();

	}

	// Sample solution taken from leetcode
	public String longestCommonPrefixLeetCode(String[] strs) {
		if (strs.length == 0)
			return "";

		Arrays.sort(strs);

		String first = strs[0];
		String last = strs[strs.length - 1];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != last.charAt(i)) {
				break;
			}
			sb.append(first.charAt(i));
		}

		return sb.toString();
	}

}

class CharFreq {
	char c;
	int freq; // frequency of the character 'c'

	CharFreq(char c, int freq) {
		this.c = c;
		this.freq = freq;
	}
}