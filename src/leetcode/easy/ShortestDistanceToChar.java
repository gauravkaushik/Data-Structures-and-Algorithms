package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/shortest-distance-to-a-character/
========================================================================

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
*/

public class ShortestDistanceToChar {
    public int[] shortestToChar(String S, char C) {
        if(S == null || S.length() == 0)
            return new int[0];
        
        char[] letters = S.toCharArray();
        int N = S.length();
        int[] result = new int[N];       
        
        //list of indices where C is present in S
        //List<Integer> cIndex = new LinkedList<>();
        int[] cIndex = new int[N];
        int c = 0;
        for(int i=0; i<N; i++)
        {
            if(letters[i] == C)
                cIndex[c++] = i;
        }
        
        //int[] temp = cIndex.toArray();
        
        //update min distance for each position
        for(int i=0; i<N; i++)
        {
            int min = N;
            int lb = lowerBound(cIndex, 0, c, i);
            if(lb > 0)            
                min = Math.min( min, Math.min ( Math.abs(i-cIndex[lb]), Math.abs(i-cIndex[lb-1]) ) );             
            else
                min = Math.min( min, Math.abs( i-cIndex[lb] ) );
            
            result[i] = min;            
        }
        
        return result;
        
    }
    
    //Returns the smalles index which has value less than or equal to the target
    int lowerBound( int[] nums, int low, int high, int target )
    {
        while(low < high)
        {
            int mid = ( low + high ) / 2;
            if( target <= nums[mid] )
                high = mid;
            else
                low = mid + 1;
        }
        
        return low;
    }
}