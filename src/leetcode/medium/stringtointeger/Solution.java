package leetcode.medium.stringtointeger;

public class Solution {

	//my solution
	public int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

		// Java int can have max 10 digits
		// int[] digits = new int[10];
		boolean isPositive = true;

		StringBuffer digitsBfr = new StringBuffer();

		boolean isFirstNonSpaceFound = false;
		boolean isFirstNonZeroDigitFound = false;

		char c;
		int d = 0;
		l1: for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			switch (c) {
			case ' ':
				if (isFirstNonSpaceFound)
					break l1;
				break;
			case '+':
				if (isFirstNonSpaceFound)
					break l1;
				isFirstNonSpaceFound = true;
				break;
			case '-':
				if (isFirstNonSpaceFound)
					break l1;
				isPositive = false;
				isFirstNonSpaceFound = true;
				break;
			case '0':
				isFirstNonSpaceFound=true;
				d++;
				if (isFirstNonZeroDigitFound) {
					digitsBfr.append(c);
					break;
				} else {
					break;
				}
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				isFirstNonSpaceFound = true;
				isFirstNonZeroDigitFound = true;
				if (d == 10) // more than 10 consecutive numeric digits
					return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				// digits[d++] = c - '0';
				d++;
				digitsBfr.append(c);
				break;
			default:
				break l1;
			}

		}

		int len = digitsBfr.length();
		int[] digits = new int[len];
		for (int i = 0; i < len; i++)
			digits[i] = digitsBfr.charAt(len - i - 1) - '0';

		// return getInteger(digits, isPositive);
		return getIntegerUsingLib(digitsBfr, isPositive);

	}

	int getIntegerUsingLib(StringBuffer digitsBfr, boolean isPositive) {
		
		if(digitsBfr==null || digitsBfr.length()==0)
			return 0;

		int result=0;
		try{
			result = Integer.parseInt(digitsBfr.toString());
		}catch(NumberFormatException e)
		{
			if(isPositive)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		if (!isPositive)
			result = -result;
		return result;
	}

	int getInteger(int[] digits, boolean isPositive) {

		// number is negative case
		// check minimum number case specially : -2147483648

		// number is positive case
		int result = 0;
		for (int i = 0; i < digits.length; i++) {
			try {
				result = add(result, multiply(digits[i], power(10, i)));
			} catch (Exception e) {
				if (isPositive)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
			}
		}

		if (!isPositive)
			result = -result;
		return result;

	}

	int add(int a, int b) throws Exception {
		if (a > Integer.MAX_VALUE - b)
			throw new Exception();
		return a + b;
	}

	int multiply(int a, int b) throws Exception {
		int result = 0;
		for (int i = 1; i <= b; i++) {
			result = add(result, a);
		}
		return result;
	}

	int power(int n, int k) throws Exception {
		int result = 1;
		for (int i = 1; i <= k; i++) {
			result = multiply(result, n);
		}
		return result;
	}
	
	//sample solution from leetcode
	 public int myAtoiLeetCode(String str) {
	        str=str.trim();
			int n=str.length();
			if(n==0) return 0;
			
			if(str.charAt(0)!='-' && str.charAt(0)!='+' && (str.charAt(0)<'0' || str.charAt(0)>'9'))
				return 0;
			//System.out.println(str);
			int i=0;
			int ans=0;
			char positive='+';
			if(str.charAt(0)=='-' || str.charAt(0)=='+') {
				i=1;
				positive=str.charAt(0);
			}
			while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9') {
				if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && str.charAt(i)>'7')) {
					return positive=='+'?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
				ans=ans*10+str.charAt(i)-'0';
				i++;
			}
			return positive=='+'?ans:(ans>0?-ans:ans);
	    }

}
