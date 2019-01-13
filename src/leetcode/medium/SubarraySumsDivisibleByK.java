package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/subarray-sums-divisible-by-k/
========================================================================

Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K. 

Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 

Note:
1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000

*/


/*
Reference : https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
*/

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {       
        
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        int cumSum = 0;
        int remainder = 0;
        mp.put(0,1);
        
        for(int i=0; i<A.length; i++)
        {
            cumSum += A[i];
            remainder = (cumSum % K) ;
            remainder = (remainder + K) % K; //to remove negative modulos
            mp.put(remainder, mp.getOrDefault(remainder,0) + 1);
        }
        
        int freq;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
            freq = entry.getValue();
            count += (freq * (freq-1) )/2;
        }
        
        return count;
        
    }
}