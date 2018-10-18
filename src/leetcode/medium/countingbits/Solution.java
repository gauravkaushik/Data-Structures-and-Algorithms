package leetcode.medium.countingbits;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int[] countBits(int num) {

		int[] result = new int[num + 1];
		int power = 0;
		List<Integer> powers = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			power = (int) Math.pow(2, i);
			if (power > num)
				break;
			else {
				result[power] = 1;
				powers.add(power);
			}
		}

		// System.out.println("Powers : ");
		// for(int j:powers)
		// System.out.print(j+", ");

		int j = 0;

		int len = powers.size();
		for (int i = 1; i <= num; i++) {
			if (j < len && powers.get(j) == i) {
				j++;
			} else {
				// System.out.println("before result["+i+"] : "+result[i]);
				result[i] = result[powers.get(j - 1)] + result[i - powers.get(j - 1)];
				// System.out.println("after result["+i+"] : "+result[i]);
			}
		}

		return result;

	}

	// brute force
	public int[] countBitsNaive(int num) {

		int[] result = new int[num + 1];

		for (int i = 0; i <= num; i++) {
			String bs = Integer.toBinaryString(i);
			for (int j = 0; j < bs.length(); j++)
				if (bs.charAt(j) == '1')
					result[i]++;
		}

		return result;

	}
}