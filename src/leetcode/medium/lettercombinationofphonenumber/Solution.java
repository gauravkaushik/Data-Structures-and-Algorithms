package leetcode.medium.lettercombinationofphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<String> letterCombinations(String digits) {

		HashMap<Integer, ArrayList<String>> mapping = new HashMap<Integer, ArrayList<String>>();
		mapping.put(2, getList('a', 'b', 'c'));
		mapping.put(3, getList('d', 'e', 'f'));
		mapping.put(4, getList('g', 'h', 'i'));
		mapping.put(5, getList('j', 'k', 'l'));
		mapping.put(6, getList('m', 'n', 'o'));
		mapping.put(7, getList('p', 'q', 'r', 's'));
		mapping.put(8, getList('t', 'u', 'v'));
		mapping.put(9, getList('w', 'x', 'y', 'z'));

		ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < digits.length(); i++)
			input.add(mapping.get(digits.charAt(i) - '0'));

		if (input.size() <= 0)
			return result;

		ArrayList<String> prev = input.get(0);
		ArrayList<String> curr = null;
		result = prev;
		for (int i = 1; i < input.size(); i++) {
			curr = input.get(i);
			result = findAllCombinations(prev, curr);
			prev = result;
		}

		return result;

	}

	public static ArrayList<String> getList(char i, char j, char k) {
		ArrayList<String> result = new ArrayList<String>();
		result.add(i + "");
		result.add(j + "");
		result.add(k + "");
		return result;
	}

	public static ArrayList<String> getList(char i, char j, char k, char l) {
		ArrayList<String> result = getList(i, j, k);
		result.add(l + "");
		return result;
	}

	public static ArrayList<String> findAllCombinations(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> result = new ArrayList<String>();
		for (String str1 : list1)
			for (String str2 : list2)
				result.add(str1 + str2);

		return result;
	}
}