package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/add-strings/
========================================================================

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length()==0) 
            return num2;
        if(num2 == null || num2.length()==0)
            return num1;
        
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        
        int i = n1.length;
        int j = n2.length;
        int k = Math.max(i,j);
        
        char[] res = new char[k];
        int carry = 0;
        int sum = 0;
        
        i--; j--; //point to index of last element
        for(int x=k-1; x>=0; x--,j--,i--)
        {
            sum = carry;
            
            if(i>=0)
                sum += n1[i] - '0';
            if(j>=0)
                sum += n2[j] - '0';
            
            res[x] = (char)( (sum % 10) + (int)'0' );
            
            carry = sum / 10;               
        }
        
        String result = new String(res);
        if(carry!=0)
            result = carry + result;
        return result;
        
    }
    
    /* Concise solution from : https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
    */
}