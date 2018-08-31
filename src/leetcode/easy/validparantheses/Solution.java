package leetcode.easy.validparantheses;

import java.util.Stack;

public class Solution {

	// 17:05
	// 17:18
	// 17:24
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;

		int len = s.length();

		if (len % 2 != 0)
			return false;

		Stack<Character> charStk = new Stack<Character>();

		for (int i = 0; i < len; i = i + 1) {
			switch (s.charAt(i)) {
			case '{':
			case '[':
			case '(':
				charStk.push(s.charAt(i));
				break;
			case '}':
				if (charStk.isEmpty())
					return false;
				if (charStk.pop() != '{')
					return false;
				break;
			case ']':
				if (charStk.isEmpty())
					return false;
				if (charStk.pop() != '[')
					return false;
				break;
			case ')':
				if (charStk.isEmpty())
					return false;
				if (charStk.pop() != '(')
					return false;
				break;
			default:
				return false;

			}
		}

		return charStk.isEmpty();

	}

}
