package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/smallest-string-starting-from-leaf/
========================================================================

Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)


Example 1:
Input: [0,1,2,3,4,3,4]
Output: "dba"

Example 2:
Input: [25,1,3,1,3,0,2]
Output: "adz"

Example 3:
Input: [2,2,1,null,1,0,null,0]
Output: "abc"
 

Note:
The number of nodes in the given tree will be between 1 and 1000.
Each node in the tree will have a value between 0 and 25.

*/

public class SmallestStringStartingFromLeaf {
    
    public String smallestFromLeaf(TreeNode root) {
        
        StringBuilder[] temp = new StringBuilder[2];
        temp[0] = new StringBuilder(""); //prefix is empty
        temp[1] = null; //smallest string is empty
        
        helper(root, temp);
        
        return temp[1].toString(); //helper method will store smallest string in temp[1]        
    }
    
    private void helper(TreeNode root, StringBuilder[] temp)
    {
        if(root == null)
            return;
        
        temp[0].insert(0, (char)('a'+root.val));
        
        if(root.left==null && root.right==null)
        {            
            if(temp[1]==null)
                temp[1] = new StringBuilder(temp[0].toString());
            else
            {              
                int flag = temp[0].toString().compareTo(temp[1].toString());
                if(flag<0)
                    temp[1] = new StringBuilder(temp[0].toString());
            }           
        }
        else
        {
            helper(root.left, temp);            
            helper(root.right, temp);            
        }       
        temp[0].deleteCharAt(0);
    }   
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}