package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/convert-bst-to-greater-tree/
========================================================================
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        traverse(root,0);
        return root;
    }
    
    private int traverse(TreeNode root, int prev_sum)
    {
       if(root==null)
           return prev_sum;
        
        root.val += traverse(root.right, prev_sum);
        return traverse(root.left,root.val);
        
    }
    
    
 //Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 
}