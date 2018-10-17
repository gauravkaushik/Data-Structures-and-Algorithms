package leetcode.easy.reverseonlyletters;

public class Solution {
	public String reverseOnlyLetters(String S) {

		char[] s = S.toCharArray();
		int n = S.length();
		int i = 0, j = n - 1;

		while (i < j) {
			if (Character.isLetter(s[i]) && Character.isLetter(s[j])) {

				char temp = s[i];
				s[i] = s[j];
				s[j] = temp;
				i++;
				j--;

			} else {
				if (!Character.isLetter(s[i]))
					i++;

				if (!Character.isLetter(s[j]))
					j--;
			}

		}

		return new String(s);

	}

}