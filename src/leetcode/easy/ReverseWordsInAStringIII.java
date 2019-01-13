package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/reverse-words-in-a-string-iii/
========================================================================

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if(s == null || s.length()<=1)
            return s;
        
        char[] arr = s.toCharArray();
        int last=0;
        char temp;
        int N;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==' ' || i==arr.length-1)
            {
                //reverse from index 'last' to index 'i-1'
                N = i - last; //N : number of elements
                if(i==arr.length-1)
                {
                    N = N+1;
                    i=i+1;
                }
                for(int j=0; j < N/2; j++)
                {
                    temp = arr[j+last];
                    arr[j+last] = arr[i-1-j];
                    arr[i-1-j] = temp;    
                }
                last = i+1; 
            }
        }        
        
        return new String(arr);
        
    }
    
    /*A more readable version from LeetCode solution : 
    public String reverseWords(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
    */
}