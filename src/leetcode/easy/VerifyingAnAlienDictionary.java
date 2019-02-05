package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/verifying-an-alien-dictionary/
========================================================================

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '', where '' is defined as the blank character which is less than any other character (More info).
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.
*/

public class VerifyingAnAlienDictionary {
    
    int[] rank;
    public boolean isAlienSorted(String[] words, String order) {
        
        rank = new int[26];
        for(int i=0; i<26; i++)
        {
            char c = order.charAt(i);
            rank[c-'a'] = i;
        }      
        
        
        for(int i=0; i<words.length-1; i++)
        {
            if( compare(words[i], words[i+1]) > 0 )
                return false;            
        }
        
        return true;
    }
    
    private int compare(String A, String B)
    {
        int i=0,j=0;
        while(i<A.length() && j<B.length())
        {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(j) - 'a';
            if(rank[a] < rank[b])
                return -1;
            else if(rank[a] > rank[b])
                return 1;
            i++;
            j++;
        }
        if(i==A.length() && j==B.length())
            return 0;
        else if(i==A.length())
            return -1;
        else
            return 1;                    
    }
    
}