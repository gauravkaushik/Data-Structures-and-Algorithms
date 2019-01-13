package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/reverse-words-in-a-string/
========================================================================

Given an input string, reverse the string word by word.

Example:  
Input: "the sky is blue",
Output: "blue is sky the".

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        char[] cAry = s.toCharArray();
        
        //reverse the entire array
        int N = cAry.length;
        char temp;
        for(int i=0; i<N/2; i++)
        {
            temp = cAry[i];
            cAry[i] = cAry[N-i-1];
            cAry[N-i-1] = temp;
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        char c;
        
        for(int i=0; i<N; )
        {
            c = cAry[i];
            if(c != ' ')
            {
            	word.append(c);
            	i++;            	
            }
            else
            {
                result.append(word.reverse());
                word.setLength(0);
                result.append(" ");
                while(i < N && cAry[i]==' ')
                    i++;
                
            }
        }
        result.append(word.reverse());
        
        //remove the heading white space
        int len = result.length();
        if(len>0 && result.charAt(0) == ' ')
            result.deleteCharAt(0);
        
        //remove the trailing white space
        len = result.length();
        if(len > 0 && result.charAt(len-1) == ' ')
            result.deleteCharAt(len-1);
        return result.toString();
    }

}