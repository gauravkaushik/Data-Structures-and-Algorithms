package leetcode.easy.plusone;

import java.util.ArrayList;

public class Solution {
	
	//my solution
	public int[] plusOne(int[] digits) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int sum = 0, carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			sum = carry + digits[i];
			carry = sum / 10;
			sum = sum % 10;
			result.add(0, sum);
		}
		if (carry != 0)
			result.add(0, carry);

		int[] plusOne = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
			plusOne[i] = result.get(i);
		return plusOne;
	}
	
	//sample solution from leetcode
	//start reading digits from right to left
	//if current digit is <9, incr it by 1 and return the new number
	//else make it zero and continue
	//if all digits have been read but we are still in this method, then create a new number with length+1 and make first digit as 1 and then return
	public int[] plusOneSample(int[] digits) {
        for(int i = digits.length - 1; i >=0 ; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // it is the case like: 99999
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}