package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/most-frequent-subtree-sum/
========================================================================

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

*/

public class MostFrequentSubtreeSum {
    
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        // Integer maxFreq = 0;
        
        traverse(root, mp, result);       
        
        int[] res = new int[result.size()];
        int i=0;
        for(int val : result)
            res[i++] = val;
        return res;
    }
    
    int traverse(TreeNode root, HashMap<Integer, Integer> mp, ArrayList<Integer> result)
    {
        if(root==null)
            return 0;
        int sum = root.val;
        sum += traverse(root.left, mp, result);
        sum += traverse(root.right, mp, result);
        
        int freq = 1 + mp.getOrDefault(sum,0);
        
        if(freq > maxFreq)
        {
            result.clear();
            result.add(sum);
            maxFreq = freq;
        }
        else if(freq == maxFreq)
            result.add(sum);
        
        mp.put(sum, freq);
        return sum;
    }
}